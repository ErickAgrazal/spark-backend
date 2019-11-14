package app;

import static spark.Spark.*;
import org.json.JSONObject;
import app.Group;

public class ApplicationMain {
  public static void main(String[] args) {
    // Initialize basic model
    Group group = createGroup();
    get("/", (req, res) -> {
      res.type("application/json");
      JSONObject jo = new JSONObject(group);
      return jo;
    });
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