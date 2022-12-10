package com.example.demo.repository;

import java.util.List;



import org.springframework.data.jpa.repository.JpaRepository;

 

import com.example.demo.model.Task;

 

public interface TaskRepository extends JpaRepository<Task, String>{

public List<Task> findByEmpname(String empname);

public List<Task> findAllByAssignee(String assignee);

           

}
