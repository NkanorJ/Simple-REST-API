package com.learning.restapi.employeeRestApi.controller;

import com.learning.restapi.employeeRestApi.model.Employee;
import com.learning.restapi.employeeRestApi.repository.EmployeeRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeRepository employeeRepository;

    public EmployeeController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @GetMapping
    public List<Employee> allEmployees() {
        return employeeRepository.findAll();

    }

    @GetMapping("/{id}")
    public Employee viewEmployee(@PathVariable Integer id) {
        return employeeRepository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Employee not found for id: " + id));

    }

    @PostMapping
    public Employee createEmployee(@RequestBody Employee emp) {
        Employee empDB = employeeRepository.findById(emp.getId()).orElse(null);

        if(empDB != null){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Employee already exists for id:" + emp.getId());

        }

        return employeeRepository.save(emp);

    }

    @PutMapping
    public Employee updateEmployee(@RequestBody Employee emp) {
        Employee empDB = employeeRepository.findById(emp.getId()).orElse(null);

        if(empDB == null){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Employee not found for id:" + emp.getId());

        }

        return employeeRepository.save(emp);

    }

    @DeleteMapping("/{id}")
    public List<Employee> deleteEmployee(@PathVariable Integer id) {
        Employee empDB = employeeRepository.findById(id).orElse(null);

        if(empDB == null){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Employee not found for id:" + id);

        }
        employeeRepository.deleteById(id);

        return employeeRepository.findAll();
    }


}
