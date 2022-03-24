package com.migranov.springbootdatajpa.service;


import com.migranov.springbootdatajpa.dao.EmployeeRepasitory;
import com.migranov.springbootdatajpa.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImp implements EmployeeService{
    @Autowired
    private EmployeeRepasitory employeeRepasitory;

    @Override
    public List<Employee> getAllEmployees() {

        return employeeRepasitory.findAll();
    }

   @Override
    public void saveEmployee(Employee employee) {
        employeeRepasitory.save(employee);
    }

    @Override
    public Employee getEmployee(int id) throws Exception {
        Employee employee=null;
        Optional<Employee> optional=employeeRepasitory.findById(id);
        if(optional.isPresent()){
            employee=optional.get();
        }
        else {
            throw new Exception();
        }

        return employee;
    }

    @Override
    public void deleteEmployee(int id) {
        employeeRepasitory.deleteById(id);
    }

    @Override
    public List<Employee> findAllByName(String name) {
        List<Employee> employees=employeeRepasitory.findAllByName(name);
        return employees;
    }


}
