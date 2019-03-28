package com.mh.service;

import com.mh.pojo.Department;

import java.util.List;

/**
 * 部门相关的业务
 */
public interface DepartmentService {

    /**
     * 通过id删除一个部门
     * @param deptId
     * @return
     */
    int deleteDeptById(Integer deptId);

    /**
     * 通过id更新部门信息
     * @param deptId
     * @param department
     * @return
     */
    int updateDeptById(Integer deptId, Department department);

    /**
     * 添加一个部门信息
     * @param department
     * @return
     */
    int addDept(Department department);

    /**
     * 获取部门数量
     * @return
     */
    int getDeptCount();

    /**
     * 分组查询部门信息
     * @param offset
     * @param limit
     * @return
     */
    List<Department> getDeptList(Integer offset,Integer limit);

    /**
     * 通过id获取部门信息
     * @param deptId
     * @return
     */
    Department getDeptById(Integer deptId);

    /**
     * 通过部门领导人获取部门信息
     * @param deptLeader
     * @return
     */
    Department getDeptByLeader(String deptLeader);

    /**
     * 通过部门名获取部门信息
     * @param deptName
     * @return
     */
    Department getDeptByName(String deptName);

    /**
     * 获取所有的部门信息
     * @return
     */
    List<Department> getAllDept();

}
