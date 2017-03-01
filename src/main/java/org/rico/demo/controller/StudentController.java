package org.rico.demo.controller;

import com.sun.org.apache.xpath.internal.operations.Mod;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.rico.demo.Service.StudentService;
import org.rico.demo.domain.Student;
import org.rico.demo.repository.StudentCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rico.Chen on 2017/2/22.
 */
@Controller
@Slf4j
public class StudentController {

    @Autowired
    private StudentService studentService;
    @Autowired
    private StudentCrudRepository stuCrudRe;


    @RequestMapping(value = "/index", method = RequestMethod.GET)
    //根据ID查询
    public String toIndex(ModelMap modelMap) {
       /* Student student = this.studentService.getStudent(9L);
        modelMap.put("student", student);*/
        Student student=this.studentService.getStudent(9L);
        log.info(student.toString()+"--------------");
        modelMap.put("student",student);

        return "index";
    }
    //查询所有
    @RequestMapping("/allStudents")
    public String findAll(ModelMap modelMap){
        List<Student> list=this.studentService.allStudents();
        log.info(list.toString());

        modelMap.put("students",list);
        return "student/index";
    }

    //增加页面
    @RequestMapping("/addStudent")
    public String addStudent(){
        return "student/create";
    }

    //增加一名学生返回主页
    @RequestMapping("/studentCreate")
    public String addStudent(String name, int age){
        Student stu=new Student();
        stu.setName(name);
        stu.setAge(age);
        log.info(stu.toString());
        studentService.addStudent(stu);
        return "redirect:student/index";
    }


    //删除学生
    @RequestMapping("/delete/{id}")
    public String move(@PathVariable("id") long id){
    log.info("--------删除-------"+id);
    this.studentService.delete(id);
    System.out.println("----------");
    return "redirect:/student/index";
    }

    //修改
    @GetMapping("/modify/{id}")
    public String modify (@PathVariable("id") Long id,ModelMap modelMap){
        System.out.println("。。。。。。");
        Student stu=this.studentService.getStudent(id);
        if(stu==null){
            return "error";
        }
        modelMap.put("student",stu);
        return "student/modify";
    }
    @RequestMapping("/modifyStudent")
    public String revise(String name,int age){
        Student stu=new Student(name,age);
        log.info(stu.toString());
        this.studentService.addStudent(stu);

        return "redirect:/student/index";
    }

    //分页查询
    @RequestMapping("/student/index")
    public String indexpage(String  pageString,ModelMap map) {
        int page;
        int size = 3;
        Long count = this.stuCrudRe.count();
        Long pagerCount = (count + size - 1) / size;
        if(pageString==null){
            page=1;
            Page<Student> list = this.studentService.getStudents(page, size);
            log.info(list.toString());
            log.info("--------没输入pageNo---------");
            map.put("students", list);
            map.put("pageNo",page);
            map.put("pagerCount",pagerCount);
            map.put("size",size);

            return "student/index";
        }

        page=Integer.parseInt(pageString);

        if (page <= 0) {
            page = 1;
            Page<Student> list = this.studentService.getStudents(page, size);
            log.info(list.toString());
            log.info("---------小于0时--------");
            map.put("students", list);
            map.put("pageNo",page);
            map.put("pagerCount",pagerCount);
            map.put("size",size);
            return "student/index";
        }
        if (page > pagerCount) {
            page = pagerCount.intValue();
            Page<Student> list = this.studentService.getStudents(page, size);
            log.info(list.toString());
            log.info("-------大于实际页数----------");
            map.put("students", list);
            map.put("pageNo",page);
            map.put("pagerCount",pagerCount);
            map.put("size",size);06
            return "student/index";

        }
        if(page<=pagerCount&&page>0){
            Page<Student> list = this.studentService.getStudents(page, size);
            log.info(list.toString());
            log.info("-------在合理范围之类----------");
            map.put("students", list);
            map.put("pageNo",page);
            map.put("pagerCount",pagerCount);
            map.put("size",size);
            return "student/index";

        }
        return "error";
    }
}
