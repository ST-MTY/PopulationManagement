package com.mh.service.impl;

import com.mh.mapper.DepartmentMapper;
import com.mh.pojo.Department;
import com.mh.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Resource
    private DepartmentMapper departmentMapper;

    @Override
    public int deleteDeptById(Integer deptId) {
        return departmentMapper.deleteDeptById(deptId);
    }

    @Override
    public int updateDeptById(Integer deptId, Department department) {
        return departmentMapper.updateDeptById(deptId,department);
    }

    @Override
    public int addDept(Department department) {
        return departmentMapper.insertDept(department);
    }

    @Override
    public int getDeptCount() {
        return departmentMapper.countDept();
    }

    @Override
    public List<Department> getDeptList(Integer offset, Integer limit) {
        return departmentMapper.selectDeptsByLimitAndOffset(offset,limit);
    }

    @Override
    public Department getDeptById(Integer deptId) {
        return departmentMapper.selectDeptById(deptId);
    }

    @Override
    public Department getDeptByLeader(String deptLeader) {
        return departmentMapper.selectDeptByLeader(deptLeader);
    }

    @Override
    public Department getDeptByName(String deptName) {
        return departmentMapper.selectDeptByName(deptName);
    }

    @Override
    public List<Department> getAllDept() {
        return departmentMapper.selectAllDept();
    }
}
