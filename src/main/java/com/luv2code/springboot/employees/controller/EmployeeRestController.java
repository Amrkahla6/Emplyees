package com.luv2code.springboot.employees.controller;

import com.luv2code.springboot.employees.dao.EmployeeDao;
import com.luv2code.springboot.employees.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeRestController {

    private EmployeeDao  employeeDao;

    @Autowired
    public EmployeeRestController(EmployeeDao theEmployeeDao) {
        employeeDao = theEmployeeDao;
    }

    @GetMapping()
    public List<Employee>  findAll() {
        return employeeDao.findAll();
    }
}
