package main;


import config.ProjectConfig;
import model.Product;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import repositories.ProductRepository;
import services.ProductService;

public class Main {

  /**
   * XML
   * Annotations
   * @param args
   */


  public static void main(String[] args) {
    try (var context = new AnnotationConfigApplicationContext(ProjectConfig.class)) {

      //ProductRepository productRepository = context.getBean(ProductRepository.class);

      //add a new product
      //Product p1 = new Product();
      //p1.setName("PS5");
      //p1.setPrice(500.32);

      //productRepository.addProduct(p1);

      //display all products from table
      //productRepository.getProductes().stream().forEach(System.out::println);

      ProductService productService = context.getBean(ProductService.class);
      //productService.addOneProduct();

      productService.addFiveProducts();

    } catch (Exception exc) {
      exc.printStackTrace();
    }
  }
}
