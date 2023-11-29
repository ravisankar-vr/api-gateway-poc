package com.api.gateway.poc.controller;

import com.api.gateway.poc.entity.Employee;
import com.api.gateway.poc.entity.Leave;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;


@Controller
public class WebController {

    Logger LOGGER = LoggerFactory.getLogger(WebController.class);

    private static final int PAGE_SIZE = 5;
    private static final int PAGE_NO = 1;
    @Autowired
    private ApiGatewayController apiGatewayController;

    @GetMapping("/")
    public String getEmployeeView(Model model) {
        return findPaginated(model, PAGE_NO);
    }

    @GetMapping("/page/{pageNo}")
    public String findPaginated(Model model, @PathVariable("pageNo") int pageNo) {
        LOGGER.info("In APIGateway WebController - About to fetch Employee details");

        List<Employee> listEmployee = apiGatewayController.getAllEmp(pageNo, PAGE_SIZE);

        LOGGER.info("listEmployee > "+listEmployee);
       /* ResponseEntity<Page<Employee>> responseObj = apiGatewayController.getAllEmp(pageNo, PAGE_SIZE);
        Page<Employee> page=responseObj.getBody();
        List<Employee> listEmployee = page.getContent();*/
        int totalSize = listEmployee.size();
        int startIndex = pageNo * PAGE_SIZE;
        int endIndex = Math.min(startIndex + PAGE_SIZE, totalSize);

        List<Employee> pageContent = listEmployee.subList(startIndex, endIndex);
        Page<Employee> employeePage = new PageImpl<>(pageContent, PageRequest.of(pageNo, PAGE_SIZE), totalSize);

        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", employeePage.getTotalPages());
        model.addAttribute("totalItems", employeePage.getTotalElements());
        model.addAttribute("listemployees", listEmployee);
        return "index";
    }

    /*@GetMapping("/leaves/{id}")
    public String getEmployeeLeaveDetails(@PathVariable int id, Model model) {
        System.out.println("in leaves Api Call");
        Leave leave = apiGatewayController.getEmployeeLeave(id);
        model.addAttribute("leave", leave);
        return "employee-details :: modalContent"; // Thymeleaf fragment for the modal content
    }*/

    @GetMapping("/leaves/{id}")
    public ResponseEntity<Leave> getLeaveData(@PathVariable int id, Model model) {

        LOGGER.info("In APIGateway WebController - About to fetch Leave details");
        // Make your Leave Management API call here
        // Return the data in a format suitable for your modal content
        // For simplicity, returning a string in this example
        String leaveData = "Leave data for Employee ID: " + id;
        System.out.println(leaveData);
        Leave leave = apiGatewayController.getEmployeeLeave(id);
        System.out.println("Leave Id : "+leave.getLeaveId()+" | Leave Type : "+leave.getLeaveType()+" | Total Leaves : "+leave.getTotalLeaves());
        model.addAttribute("leave", leave);
        return ResponseEntity.ok(leave);
    }
}
