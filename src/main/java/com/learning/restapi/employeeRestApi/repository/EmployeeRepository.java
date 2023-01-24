package com.learning.restapi.employeeRestApi.repository;

import com.learning.restapi.employeeRestApi.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}