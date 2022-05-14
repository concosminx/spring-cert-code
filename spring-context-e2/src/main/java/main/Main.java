package main;


import beans.Cat;
import beans.Owner;
import config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

  /**
   * XML
   * Annotations
   * @param args
   */


  public static void main(String[] args) {
    try (var context = new AnnotationConfigApplicationContext(ProjectConfig.class)) {
      Cat x = context.getBean(Cat.class);
      Owner o = context.getBean(Owner.class);

      System.out.println("--- default ---");
      System.out.println(x);
      System.out.println(o);

      System.out.println("--- changed ---");
      x.setName("Tom");
      System.out.println(x);
      System.out.println(o);


    } catch (Exception exc) {
      exc.printStackTrace();
    }
  }
}
