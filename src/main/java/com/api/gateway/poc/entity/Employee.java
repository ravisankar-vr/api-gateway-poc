package com.api.gateway.poc.entity;


import lombok.NoArgsConstructor;

@NoArgsConstructor
public class Employee {

    private Integer Id;
    private String firstName;
    private String lastName;

    private String email;

    private double salary;

    private String jobNm;
    private Department department;

    private Leave leave;

    public Employee(Integer id, String firstName, String lastName, String email, double salary, String jobNm, Department department, Leave leave) {
        Id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.salary = salary;
        this.jobNm = jobNm;
        this.department = department;
        this.leave = leave;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getJobNm() {
        return jobNm;
    }

    public void setJobNm(String jobNm) {
        this.jobNm = jobNm;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Leave getLeave() {
        return leave;
    }

    public void setLeave(Leave leave) {
        this.leave = leave;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "Id=" + Id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", salary=" + salary +
                ", jobNm='" + jobNm + '\'' +
                ", department=" + department +
                ", leave=" + leave +
                '}';
    }
}
