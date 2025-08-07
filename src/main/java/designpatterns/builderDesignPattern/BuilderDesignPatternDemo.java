package designpatterns.builderDesignPattern;

import java.util.List;

public class BuilderDesignPatternDemo {


   public void run() {

      Student student1 = new Student.StudentBuilder(1, "Student 1")
              .setAddress("Address 1")
              .setContactNumber("8728372837")
              .addSubjects("Subject 1")
              .addSubjects("Subject 2")
              .addSubjects("Student 3")
              .build();

      System.out.println(student1.toString());
   }
}
