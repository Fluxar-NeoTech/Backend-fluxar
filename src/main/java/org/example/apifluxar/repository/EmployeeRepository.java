package org.example.apifluxar.repository;

import org.example.apifluxar.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Optional<Employee> findByEmailAndSenha(String email, String senha);
    Optional<Employee> findByEmail(String email);

}
