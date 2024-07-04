package customers;

public class Product {

    private int productNumber;
    private String name;
    private double price;
    private Supplier supplier;

    public Product(int productNumber, String name, double price) {
        this.productNumber = productNumber;
        this.name = name;
        this.price = price;
    }

    public Product(int productNumber, String name, double price, Supplier supplier) {
        this.productNumber = productNumber;
        this.name = name;
        this.price = price;
        this.supplier = supplier;
    }

    public int getProductNumber() {
        return productNumber;
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

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productNumber='" + productNumber + '\'' +
                ", name='" + name + '\'' +
                ", price='" + price + '\'' +
                ", supplier=" + supplier +
                '}';
    }
}
