package app.domain.product;

import jakarta.persistence.*;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long productNumber;

    private double price;
    private String name;
    @Enumerated(EnumType.STRING)
    private ProductCategory categoryName;

    public Product() {
    }

    public Product(ProductCategory categoryName, String name, double price, long productNumber) {
        this.categoryName = categoryName;
        this.name = name;
        this.price = price;
        this.productNumber = productNumber;
    }

    public ProductCategory getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(ProductCategory categoryName) {
        this.categoryName = categoryName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public long getProductNumber() {
        return productNumber;
    }

    public void setProductNumber(long productNumber) {
        this.productNumber = productNumber;
    }

    @Override
    public String toString() {
        return "Product{" +
                "categoryName=" + categoryName +
                ", productNumber=" + productNumber +
                ", price=" + price +
                ", name='" + name + '\'' +
                '}';
    }
}
