package com.greatlearning.emr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.greatlearning.emr.entity.Employee;
import com.greatlearning.emr.service.EmployeeService;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PreAuthorize("hasAuthority('ADMIN_USER')")
    @PostMapping("/add")
    public Employee addEmployee(@RequestBody Employee employee) {
        return employeeService.save(employee);
    }

    @GetMapping("/list")
    public List<Employee> listEmployees() {
        return employeeService.findAll();
    }

    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable int id) {
        return employeeService.findById(id);
    }

    @PreAuthorize("hasAuthority('ADMIN_USER')")
    @PutMapping("/update")
    public Employee updateEmployee(@RequestBody Employee employee) {
        return employeeService.save(employee);
    }

    @PreAuthorize("hasAuthority('ADMIN_USER')")
    @DeleteMapping("/{id}")
    public String deleteEmployee(@PathVariable int id) {
        employeeService.deleteById(id);
        return "Deleted employee id - " + id;
    }

    @GetMapping("/search/{firstName}")
    public List<Employee> searchEmployeeByFirstName(@PathVariable String firstName) {
        return employeeService.findByFirstName(firstName);
    }

    @GetMapping("/sort")
    public List<Employee> sortEmployees(@RequestParam String order) {
        return employeeService.sortByFirstName(order);
    }
}