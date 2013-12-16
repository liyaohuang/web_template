package com.b5m.opsupport.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.b5m.opsupport.bean.model.Student;
import com.b5m.opsupport.service.StudentService;

/**
 * 解释:@Controller注解标识一个控制器，@RequestMapping注解标记一个访问的路径（/test1.htm），return "test/abc"标记返回视图（test/abc.jsp）；
 * */
@Controller
@RequestMapping("/parenturi")
public class IndexController {
	//private static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger("mylogger");
	private static final Logger logger = LoggerFactory.getLogger("mylogger");
	
	@Autowired
	private StudentService studentService;  //Autowired按照type类型注入   Resource是按照spring配置ID注入
	
    @RequestMapping("/test1")
    public String abc() {
        return "test/abc";
    }
    
    @RequestMapping("/test2/{username}/{pwd}")
    public String ddd(@PathVariable("username") String username, @PathVariable("pwd") String def, HttpServletRequest request, HttpServletResponse response) {
    	MDC.put("queryUrl", request.getRequestURI());
    	MDC.put("username", "lirongji");
    	
    	logger.info(username+"\t");
    	logger.info("[" + def + "]");
        return "test/abc";
    }
    
    @RequestMapping("/addStu")
    public String addStu() {
    	Student stu = new Student();
    	stu.setName("abc");
    	stu.setScore(60.5f);
    	studentService.insertStudent(stu);
        return "test/abc";
    }
    
    @RequestMapping("/getStu")
    public String getStu() {
    	Student stu = studentService.selectStudent(1);
    	logger.info(stu.getName() + "  " + stu.getScore());
        return "test/abc";
    }
}
