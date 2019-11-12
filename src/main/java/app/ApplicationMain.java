package app;

import static spark.Spark.*;

public class ApplicationMain {
  public static void main(String[] args) {
    get("/hello", (request, response) -> "world");
  }
}