package com.api.gateway.poc.entity;


import lombok.NoArgsConstructor;

@NoArgsConstructor
public class Department {

    private Integer departmentId;

    private String deptName;

    public Department(Integer departmentId, String deptName) {
        this.departmentId = departmentId;
        this.deptName = deptName;
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    @Override
    public String toString() {
        return "Department{" +
                "departmentId=" + departmentId +
                ", deptName='" + deptName + '\'' +
                '}';
    }
}
