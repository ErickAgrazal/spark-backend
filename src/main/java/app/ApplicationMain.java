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
  static Logger logger = Logger.getLogger(ApplicationMain.class);

  public static void main(String[] args) {
    // Set up a simple configuration that logs on the console.
    BasicConfigurator.configure();
    // Enable CORS
    enableCors();
    // Initialize basic model
    Group group = createGroup();

    // Routes definition ====================
    get("/estudiantes", (req, res) -> {
      res.type("application/json");
      JSONObject jo = new JSONObject(group);
      return jo;
    });

    post("/estudiantes", (req, res) -> {
      res.type("application/json");
      JSONObject body = new JSONObject(req.body());
      List<Integer> grades = generateGrades();
      group.addStudent(body.getString("name"), body.getInt("age"), grades, body.getString("career"));
      JSONObject jo = new JSONObject(group);
      return jo;
    });
    // ========================================
  }

  public static void enableCors() {
    options("/*", (request, response) -> {

      String accessControlRequestHeaders = request.headers("Access-Control-Request-Headers");
      if (accessControlRequestHeaders != null) {
        response.header("Access-Control-Allow-Headers", accessControlRequestHeaders);
      }

      String accessControlRequestMethod = request.headers("Access-Control-Request-Method");
      if (accessControlRequestMethod != null) {
        response.header("Access-Control-Allow-Methods", accessControlRequestMethod);
      }

      return "OK";
    });

    before((request, response) -> response.header("Access-Control-Allow-Origin", "*"));
  }

  public static Group createGroup() {
    // Creating a new group
    Group group = new Group();

    // Genereting grades
    List<Integer> gradesStudent1 = generateGrades();
    List<Integer> gradesStudent2 = generateGrades();
    List<Integer> gradesStudent3 = generateGrades();
    List<Integer> gradesStudent4 = generateGrades();

    // Adding students to the group
    group.addStudent("Erick", 28, gradesStudent1, "Ing. Sistemas");
    group.addStudent("Yair", 27, gradesStudent2, "Ing. Civil");
    group.addStudent("Iván", 25, gradesStudent3, "Desarrollo de Software");
    group.addStudent("Roody", 21, gradesStudent4, "Doctor en medicina");

    return group;
  }

  public static List<Integer> generateGrades() {
    List<Integer> grades = new ArrayList<Integer>();
    grades.add(generatePseudoRandomGrade());
    grades.add(generatePseudoRandomGrade());
    grades.add(generatePseudoRandomGrade());
    grades.add(generatePseudoRandomGrade());
    return grades;
  }

  public static int generatePseudoRandomGrade() {
    int upper = 100;
    int lower = 80;
    return (int) (Math.random() * (upper - lower)) + lower;
  }
}