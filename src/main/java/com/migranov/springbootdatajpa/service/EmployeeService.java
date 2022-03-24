package com.migranov.springbootdatajpa.service;




import com.migranov.springbootdatajpa.entity.Employee;

import java.util.List;

public interface EmployeeService {
    public List<Employee> getAllEmployees();
    public void saveEmployee(Employee employee);
    public Employee getEmployee(int id) throws Exception;
    public void deleteEmployee(int id);
    public List<Employee> findAllByName(String name);
}
