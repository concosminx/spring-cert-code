package main;

import beans.MyBean;
import config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import services.ProductDeliveryService;

public class Main {

  /**
   * XML
   * Annotations
   * @param args
   */


  public static void main(String[] args) {
    try (var context = new AnnotationConfigApplicationContext(ProjectConfig.class)) {

      //System.out.println("--get beans by type--");

      //get beans by type
      //MyBean b1 = context.getBean(MyBean.class);
      //MyBean b2 = context.getBean(MyBean.class);
      //MyBean b3 = context.getBean(MyBean.class);

      //System.out.println(b1.getText());
      //System.out.println(b2.getText());
      //System.out.println(b3.getText());

      //System.out.println("--get beans by name--");

      //get beans by name
      //MyBean bn1 = context.getBean("myBean1", MyBean.class);
      //System.out.println(bn1.getText());

      //MyBean bn2 = context.getBean("customMyBean2", MyBean.class);
      //System.out.println(bn2.getText());

      System.out.println("-- services and repositories --");
      ProductDeliveryService service = context.getBean(ProductDeliveryService.class);
      service.addSomeProduct();

    } catch (Exception exc) {
      exc.printStackTrace();
    }
  }
}
