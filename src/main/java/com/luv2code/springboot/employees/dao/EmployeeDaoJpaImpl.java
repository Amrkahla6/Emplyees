package com.luv2code.springboot.employees.dao;

import com.luv2code.springboot.employees.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDaoJpaImpl implements EmployeeDao {

    private EntityManager entityManager;

    @Autowired
    public EmployeeDaoJpaImpl(EntityManager theEntityManager) {
        entityManager = theEntityManager;
    }

    @Override
    public List<Employee> findAll() {

        TypedQuery<Employee> theQuery = entityManager.createQuery("from Employee", Employee.class);

        List<Employee> employees = theQuery.getResultList();

        return employees;
    }

    @Override
    public Employee findById(long id) {
        Employee theEmployee = entityManager.find(Employee.class, id);
        return theEmployee;
    }

    @Override
    public Employee save(Employee theEmployee) {
        Employee theEmployeeEntity = entityManager.merge(theEmployee);
        return theEmployeeEntity;
    }

    @Override
    public void deleteById(long id) {
        Employee theEmployee = entityManager.find(Employee.class, id);
        entityManager.remove(theEmployee);
    }
}
