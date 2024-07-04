package customers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ProductDAO {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    public void clearDB() {
        Map<String,Object> namedParameters = new HashMap<String,Object>();
        jdbcTemplate.update("DELETE from product",namedParameters);
        jdbcTemplate.update("DELETE from supplier",namedParameters);
    }

    public void save(Product product) {
        Map<String,Object> productParameters = new HashMap<String,Object>();
        productParameters.put("productNumber", product.getProductNumber());
        productParameters.put("name", product.getName());
        productParameters.put("price", product.getPrice());
        productParameters.put("supplier_id", null);

        System.out.println(product);
        // save supplier
        if(product.getSupplier() != null){
            productParameters.put("supplier_id", product.getSupplier().getId());
            Map<String,Object> supplierParams = new HashMap<String,Object>();
            supplierParams.put("id", product.getSupplier().getId());
            supplierParams.put("name", product.getSupplier().getName());
            supplierParams.put("phone", product.getSupplier().getPhone());
            jdbcTemplate.update("INSERT INTO supplier VALUES (:id, :name, :phone)",supplierParams);
        }

        jdbcTemplate.update("INSERT INTO product VALUES ( :productNumber, :name, :price, :supplier_id)", productParameters);
    }



    public Product findByProductNumber(int productNumber){
        Map<String,Object> namedParameters = new HashMap<String,Object>();
        namedParameters.put("productNumber", productNumber);
        try{
            Product product = jdbcTemplate.queryForObject("SELECT p.productNumber,p.name,p.price,s.id,s.name as sname,s.phone FROM product p LEFT JOIN supplier s ON p.supplier_id = s.id WHERE p.productNumber =:productNumber ",namedParameters,
                    (rs, rowNum) -> {
                        Supplier s = new Supplier(
                                rs.getInt("id"),
                                rs.getString("sname"),
                                rs.getString("phone")
                        );
                        Product prod =  new Product(
                                rs.getInt("productNumber"),
                                rs.getString("name"),
                                rs.getDouble("price")
                        );

                        if(s.getName() == null){
                            prod.setSupplier(null);
                        }else{
                            prod.setSupplier(s);
                        }

                        return prod;
                    });
            return product;
        }catch(Exception ex){
            System.out.println(ex.getMessage());
            return null;
        }
    }

    public List<Product> getAllProducts(){
        List<Product> products = jdbcTemplate.query("SELECT p.productNumber,p.name,p.price,s.id,s.name as sname,s.phone FROM product p LEFT JOIN supplier s ON p.supplier_id = s.id",new HashMap<String, Object>(),
                (rs, rowNum) ->{
                    Supplier s = new Supplier(
                            rs.getInt("id"),
                            rs.getString("sname"),
                            rs.getString("phone")
                    );
                    Product prod =  new Product(
                            rs.getInt("productNumber"),
                            rs.getString("name"),
                            rs.getDouble("price")
                    );

                    if(s.getName() == null){
                        prod.setSupplier(null);
                    }else{
                        prod.setSupplier(s);
                    }

                    return prod;
                });
        return products;
    }

    List<Product> findByProductName(String productName){
        Map<String,Object> namedParameters = new HashMap<String,Object>();
        namedParameters.put("name", productName);
        List<Product> products = jdbcTemplate.query("SELECT p.productNumber,p.name,p.price,s.id,s.name as sname,s.phone FROM product p LEFT JOIN supplier s ON p.supplier_id = s.id where p.name=:name",
                namedParameters,
                (rs, rowNum) -> {

                    Supplier s = new Supplier(
                            rs.getInt("id"),
                            rs.getString("sname"),
                            rs.getString("phone")
                    );
                    Product prod =  new Product(
                        rs.getInt("productNumber"),
                        rs.getString("name"),
                        rs.getDouble("price")
                    );

                    if(s.getName() == null){
                        prod.setSupplier(null);
                    }else{
                        prod.setSupplier(s);
                    }

                    return prod;
                });
        return products;
    }

    Product removeProduct(int productNumber){
        Product prod = findByProductNumber(productNumber);
        if(prod != null){
            Map<String,Object> namedParameters = new HashMap<String,Object>();
            namedParameters.put("productNumber", productNumber);
            jdbcTemplate.update("DELETE FROM product WHERE productNumber =:productNumber ",namedParameters);
            return prod;
        }
        System.out.println("product not found");
        return null;
    }


}
