package com.codecool.springinventorymanager.service;


import com.codecool.springinventorymanager.model.Employee;
import com.codecool.springinventorymanager.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    private EmployeeRepository repository;

    @Autowired
    public EmployeeService(EmployeeRepository repository) {
        this.repository = repository;
    }

    public Iterable<Employee> getAll(){
        return repository.findAll();
    }

    public void save(Employee emp){
        repository.save(emp);
    }
}
