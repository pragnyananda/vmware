package com.example.vmw.repository;

import com.example.vmw.model.Employees;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeesRepository extends JpaRepository<Employees,Long> {
}
