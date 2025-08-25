package org.example.apifluxar.service;

import org.example.apifluxar.dto.EmployeeResponseDTO;
import org.example.apifluxar.dto.EmployeeRequestDTO;
import org.example.apifluxar.model.Employee;
import org.example.apifluxar.repository.EmployeeRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

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
        employee.setSetorId(employeeRequestDTO.getSetor_id());
        employee.setUnidadeId(employeeRequestDTO.getUnidade_id());
        return employee;
    }
    public EmployeeResponseDTO fromEmployeeResposeDTO(Employee employee) {
        EmployeeResponseDTO employeeReposeDTO = new EmployeeResponseDTO();
        employeeReposeDTO.setNome(employee.getNome());
        employeeReposeDTO.setSobrenome(employee.getSobrenome());
        employeeReposeDTO.setId(employee.getId());
        employeeReposeDTO.setSetor_id(employee.getSetorId());
        employeeReposeDTO.setUnidade_id(employee.getUnidadeId());
        return employeeReposeDTO;
    }

    public EmployeeResponseDTO getEmployeeById(long id) {
       Employee employee = employeeRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
       return fromEmployeeResposeDTO(employee);

    }

    public EmployeeResponseDTO getEmployeeByEmail(String email) {
        Employee employee = employeeRepository.findByEmail(email).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return fromEmployeeResposeDTO(employee);
    }

    public EmployeeResponseDTO login(EmployeeRequestDTO employeeRequestDTO) {
        Employee employee = fromEmployeeRequestDTO(employeeRequestDTO);
        employee = employeeRepository
                .findByEmailAndSenha(employee.getEmail(), employee.getSenha())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.UNAUTHORIZED));
        return fromEmployeeResposeDTO(employee);
    }
}
