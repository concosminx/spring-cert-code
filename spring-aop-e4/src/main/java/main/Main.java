package main;


import config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import services.HelloService;

public class Main {

  /**
   * XML
   * Annotations
   * @param args
   */


  public static void main(String[] args) {
    try (var context = new AnnotationConfigApplicationContext(ProjectConfig.class)) {

      HelloService helloService = context.getBean(HelloService.class);
      //helloService.hello("John Doe");

      String message = helloService.hello("John Doe");
      System.out.println("Result is: " + message);


    } catch (Exception exc) {
      exc.printStackTrace();
    }
  }
}
