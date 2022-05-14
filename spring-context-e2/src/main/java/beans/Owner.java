package beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Owner {

  //@Autowired with field
  private final Cat cat; //has a Cat

  public Cat getCat() {
    return cat;
  }

  //public void setCat(Cat cat) {
  //  this.cat = cat;
  //}

  @Autowired
  public Owner(Cat cat) {
    this.cat = cat;
  }

  @Override
  public String toString() {
    return "Owner{" +
        "cat=" + cat +
        '}';
  }
}
