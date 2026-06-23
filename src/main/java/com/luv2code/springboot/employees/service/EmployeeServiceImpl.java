package com.luv2code.springboot.employees.service;

import com.luv2code.springboot.employees.dao.EmployeeDao;
import com.luv2code.springboot.employees.entity.Employee;
import com.luv2code.springboot.employees.request.EmployeeRequest;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeDao  employeeDao;

    @Autowired
    public EmployeeServiceImpl(EmployeeDao theEmployeeDao) {
        employeeDao = theEmployeeDao;
    }

    @Override
    public List<Employee> findAll() {
        return employeeDao.findAll();
    }

    @Override
    public Employee findById(long id) {
        return employeeDao.findById(id);
    }

    @Transactional
    @Override
    public Employee save(EmployeeRequest theEmployeeRequest) {
        Employee employee = convertToEmployee(null,theEmployeeRequest);
        return employeeDao.save(employee);
    }

    @Transactional
    @Override
    public Employee update(Long id, EmployeeRequest theEmployeeRequest) {
        Employee employee = convertToEmployee(id,theEmployeeRequest);
        return employeeDao.save(employee);
    }

    @Override
    public Employee convertToEmployee(Long id, EmployeeRequest theEmployeeRequest) {
        return new Employee(id,theEmployeeRequest.getFirstName(),theEmployeeRequest.getLastName(),theEmployeeRequest.getEmail());
    }

    @Transactional
    @Override
    public void deleteById(long id) {
        employeeDao.deleteById(id);
    }
}
