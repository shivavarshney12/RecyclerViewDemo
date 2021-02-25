package com.example.recyclerviewdemo;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;
public class StudentS {
    private static StudentS s;
    private List<contactitem> students;
    public static StudentS get(Context context) {
        if(s == null){
            s=new StudentS(context);
        }
        return s;
    }

    private StudentS(Context context) {
        students = new ArrayList<contactitem>();
        for(int i=0;i<30;i++) {
            contactitem c=new contactitem((i+1),"Student"+(i+1),"MC2012"+(i+1),"CSE","Student"+(i+1)+"@iiitd.ac.in");
            students.add(c);
        }
    }
    public List<contactitem> getStudents() {return students;}
    public contactitem getContact(int id) {
        if(s!=null){
            for(contactitem c: students){
                if(id==c.getId())
                    return c;
            }
        }
        return null;
    }


}
