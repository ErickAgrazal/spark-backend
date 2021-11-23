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
  }
}