package org.example.apifluxar.service;

import org.example.apifluxar.dto.EmployeeReposeDTO;
import org.example.apifluxar.dto.EmployeeRequestDTO;
import org.example.apifluxar.model.Employee;
import org.example.apifluxar.repository.EmployeeRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class EmployeeService {
    final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee fromEmployeeRequestDTO(EmployeeRequestDTO employeeRequestDTO) {
        Employee employee = new Employee();
        employee.setNome(employeeRequestDTO.getNome());
        employee.setSobrenome(employeeRequestDTO.getSobrenome());
        employee.setSenha(employeeRequestDTO.getSenha());
        employee.setEmail(employeeRequestDTO.getEmail());
        employee.setCargo(employeeRequestDTO.getCargo());
        employee.setSetor_id(employeeRequestDTO.getSetor_id());
        employee.setUnidade_id(employeeRequestDTO.getUnidade_id());
        return employee;
    }
    public EmployeeReposeDTO fromEmployeeResposeDTO(Employee employee) {
        EmployeeReposeDTO employeeReposeDTO = new EmployeeReposeDTO();
        employeeReposeDTO.setNome(employee.getNome());
        employeeReposeDTO.setSobrenome(employee.getSobrenome());
        employeeReposeDTO.setEmail(employee.getEmail());
        employeeReposeDTO.setCargo(employee.getCargo());
        employeeReposeDTO.setId(employee.getId());
        employeeReposeDTO.setSetor_id(employee.getSetor_id());
        employeeReposeDTO.setUnidade_id(employee.getUnidade_id());
        return employeeReposeDTO;
    }

    public EmployeeReposeDTO getEmployeeById(long id) {
       Employee employee = employeeRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
       return fromEmployeeResposeDTO(employee);

    }

    public  EmployeeReposeDTO getEmployeeByEmail(String email) {
        Employee employee = employeeRepository.findByEmail(email).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return fromEmployeeResposeDTO(employee);
    }

    public EmployeeReposeDTO login(EmployeeRequestDTO employeeRequestDTO) {
        Employee employee = fromEmployeeRequestDTO(employeeRequestDTO);
        employee = employeeRepository
                .findByEmailAndSenha(employee.getEmail(), employee.getSenha())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.UNAUTHORIZED));
        return fromEmployeeResposeDTO(employee);
    }
}
