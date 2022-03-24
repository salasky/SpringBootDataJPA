package com.migranov.springbootdatajpa.dao;



import com.migranov.springbootdatajpa.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface EmployeeRepasitory extends JpaRepository<Employee,Integer>{
    public List<Employee> findAllByName(String name);
}