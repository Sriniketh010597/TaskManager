package com.example.demo.model;

import javax.persistence.Entity;

import javax.persistence.Id;

import javax.validation.constraints.NotEmpty;

 

 

 

@Entity

public class Employee {

            @Id

            @NotEmpty(message="empname is missing")

            private String empname;

            @NotEmpty(message="password is missing")

            private String emppassword;

            private String level;

            private String enables;

           

 

            public String getEnables() {

                        return enables;

            }

            public void setEnables(String enables) {

                        this.enables = enables;

            }

            public String getEmpname() {

                        return empname;

            }

            public void setEmpname(String empname) {

                        this.empname = empname;

            }

            public String getEmppassword() {

                        return emppassword;

            }

            public void setEmppassword(String emppassword) {

                        this.emppassword = emppassword;

            }

            public String getLevel() {

                        return level;

            }

            public void setLevel(String level) {

                        this.level = level;

            }

            public Employee(String empname, String emppassword, String level,String enables) {

                        super();

                        this.empname = empname;

                        this.emppassword = emppassword;

                        this.level = level;

                        this.enables = enables;

            }

            public Employee() {

                        super();

                        // TODO Auto-generated constructor stub

            }

           

           

}

 
