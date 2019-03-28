package com.mh.pojo;

public class Department {
    private Integer deptId;
    private String deptName;
    private String deptLeader;

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getDeptLeader() {
        return deptLeader;
    }

    public void setDeptLeader(String deptLeader) {
        this.deptLeader = deptLeader;
    }

    public Department() {
    }

    public Department(Integer deptId, String deptName, String deptLeader) {
        this.deptId = deptId;
        this.deptName = deptName;
        this.deptLeader = deptLeader;
    }
}
