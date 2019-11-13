package app;

import static spark.Spark.*;
import org.json.JSONObject;
import app.Student;

public class ApplicationMain {
  public static void main(String[] args) {
    // Initialize basic model
    Student student = getDefaultStudent();
    get("/", (req, res) -> {
      res.type("application/json");
      JSONObject jo = new JSONObject(student);
      return jo;
    });
  }

  public static Student getDefaultStudent() {
    Student student = new Student();
    int[] grades = new int[] { 100, 100 };
    student.setName("Erick");
    student.setAge(28);
    student.setCareer("Ing. en sistemas");
    student.setGrades(grades);
    return student;
  }
}