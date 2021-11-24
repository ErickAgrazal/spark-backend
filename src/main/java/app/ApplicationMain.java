package app;

import static spark.Spark.before;
import static spark.Spark.get;
import static spark.Spark.options;
import static spark.Spark.post;

import java.util.List;
import java.util.ArrayList;

import org.json.JSONObject;

import org.apache.log4j.Logger;
import org.apache.log4j.BasicConfigurator;

public class ApplicationMain {
  public static void main(String[] args) {
    // ==========================================
    get("/hola", (request, response) -> {
      return "Hola mundo";
    });
    get("/mundo", (request, response) -> {
      return "Mundo hola";
    });
    post("/hola", (request, response) -> {
      return "Hola mundo desde el POST";
    });
    get("/hola/json", (request, response) -> {
      response.type("application/json");
      return "{\"hola\": \"mundo\"}";
    });
    post("/hola/json", (request, response) -> {
      response.type("application/json");
      return request.body();
    });
    // ==========================================
    Group group = createGroup();
    get("/estudiantes", (req, res) -> {
      res.type("application/json");
      JSONObject jo = new JSONObject(group);
      return jo;
    });
  }

  public static Group createGroup(){
      Group group = new Group();
      group.addStudent(createStudent("Erick Agrazal"));
      group.addStudent(createStudent("Vicente Lopez"));
      group.addStudent(createStudent("Rolando Ramos"));
      group.addStudent(createStudent("Emir Salazar"));
      return group;
  }

  public static Student createStudent(String _name){
      Student student = new Student();
      List<Integer> grades = new ArrayList<Integer>();
      student.setName(_name);
      student.setAge(randomInt(20, 40));
      grades.add(randomInt(80, 100));
      grades.add(randomInt(80, 100));
      grades.add(randomInt(80, 100));
      student.setGrades(grades);
      return student;
  }

  public static int randomInt(int lower, int upper){
      return (int)(Math.random() * ( upper - lower )) + lower;
  }
}