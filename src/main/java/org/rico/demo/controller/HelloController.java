package org.rico.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.rico.demo.domain.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Rico.Chen on 2017/2/22.
 */
@Controller
@Slf4j
public class HelloController {



    @RequestMapping("/")
    @ResponseBody
    public String hello() {oiuoiuouoiuoiou;

        log.info("----调试----");
        return "Hello, Spring boot.";
    }

//    @RequestMapping(value = "/indexp",method = RequestMethod.GET)
//    public String toIndex(ModelMap modelMap) {
//       Student student = new Student(1L, "tom", 20);
//        modelMap.put("student", student);
//        return "index";
//    }
}
