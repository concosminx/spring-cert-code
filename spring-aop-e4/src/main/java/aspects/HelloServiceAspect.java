package aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class HelloServiceAspect {

  /*
  @Before("execution(* services.HelloService.hello(..))")
  public void before() {
    System.out.println("Before Aspect");
  }

  @After("execution(* services.HelloService.hello(..))")
  public void after() { //doesn't matter if u have exception
    System.out.println("After Aspect");
  }

  @AfterReturning("execution(* services.HelloService.hello(..))")
  public void afterReturning() { //only for executions without exceptions
    System.out.println("After Returning Aspect");
  }*/

  //in Spring we are using Runtime Weaving
  @Around("execution(* services.HelloService.hello(..))")
  public Object around(ProceedingJoinPoint joinPoint) {
    //System.out.println("Something else ... ");
    //return "Paki, the hacker, was here!";

    System.out.println("Beginning ..");
    Object result = null;

    try {
      result = joinPoint.proceed(/*replace params*/new Object[] {"Bill"});
      System.out.println("After proceed ... ");
    } catch (Throwable e) {
      e.printStackTrace();
    }

  return result;
  }

}
