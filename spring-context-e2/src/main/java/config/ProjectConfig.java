package config;

//import beans.Cat;
//import beans.Owner;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"beans"})
public class ProjectConfig {
  /*
  @Bean
  public Cat cat() {
    Cat cat = new Cat();
    cat.setName("Paki");
    return cat;
  }


  @Bean
  //@Autowired - no longer needed
  public Owner owner(Cat cat) {
    Owner owner = new Owner();
    owner.setCat(cat);
    //owner.setCat(cat()); //provided by Spring, it's not creating a new Cat bean if the bean already exists in Spring Context
    return owner;
  }
  */

}
