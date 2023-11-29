package com.api.gateway.poc.util;

import com.api.gateway.poc.entity.Employee;

import java.io.Serializable;
import java.util.List;

public class ObjectWrapper implements Serializable {
    private List<Employee> employees;

    public ObjectWrapper() {}

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    @Override
    public String toString() {
        return "ObjectWrapper{" +
                "employees=" + employees +
                '}';
    }
}
