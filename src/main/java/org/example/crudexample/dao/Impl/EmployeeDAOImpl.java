package org.example.crudexample.dao.Impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.example.crudexample.dao.EmployeeDAO;
import org.example.crudexample.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

    private EntityManager entityManager;

    @Autowired
    public EmployeeDAOImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }
    @Override
    public List<Employee> findAll() {
        TypedQuery<Employee> theQuery =  entityManager.createQuery("from Employee ",Employee.class);
        List<Employee> employee= theQuery.getResultList();
        return employee;
    }

    @Override
    public Employee findById(Integer id) {
        Employee employee = entityManager.find(Employee.class,id);

        return employee;
    }

    @Override
    public Employee save(Employee employee) {
        Employee theEmployee = entityManager.merge(employee);

        return theEmployee;
    }

    @Override
    public void deleteById(int theId) {
        Employee employee = entityManager.find(Employee.class,theId);
       entityManager.remove(employee);
    }
}
