package com.mh.controller;

import com.mh.pojo.Department;
import com.mh.service.DepartmentService;
import com.mh.util.JsonMsg;
import com.sun.org.apache.bcel.internal.generic.LMUL;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class DepartmentController {

    private final int LIMIT = 5;

    @Autowired
    private DepartmentService departmentService;

    @RequestMapping("/getDeptList")
    public ModelAndView getDeptList(@RequestParam(value = "pageNo", defaultValue = "1") int pageNo) {
        ModelAndView mv = new ModelAndView("departmentPage");

        int offset = (pageNo - 1) * LIMIT;

        List<Department> departments = departmentService.getDeptList(offset, LIMIT);

        int totalItems = departmentService.getDeptCount();
        int totalPages = (totalItems - 1) / LIMIT + 1;

        mv.addObject("curPageNo", pageNo)
        .addObject("totalPages", totalPages)
        .addObject("totalItems", totalItems)
        .addObject("departments",departments);

        return mv;

    }

    @RequestMapping("/getDeptName")
    @ResponseBody
    public JsonMsg getDeptName() {
        List<Department> departments = departmentService.getAllDept();
        if (departments != null) {
            return JsonMsg.success().addInfo("departmentList", departments);
        } else return JsonMsg.fail();
    }

    @RequestMapping("/addDept")
    @ResponseBody
    public JsonMsg addDept(Department department){
        int res = departmentService.addDept(department);
        if (res == 1)
            return JsonMsg.success();
        else return JsonMsg.fail().addInfo("add_dept_error","添加失败！");
    }

    @RequestMapping(value = "/delDept/{deptId}",method = RequestMethod.DELETE)
    @ResponseBody
    public JsonMsg delDept(@PathVariable("deptId") int deptId){
        int res = 0;

        if (deptId > 0) {
            res = departmentService.deleteDeptById(deptId);
        }

        if (res == 1) {
            return JsonMsg.success();
        }else return JsonMsg.fail().addInfo("del_dept_error","删除失败！");
    }
}
