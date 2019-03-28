package com.mh.mapper;

import com.mh.pojo.Employee;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface EmployeeMapper {

    String TABLE_NAME = "t_emp";
    String INSERT_FIELDS = "emp_name, emp_email,gender,department_id";
    String SELECT_FIELDS = "emp_id" + INSERT_FIELDS;

    @Delete({"delete from", TABLE_NAME, "where emp_id=#{empId}"})
    int deleteEmpById(@Param("empId") Integer empId);

    @Insert({"insert into", TABLE_NAME, "(", INSERT_FIELDS, ")", "values(#{employee.empName},#{employee.empEmail},#{employee.gender},#{employee.departmentId})"})
    int insertEmp(@Param("employee") Employee employee);

    int updateEmpById(@Param("empId") Integer empId, @Param("employee") Employee employee);

    Employee selectOneById(@Param("empId") Integer empId);

    Employee selectOneByName(@Param("empName") String empName);

    Employee selectWithDeptById(@Param("empId") Integer empId);

    List<Employee> selectByLimitAndOffset(@Param("offset") Integer offset, @Param("limit") Integer limit);

    @Select({"select count(*) from "+TABLE_NAME})
    int countEmp();

}
