package com.example.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 

@Service
public class EmployeeService {
     
    @Autowired
    EmployeeRepository repository;
     
//    public List<Employee> getAllEmployees()
//    {
//        List<Employee> employeeList = repository.findAll();
//         
//       return employeeList;
//    }
	public List<Employee> listAll() {
        return repository.findAll();
    }
     
    public void save(Employee entity) {
    	repository.save(entity);
    }
   
    public Employee get(long id) {
        return repository.findById(id).get();
    }
    public void delete(long id) {
        repository.deleteById(id);
    }
  
}