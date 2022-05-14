package config;

import beans.MyBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
@ComponentScan(basePackages = {"beans", "services", "repositories"})
public class ProjectConfig {

  /*2nd way*/
  /* use stereotype annotations and ComponentScan */


  /* 1st way*/
  /*@Bean
  @Primary //annotate bean as primary, in case we have more than one bean with the same class in context
  MyBean myBean1() {
    MyBean bean = new MyBean();
    bean.setText("Hello from 1!");
    return bean;
  }

  @Bean(name = "customMyBean2") //provide a custom name for beans
  MyBean myBean2() {
    MyBean bean = new MyBean();
    bean.setText("Hello from 2!");
    return bean;
  }*/

}
