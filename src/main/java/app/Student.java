package app;

import java.util.ArrayList;
import java.util.List;

public class Student {
    String name;
    int age;
    List<Integer> grades = new ArrayList<Integer>();

    public void setName(String _name){
        name = _name;
    }

    public String getName(){
        return name;
    }

    public void setAge(int _age){
        age = _age;
    }

    public int getAge(){
        return age;
    }

    public void setGrades(List<Integer> _grades){
        grades = _grades;
    }

    public List<Integer> getGrades(){
        return grades;
    }
}