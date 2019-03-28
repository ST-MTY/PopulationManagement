package com.mh.controller;

import com.mh.pojo.Department;
import com.mh.service.DepartmentService;
import com.mh.util.JsonMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @RequestMapping("/getDeptName")
    @ResponseBody
    public JsonMsg getDeptName(){
        List<Department> departments = departmentService.getAllDept();
        if (departments != null) {
            return JsonMsg.success().addInfo("departmentList",departments);
        }else return JsonMsg.fail();
    }
}
