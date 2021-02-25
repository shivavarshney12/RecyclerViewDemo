package com.example.recyclerviewdemo;

import java.io.Serializable;

public class contactitem implements Serializable {
    private int id;
    private String name;
    private String rollno;
    private String dept;
    private String email;
    public contactitem(int id,String name,String rollno,String dept,String email){
        this.id=id;
        this.name=name;
        this.rollno=rollno;
        this.dept=dept;
        this.email=email;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getrollno() {
        return rollno;
    }

    public String getDept() { return dept; }

    public String getEmail() { return email; }

    public void setId(int id) { this.id= id; }

    public void setName(String name) { this.name = name; }

    public void setdept(String dept) { this.dept = dept; }

    public void setEmail(String email) { this.email = email; }

}
