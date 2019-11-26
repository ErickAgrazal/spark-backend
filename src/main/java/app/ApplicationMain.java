package app;

import static spark.Spark.*;
import org.json.JSONObject;
import app.Group;

public class ApplicationMain {
  public static void main(String[] args) {
    // Initialize basic model
    enableCors();
    Group group = createGroup();
    get("/", (req, res) -> {
      res.type("application/json");
      JSONObject jo = new JSONObject(group);
      return jo;
    });
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
    Group group = new Group();
    int[] grades = new int[] { 100, 100 };
    group.addStudent("Erick", 28, grades, "Ing. Sistemas");
    group.addStudent("Yair", 27, grades, "Lo que sea");
    group.addStudent("Iván", 25, grades, "Desarrollo");
    return group;
  }
}