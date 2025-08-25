package org.example.apifluxar.controller;

import org.example.apifluxar.dto.EmployeeReposeDTO;
import org.example.apifluxar.dto.EmployeeRequestDTO;
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
    public ResponseEntity<EmployeeReposeDTO> selectId(@PathVariable long id) {
         EmployeeReposeDTO res =  employeeService.getEmployeeById(id);
        return ResponseEntity.ok(res);
    }

    @GetMapping("search/email/{email}")
    public ResponseEntity<EmployeeReposeDTO> selectEmail(@PathVariable String email) {
        EmployeeReposeDTO res =  employeeService.getEmployeeByEmail(email);
        return ResponseEntity.ok(res);
    }

    @PostMapping("/login")
    public ResponseEntity<EmployeeReposeDTO> login(@RequestBody EmployeeRequestDTO employeeRequestDTO) {
        EmployeeReposeDTO res =  employeeService.login(employeeRequestDTO);
        return ResponseEntity.ok(res);
    }

}
