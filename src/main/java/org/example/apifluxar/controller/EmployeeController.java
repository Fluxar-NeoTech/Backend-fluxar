package org.example.apifluxar.controller;

import org.example.apifluxar.model.Employee;
import org.example.apifluxar.service.EmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/employee")
public class EmployeeController {
    final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    @GetMapping("search/{id}")
    public ResponseEntity<Employee> selectId(@PathVariable long id) {
        Employee res =  employeeService.getEmployeeById(id);
        return ResponseEntity.ok(res);
    }

    @PostMapping("/login")
    public ResponseEntity<Employee> login(@RequestBody Employee employee) {
        Employee res =  employeeService.login(employee);
        return ResponseEntity.ok(res);
    }

}
