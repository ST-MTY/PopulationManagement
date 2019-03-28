package com.mh.mapper;

import com.mh.pojo.Department;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface DepartmentMapper {

    String TABLE_NAME = "t_dept";
    String INSERT_FIELDS = "dept_name, dept_leader";
    String SELECT_FIELDS = "dept_id deptId, dept_name deptName, dept_leader deptLeader";

    /**
     * 删除
     */
    @Delete("delete from " + TABLE_NAME + " where id = #{deptId}")
    int deleteDeptById(@Param("deptId") Integer deptId);

    /**
     * 更新
     */
    int updateDeptById(@Param("deptId") Integer deptId, @Param("department") Department department);

    /**
     * 插入
     */
    @Insert("insert into " + TABLE_NAME + " values(" + INSERT_FIELDS + ")" + "values(#{department.deptName},#{department.leader}")
    int insertDept(Department department);



    @Select({"select",SELECT_FIELDS,"from",TABLE_NAME,"where dept_id=#{deptId}"})
    Department selectDeptById(@Param("deptId") Integer deptId);
    @Select({"select"+SELECT_FIELDS,"from",TABLE_NAME,"where dept_leader=#{deptLeader}"})
    Department selectDeptByLeader(@Param("deptLeader") String deptLeader);
    @Select({"select",SELECT_FIELDS,"from",TABLE_NAME,"where dept_name=#{deptName}"})
    Department selectDeptByName(@Param("deptName") String deptName);
    @Select({"select", SELECT_FIELDS,"from", TABLE_NAME})
    List<Department> selectAllDept();
    @Select({"select count(*) from", TABLE_NAME,"where dept_name=#{deptName} and dept_leader=#{deptLeader}"})
    int checkDeptExistByNameAndLeader(String deptName, String deptLeader);

    List<Department> selectDeptsByLimitAndOffset(@Param("offset") Integer offset, @Param("limit") Integer limit);

    @Select({"select count(*) from", TABLE_NAME})
    int countDept();
}
