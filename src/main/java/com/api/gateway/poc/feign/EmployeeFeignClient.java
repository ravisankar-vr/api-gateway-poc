package com.api.gateway.poc.feign;

import com.api.gateway.poc.config.FeignConfiguration;
import com.api.gateway.poc.entity.Employee;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "employee-service", url = "http://localhost:8081", configuration = FeignConfiguration.class)
public interface EmployeeFeignClient {
    @GetMapping("/v1/api/employees-list/{pageNo}/{pageSize}")
    List<Employee> getAllEmployees(@PathVariable("pageNo") int pageNo, @PathVariable("pageSize") int pageSize);

}
