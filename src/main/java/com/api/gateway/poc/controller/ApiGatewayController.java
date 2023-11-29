package com.api.gateway.poc.controller;


import com.api.gateway.poc.entity.Employee;
import com.api.gateway.poc.entity.Leave;
import com.api.gateway.poc.feign.EmployeeFeignClient;
import com.api.gateway.poc.feign.LeaveFeignClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ApiGatewayController {
    @Autowired
    private EmployeeFeignClient employeeFeignClient;

    @Autowired
    private LeaveFeignClient leaveFeignClient;

    Logger LOGGER = LoggerFactory.getLogger(WebController.class);

    public List<Employee> getAllEmp(int pageNo, int pageSize) {
        LOGGER.info("In APIGateway RestController - to fetch Employee Details through FeignClient");
        return employeeFeignClient.getAllEmployees(pageNo, pageSize);
    }

    public Leave getEmployeeLeave(int leaveId) {
        LOGGER.info("In APIGateway RestController - to fetch Leave Details through FeignClient");
        return leaveFeignClient.getEmployeeLeave(leaveId);
    }


}
