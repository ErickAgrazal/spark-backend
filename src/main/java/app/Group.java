package app;

import java.util.List;
import java.util.ArrayList;
import app.Student;

public class Group {
  List<Student> students = new ArrayList<Student>();

  public void addStudent(String _name, int _age, int[] _grades, String _career) {
    Student student = new Student();
    student.setName(_name);
    student.setAge(_age);
    student.setCareer(_career);
    student.setGrades(_grades);
    students.add(student);
  }

  public List<Student> getGroup() {
    return students;
  }

  public int getCount() {
    return students.size();
  }
}