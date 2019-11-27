package app;

import java.util.List;
import java.util.ArrayList;

public class Student {
  String name;
  int age;
  String career;
  List<Integer> grades = new ArrayList<Integer>();

  /**
   * setName
   *
   * @param _name
   */
  public void setName(String _name) {
    name = _name;
  }

  /**
   * setAge
   *
   * @param _age
   */
  public void setAge(int _age) {
    age = _age;
  }

  /**
   * setCareer
   *
   * @param _career
   */
  public void setCareer(String _career) {
    career = _career;
  }

  /**
   * setGrades
   *
   * @param _grades
   */
  public void setGrades(List<Integer> _grades) {
    grades = _grades;
  }

  /**
   * getName
   *
   * @return
   */
  public String getName() {
    return name;
  }

  /**
   * getAge
   *
   * @return
   */
  public int getAge() {
    return age;
  }

  /**
   * getCareer
   *
   * @return
   */
  public String getCareer() {
    return career;
  }

  /**
   * getGrades
   *
   * @return
   */
  public List<Integer> getGrades() {
    return grades;
  }
}
