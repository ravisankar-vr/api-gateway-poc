package com.api.gateway.poc.feign;

import com.api.gateway.poc.config.FeignConfiguration;
import com.api.gateway.poc.entity.Employee;
import com.api.gateway.poc.entity.Leave;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "leave-service", url = "http://localhost:8082", configuration = FeignConfiguration.class)
public interface LeaveFeignClient {

    @GetMapping("/v1/api/leaves/{leaveId}")
    Leave getEmployeeLeave(@PathVariable("leaveId") int leaveId);
}
