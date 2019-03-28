package com.mh.service;

import com.mh.pojo.Employee;

import java.util.List;

/**
 * 与职员相关的业务
 */
public interface EmployeeService {

    /**
     * 通过Id删除职员
     * @param empId
     * @return
     */
    int deleteEmpById(Integer empId);

    /**
     * 通过id更新职员信息
     * @param empId
     * @param employee
     * @return
     */
    int updateEmpById(Integer empId, Employee employee);

    /**
     * 添加一个职员信息
     * @param employee
     * @return
     */
    int addEmp(Employee employee);

    /**
     * 获取职员的数量
     * @return
     */
    int getEmpCount();

    /**
     * 通过id获取职员信息
     * @param empId
     * @return
     */
    Employee getEmpById(Integer empId);

    /**
     * 通过姓名获取职员信息
     * @param empName
     * @return
     */
    Employee getEmpByName(String empName);

    /**
     * 分页查询，返回该页的所有职员信息
     * @param offset
     * @param limit
     * @return
     */
    List<Employee> getEmpList(Integer offset, Integer limit);

    /**
     * 获取职员信息和职员所在的部门信息
     * @param empId
     * @return
     */
    Employee getEmpWithDept(Integer empId);


}
