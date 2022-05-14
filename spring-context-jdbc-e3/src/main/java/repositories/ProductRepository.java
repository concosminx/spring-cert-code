package repositories;

import model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Transactional(propagation = Propagation.REQUIRED)
@Repository
public class ProductRepository {

  @Autowired
  private JdbcTemplate jdbcTemplate;

  //@Transactional(propagation = Propagation.REQUIRES_NEW)
  public void addProduct(Product product) {
    String sql = " INSERT INTO product(name, price) VALUES (?, ?) ";
    jdbcTemplate.update(sql, product.getName(), product.getPrice());
  }
  
  public List<Product> getProductes() {
    String sql = " SELECT * FROM product ";
    return jdbcTemplate.query(sql, new RowMapper<Product>() {
      @Override
      public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
        Product newProduct = new Product();
        newProduct.setName(rs.getString("name"));
        newProduct.setPrice(rs.getDouble("price"));
        return newProduct;
      }
    });
  }

}
