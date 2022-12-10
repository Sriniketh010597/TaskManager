package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Employee;

public interface EmployeeService {

      

       public Employee findByEmpnameAndEmppassword(String empname, String emppassword);

 

       public List<Employee> FindByLevel(String level);

       public List<Employee> FindAllByLevelOrLevel(String string, String string2);

 

      

 

 

      

      

 

      

}
