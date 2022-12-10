package com.example.demo.service;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

 

import com.example.demo.model.Task;

import com.example.demo.repository.TaskRepository;

 

@Service

public class TaskServiceImpl implements TaskService {

 

           

            @Autowired

            private TaskRepository employee;

           

            @Override

            public Task Save(Task task) {

                        // TODO Auto-generated method stub

                       

                        Task t1=employee.save(task);

                        return t1;

            }

 

 

            @Override

            public List<Task> findAllByAssigneetask(String assignee) {

                        // TODO Auto-generated method stub

                        System.out.println(employee.findAllByAssignee(assignee));

                        return employee.findAllByAssignee(assignee);

            }

            @Override

            public List<Task> gettask(String empname) {

                        // TODO Auto-generated method stub

                        return employee.findByEmpname(empname);

            }

           

 

 

           

           

 

           

}
