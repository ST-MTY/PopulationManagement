package com.mh.service.impl;

import com.mh.mapper.EmployeeMapper;
import com.mh.pojo.Employee;
import com.mh.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Resource
    private EmployeeMapper employeeMapper;

    @Override
    public int deleteEmpById(Integer empId) {
        return employeeMapper.deleteEmpById(empId);
    }

    @Override
    public int updateEmpById(Integer empId, Employee employee) {
        return employeeMapper.updateEmpById(empId,employee);
    }

    @Override
    public int addEmp(Employee employee) {
        return employeeMapper.insertEmp(employee);
    }

    @Override
    public int getEmpCount() {
        return employeeMapper.countEmp();
    }

    @Override
    public Employee getEmpById(Integer empId) {
        return employeeMapper.selectOneById(empId);
    }

    @Override
    public Employee getEmpByName(String empName) {
        return employeeMapper.selectOneByName(empName);
    }

    @Override
    public List<Employee> getEmpList(Integer offset, Integer limit) {
        return employeeMapper.selectByLimitAndOffset(offset,limit);
    }

    @Override
    public Employee getEmpWithDept(Integer empId) {
        return employeeMapper.selectWithDeptById(empId);
    }
}
