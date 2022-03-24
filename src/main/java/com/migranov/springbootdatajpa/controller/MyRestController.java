package com.migranov.springbootdatajpa.controller;


import com.migranov.springbootdatajpa.entity.Employee;
import com.migranov.springbootdatajpa.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MyRestController {

    private final EmployeeService employeeService;

    @Autowired
    public MyRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public List<Employee> showAllEmployees(){
        List<Employee> allemployees=employeeService.getAllEmployees();
        return allemployees;
    }

    @GetMapping("/employees/name/{name}")
    public List<Employee> showAllEmployeesByName(@PathVariable String name){
        List<Employee> employees=employeeService.findAllByName(name);
        return employees;
    }

    @GetMapping("/employees/{id}")
    public Employee getEmployee(@PathVariable int id){

        Employee employee= null;
        try {
            employee = employeeService.getEmployee(id);
        } catch (Exception e) {

        }

        return employee;
    }
    @PostMapping("/employees")
    public Employee addNewEmployee(@RequestBody Employee employee){
        employeeService.saveEmployee(employee);
        return employee;
    }
    @PutMapping("/employees")
    public Employee update(@RequestBody Employee employee){
       employeeService.saveEmployee(employee);
       return  employee;
    }
    @DeleteMapping("/employees/{id}")
    public String delete(@PathVariable int id){
        try {
            Employee employee=employeeService.getEmployee(id);
        } catch (Exception e) {
            e.printStackTrace();
        }

        employeeService.deleteEmployee(id);
        return "Employee with id: "+id+" was deleted";

    }



}
