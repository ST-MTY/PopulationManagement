package com.mh.controller;

import com.mh.service.DepartmentService;
import com.mh.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Test {

    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private DepartmentService departmentService;

    @RequestMapping("/test")
    public String testDB(){
        System.out.println(employeeService.getEmpCount());
        return "login";
    }
}
