package com.example.demo.service;

import java.util.List;



import com.example.demo.model.Task;

 

public interface TaskService {

            public  List<Task> gettask(String empname);

            public List<Task> findAllByAssigneetask(String assignee);

            public Task Save(Task task);

 

}