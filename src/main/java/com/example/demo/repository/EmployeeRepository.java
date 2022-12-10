package com.example.demo.repository;

import java.util.List;

import java.util.Optional;

 

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

 

import com.example.demo.model.Employee;

 

@Repository

public interface EmployeeRepository extends JpaRepository<Employee, String> {


      

             public boolean existsByEmpnameAndEmppassword(String empname,String emppassword);

            

             public Employee findByEmpnameAndEmppassword(String empname,String emppassword);

            

             public List<Employee> findByLevel(String level);

             public List<Employee> findByLevelOrLevel(String level,String level1);;

 

             Optional<Employee> findByEmpname(String empname);

             

         

        

 

      

}
