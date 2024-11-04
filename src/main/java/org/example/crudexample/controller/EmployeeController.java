package org.example.crudexample.controller;

import org.example.crudexample.entity.Employee;
import org.example.crudexample.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class EmployeeController {
    private EmployeeService employeeService;
    @Autowired
    public EmployeeController(EmployeeService employeeService){
        this.employeeService=employeeService;
    }

    @GetMapping("employees")
    public List<Employee> FindAllEmployee(){
        return employeeService.findAll();
    }

    @GetMapping("employees/{id}")
    public Employee findById(@PathVariable Integer id){
        Employee employee = employeeService.findById(id);
        if(employee==null){
            throw new RuntimeException("Id is null:"+id);
        }
        return employee;
    }

    @PostMapping("employees/create")
    public Employee createEmployee(@RequestBody Employee employee){
        Employee employee1 = employeeService.save(employee);

        return employeeService.save(employee1);
    }

    @PutMapping("employees")
    public Employee updateEmployee(@RequestBody Employee employee){
        return employeeService.save(employee);
    }

    @DeleteMapping("employees/{id}")
    public String deleteEmployee(@PathVariable Integer id){
        Employee employee = employeeService.findById(id);
        if(employee==null){
            throw new RuntimeException("Id is null:"+id);
        }
        employeeService.deleteById(id);
        return "Deleted employee id:"+id;
    }
}
