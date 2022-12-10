package com.example.demo.model;

import javax.persistence.Entity;

import javax.persistence.Id;

 

@Entity

public class Task {

            @Id

            private String taskdesc;

            private String empname;

            private String assignee;

           

            public String getTaskdesc() {

                        return taskdesc;

            }

            public void setTaskdesc(String taskdesc) {

                        this.taskdesc = taskdesc;

            }

            public String getEmpname() {

                        return empname;

            }

            public void setEmpname(String empname) {

                        this.empname = empname;

            }

            public String getAssignee() {

                        return assignee;

            }

            public void setAssignee(String assignee) {

                        this.assignee = assignee;

            }

            public Task(String taskdesc, String empname, String assignee) {

                        super();

                        this.taskdesc = taskdesc;

                        this.empname = empname;

                        this.assignee = assignee;

            }

            public Task() {

                        super();

                        // TODO Auto-generated constructor stub

            }

                       

           

           

           

}

 
