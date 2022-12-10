package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

 

import com.example.demo.model.Employee;

import com.example.demo.repository.EmployeeRepository;

 

@Service

public class EmployeeServiceImpl implements EmployeeService {

       @Autowired

       private EmployeeRepository employee;

      

       @Override

       public Employee findByEmpnameAndEmppassword(String empname, String emppassword) {

             // TODO Auto-generated method stubS

             if(employee.findByEmpnameAndEmppassword(empname, emppassword)!=null)

                    return employee.findByEmpnameAndEmppassword(empname, emppassword);

                    else

                           return null;

            

       }

       @Override

       public List<Employee> FindByLevel(String level) {

             // TODO Auto-generated method stub

             return employee.findByLevel(level);

            

       }

 

       @Override

       public List<Employee> FindAllByLevelOrLevel(String string, String string2) {

             //System.out.println(user.findByLevelOrLevel(string, string2));

             return employee.findByLevelOrLevel(string, string2);

             // TODO Auto-generated method stub

      

       }

 

      

      

 

 

 

}
