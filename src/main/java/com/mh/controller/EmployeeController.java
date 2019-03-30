package com.mh.controller;

import com.mh.pojo.Employee;
import com.mh.service.EmployeeService;
import com.mh.util.JsonMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.swing.*;
import java.awt.*;
import java.util.List;

@Controller
public class EmployeeController {

    private final int LIMIT = 5;

    @Autowired
    private EmployeeService employeeService;

    /**
     * 查询全部员工信息
     *
     * @param pageNo
     * @return
     */
    @RequestMapping("/getEmpList")
    public ModelAndView getEmp(@RequestParam(value = "pageNo", defaultValue = "1") Integer pageNo) {
        ModelAndView mv = new ModelAndView("employeePage");

        //设定改页码起始的数据条数
        int offset = (pageNo - 1) * LIMIT;

        //获取指定页中包含的员工信息
        List<Employee> employees = employeeService.getEmpList(offset, LIMIT);

        //获取总员工信息
        int totalItems = employeeService.getEmpCount();
        System.out.println(totalItems);

        //总页数
        int totalPages = (totalItems - 1) / LIMIT + 1;
        //当前页数
        int curPage = pageNo;

        //把查询结果放到Model中
        mv.addObject("employees", employees)
                .addObject("totalItems", totalItems)
                .addObject("totalPages", totalPages)
                .addObject("curPage", curPage);

        return mv;
    }

    /**
     * 删除员工
     *
     * @param empId
     * @return
     */
    @RequestMapping("deleteEmp/{empId}")
    @ResponseBody
    public JsonMsg deleteEmp(@PathVariable("empId") Integer empId) {
        int res = 0;
        if (empId > 0) {
            res = employeeService.deleteEmpById(empId);
        }
        if (res != 1) {
            return JsonMsg.fail().addInfo("emp_del_error", "员工删除失败");
        }
        return JsonMsg.success();
    }

    /**
     * 判断用户是否存在
     *
     * @param empName
     * @return
     */
    @RequestMapping("/checkEmpExists")
    @ResponseBody
    public JsonMsg checkEmpExists(@RequestParam("empName") String empName) {

        String regName = "(^[a-zA-Z0-9_-]{3,16}$)|(^[\\u2E80-\\u9FFF]{2,5})";
        if (!empName.matches(regName)) {
            return JsonMsg.fail().addInfo("name_reg_error", "输入姓名为2-5位中文或6-16位英文");
        }
        Employee employee = employeeService.getEmpByName(empName);
        if (employee != null) {
            return JsonMsg.fail().addInfo("name_reg_error", "用户名重复");
        } else {
            return JsonMsg.success();
        }
    }

    /**
     * 新增员工
     * @param employee
     * @return
     */
    @RequestMapping("/addEmp")
    @ResponseBody
    public JsonMsg addEmp(Employee employee) {
        System.out.println(employee.toString());
        int res = employeeService.addEmp(employee);
        if (res == 1) {
            return JsonMsg.success();
        } else return JsonMsg.fail();
    }

    @RequestMapping("/getTotalPages")
    @ResponseBody
    public JsonMsg getTotalPage() {
        int totalItems = employeeService.getEmpCount();

        int temp = totalItems / LIMIT;
        int totalPages = (temp - 1) * LIMIT + 1;
        return JsonMsg.success().addInfo("totalPages", totalPages);
    }

    @RequestMapping("/getEmpById/{empId}")
    @ResponseBody
    public JsonMsg getEmpById(@PathVariable("empId") Integer empId){
        Employee employee = employeeService.getEmpById(empId);
        if (employee != null) {
            return JsonMsg.success().addInfo("employee",employee);
        }else return JsonMsg.fail();
    }

    @RequestMapping(value = "/updateEmp/{empId}",method = RequestMethod.PUT)
    @ResponseBody
    public JsonMsg updateEmp(@PathVariable("empId") Integer empId, Employee employee){
        int res = employeeService.updateEmpById(empId,employee);
        if (res != 1) {
            return JsonMsg.fail().addInfo("emp_update_error","更改异常");
        }else return JsonMsg.success();
    }
}
