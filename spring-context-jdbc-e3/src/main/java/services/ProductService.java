package services;

import model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import repositories.ProductRepository;

import java.util.Random;

@Service
public class ProductService {

  @Autowired
  ProductRepository productRepository;


  //by default Spring rollbacks for RuntimeException but does not rollbacks for the checked exception
  //@Transactional(noRollbackFor = RuntimeException.class) //overwrite spring default behaviour to not rollback for RuntimeException
  //@Transactional(rollbackFor = Exception.class) //overwrite spring default behaviour to rollback also for checked exception

  //Important!
  //the RuntimeException needs to be propagated outside the method in order to trigger the transaction rollback!!!
  //regarding the weaving and aspects [transaction management implementation in spring]

  @Transactional
  public void addOneProduct() {
    Product p1 = new Product();
    p1.setName("Coca Cola");
    p1.setPrice(2.5);
    productRepository.addProduct(p1);

    //throw new RuntimeException();
  }

  /*
   * propagation = Propagation.REQUIRED (default propagation level)
   * REQUIRES_NEW
   * MANDATORY
   * NEVER
   * SUPPORTS
   * NOT_SUPPORTED
   * NESTED - specific to Spring
   *
  */


  //REQUIRED
  //a() -> b(), both with REQUIRED
  //transaction is created (if a transaction does not exists already)
  //a()
  //  b() //is called in the existing transaction.
  //transaction commits | rollbacks

  //REQUIRES_NEW
  //a() -> b(), a with REQUIRED and b with REQUIRES_NEW
  //transaction is created (if a transaction does not exists already)
  //a()
  //  b() will always create a new transaction; the existing transaction is suspended;
  //  the b new transaction commits | rollbacks
  //a main transaction commits | rollbacks

  //MANDATORY
  //always execute a method within a transaction
  //if it is called without a transaction, the method call will fail.
  //doesn't create a transaction

  //NEVER ~ opposite of MANDATORY
  //error in case you have a transaction (see the difference vs. NOT_SUPPORTED)

  //NOT_SUPPORTED
  //doesn't create a transaction when it's called; always execute without a transaction
  //will work with or without a transaction

  //SUPPORTS
  //you can call this method with or without a transaction, it will work with both

  //NESTED
  //used rarely.
  //a nested transaction within existing transaction
  //different from REQUIRES_NEW
  //the nested transaction is dependent of the main transaction

  @Transactional()
  public void addFiveProducts() {
    Random random = new Random();
    for (int i = 1; i <= 5; i++) {
      Product p = new Product();
      p.setName("Product " + i);
      p.setPrice(random.nextDouble() * 100);
      productRepository.addProduct(p);
      if (i == 5) {
        throw new RuntimeException("Oops! Something bad happened!");
      }
    }
  }


  //transaction isolation
  //DEFAULT - taken from the under layer - database

  //READ_UNCOMMITTED
  //READ_COMMITTED
  //REPEATABLE_READ
  //SERIALIZABLE

  //Problems:
  // - dirty reads - {READ_UNCOMMITTED}
  //T1 ---- 10 ------------20 (read again from t1)-------->
  //T2 --------------20----------------------------------->

  // - repeatable reads {READ_UNCOMMITTED, READ_COMMITTED}
  // may encounter situation where in the life of the same transaction a value can be read with different values

  // - phantom reads {READ_UNCOMMITTED, READ_COMMITTED, REPEATABLE_READ}
  // select rows from db -> 100 row; meanwhile T2 will add 10 rows; --> the 10 rows will be the phantom rows (reads)

  //none - {SERIALIZABLE} :) worst performance
  @Transactional(isolation = Isolation.DEFAULT)
  public void nothing() {

  }

  //other properties of @Transactional
}
