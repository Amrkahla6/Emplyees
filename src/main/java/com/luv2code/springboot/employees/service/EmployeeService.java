package com.luv2code.springboot.employees.service;

import com.luv2code.springboot.employees.entity.Employee;
import com.luv2code.springboot.employees.request.EmployeeRequest;

import java.util.List;

public interface EmployeeService {

    List<Employee> findAll();
    Employee findById(long id);
    Employee save(EmployeeRequest theEmployeeRequest);
    Employee update(Long id,EmployeeRequest theEmployeeRequest);
    Employee convertToEmployee(Long id, EmployeeRequest theEmployeeRequest);
    void deleteById(long id);
}
