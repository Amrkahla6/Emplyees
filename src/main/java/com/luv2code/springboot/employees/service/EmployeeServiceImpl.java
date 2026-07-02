package com.luv2code.springboot.employees.service;

import com.luv2code.springboot.employees.dao.EmployeeRepository;
import com.luv2code.springboot.employees.entity.Employee;
import com.luv2code.springboot.employees.request.EmployeeRequest;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository theEmployeeRepository) {
        employeeRepository = theEmployeeRepository;
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(long theId) {

        Optional<Employee> result = employeeRepository.findById(theId);

        Employee theEmployee = null;

        if (result.isPresent()) {
            theEmployee = result.get();
        } else {
            throw new RuntimeException("Did not find employee id - " + theId);
        }

        return theEmployee;
    }

    @Transactional
    @Override
    public Employee save(EmployeeRequest theEmployeeRequest) {
        Employee employee = convertToEmployee(null,theEmployeeRequest);
        return employeeRepository.save(employee);
    }

    @Transactional
    @Override
    public Employee update(Long id, EmployeeRequest theEmployeeRequest) {
        Employee employee = convertToEmployee(id,theEmployeeRequest);
        return employeeRepository.save(employee);
    }

    @Override
    public Employee convertToEmployee(Long id, EmployeeRequest theEmployeeRequest) {
        return new Employee(id,theEmployeeRequest.getFirstName(),theEmployeeRequest.getLastName(),theEmployeeRequest.getEmail());
    }

    @Transactional
    @Override
    public void deleteById(long id) {
        employeeRepository.deleteById(id);
    }
}
