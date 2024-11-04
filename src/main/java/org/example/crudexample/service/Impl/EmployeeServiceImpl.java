package org.example.crudexample.service.Impl;

import jakarta.transaction.Transactional;
import org.example.crudexample.dao.EmployeeRepository;
import org.example.crudexample.entity.Employee;
import org.example.crudexample.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;


    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository){
        this.employeeRepository = employeeRepository;
    }

    //private EmployeeDAO employeeDAO;
//    @Autowired
//    public EmployeeServiceImpl(EmployeeDAO employeeDAO){
//        this.employeeDAO = employeeDAO;
//    }
    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(Integer id) {
        Optional<Employee> result = employeeRepository.findById(id);
        Employee employee = null;
        if (result.isPresent()) {
            employee = result.get();
        }else{
            System.out.println("Did not find employee id - " + id);
            throw new RuntimeException("Did not find employee id - " + id);

        }
        return employee;
    }

    @Override
    @Transactional
    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        employeeRepository.deleteById(id);
    }
}
