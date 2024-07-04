Q.1.a.
Suppose we have a Spring application with the following given XML configuration

```xml
<bean id="customerService" class="basic.CustomerService">
    <constructor-arg ref="emailService"/>
</bean>
<bean id="emailService" class="basic.EmailService">
    <constructor-arg ref="customerService"/>
</bean>
```
When we run the application, Spring gives an error. Explain clearly why Spring gives an
error based on the given XML configuration.

Answer: 
>Both the beans initialization, requires each other to be injected via constructor argument in order to be fully
instantiated. This creates a circular dependency. hence the error. we can solve this error via setter injection. once
bean has been initialized we can inject the dependencies via setter injection. This will solve the issue of circular dependency.

Q.1.b.
Explain why we need an init() method in Spring Boot.

Answer:
> init() method is needed for the following reasons:
> The init() method allows you to execute custom logic after the beans have been constructed and dependencies have been injected. 
> This is useful for performing tasks that require the bean to be fully initialized.
> Initializing resources such as database connections, starting background threads, or loading configuration settings can be done 
> in the init() method to ensure they are ready for use when the application starts.

Q.2.
```java

@Entity
public class Product{

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
    private int productNumber;
    private String name;
    private double price;
    private String categoryName;

}

@Repository
public interface ProductRepository extends JpaRepository<Product,Long>{
    List<Product> findByPriceGreaterThan(double price);
    List<Product> findByCategoryName(String category);
}
```

Q.3.
```java
@Repository
public interface CompanyRepository extends JpaRepository<Company,Integer>{
    List<Company> findByName(String name);
    @Query("select c.name from Company c join fetch c.employees e where e.address.city=:city")
    List<String> getCompaniesNameFromCity(@Param("city") String city);
    @Query("select c.name from Company c where c.contact.phone=:phone")
    String getCompanyNameFromPhone(@Param("phone") String phone);
    @Query("select c from Company c join fetch c.employees e where e.name=:name")
    List<Company> getCompaniesWhereEmployeeWithGivenNameWorks(@Param("name") String name);
}

@Repository 
public interface AddressRepository extends JpaRepository<Address,Integer>{
    List<String> findStreetByCityAndZip(String city,String zip);
}
```

Q.4.a.
```java
@Entity
@Inheritance(strategy= InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(
        name="type",
        discriminatorType=DiscriminatorType.STRING
)
public abstract class Vehicle {
    @Id 
    @GeneratedValue(strategy=GenerationType.IDENTITY)
     private long id;
     private String brand;
     private String color;
     public Vehicle() { }
     public Vehicle(String brand, String color) {
         this.brand = brand;
         this.color = color;
     }
}

@Entity
public abstract class Car extends Vehicle{
     private String licencePlate;
     public Car() { }
     public Car(String brand, String color, String licencePlate) {
         super(brand, color);
         this.licencePlate = licencePlate;
     }
}

@Entity
@DiscriminatorValue("RentalBicycle")
public class RentalBicycle extends Vehicle{
     private double pricePerHour;
     public RentalBycicle() { }
     public RentalBycicle(String brand, String color, double pricePerHour) {
     super(brand, color);
        this.pricePerHour = pricePerHour;
    }
}

@Entity
@DiscriminatorValue("SellableCar")
public class SellableCar extends Car {
    private double sellPrice;
    public SellableCar() { }
    public SellableCar(String brand, String color, String licencePlate, double
            sellPrice) {
        super(brand, color, licencePlate);
        this.sellPrice = sellPrice;
    }
}

@Entity
@DiscriminatorValue("RentalCar")
public class RentalCar extends Car {
    private double pricePerDay;
    public RentalCar() { }
    public RentalCar(String brand, String color, String licencePlate, double pricePerDay) {
        super(brand, color, licencePlate);
        this.pricePerDay = pricePerDay;
    }
}

@Repository
public interface RentalBycicleRepository extends JpaRepository<RentalBicycle, Long> { }
@Repository
public interface RentalCarRepository extends JpaRepository<RentalCar, Long> { }
@Repository
public interface SellableCarRepository extends JpaRepository<SellableCar, Long> { }

@SpringBootApplication
public class Application implements CommandLineRunner {
    @Autowired
    RentalCarRepository rentalCarRepository;
    @Autowired
    SellableCarRepository sellableCarRepository;
    @Autowired
    RentalBycicleRepository rentalBycicleRepository;
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
    @Override
    public void run(String... args) throws Exception {
        RentalCar rentalCar = new RentalCar("BMW", "Black", "KL-980-1", 67.00);
        rentalCarRepository.save(rentalCar);
        SellableCar sellableCar = new SellableCar("Audi", "White", "KM-956-2",
                45980.00);
        sellableCarRepository.save(sellableCar);
        RentalBycicle rentalBycicle = new RentalBycicle("Moof", "Grey", 10.50);
        rentalBycicleRepository.save(rentalBycicle);
    }
}
```

Q.4.b.
Answer
> Advantages 
> Simple, Easy to implement 
> Good performance on all queries, polymorphic and non polymorphic
> Disadvantages 
> Nullable columns / de-normalized schema 
> Table may have to contain lots of columns 
> A change in any class results in a change of this
  table

Q.4.c. 

Answer

`Single Table Strategy`

`Vehicle Table`

| id | brand | color | type | licensePlate | pricePerHour | sellPrice | pricePerDay |
|----| ------ | ---- | ---- | ------------ | ------------ | ---------- | ----------- | 
| 1 | BMW | Black | RentalCar | KL-980-1 | NULL | NULL | 67.00 | 
| 2 | Audi | White | SellableCar | KM-956-2 | NULL | 45980.00 | NULL |
| 3 | Moof | Grey | RentalBicycle | NULL | 10.50 | NULL | NULL | NULL |


q.4.d.

`Joined Tables Strategy`

 `Vehicle Table`

| id | brand | color |
| - | ----- | ----- |
| 1 | BMW | Black |
| 2 | Audi | White | 
| 3 | Moof | Grey |

`Car Table`

| id | licensePlate |
| -- |-----------|
| 1  | KL-980-1 |
| 2  | KM-956-2 |

`RentalCar Table`

| id | pricePerDay |
| -- | ----- |
| 1  | 67.00 |

`SellableCar Table`

| id | sellPrice |
|----| ---------- |
| 2  | 45980.00 |

`RentalBicicyle Table`

| id | pricePerHour | 
|----|------------| 
| 3  |  10.50 |

Q.4.e.

`Table per class Strategy`

`RentalCar Table`

| id | brand | color | licensePlate | pricePerDay | 
|----| ------ | ----  | --------- | ----------- | 
| 1 | BMW | Black | KL-980-1 | 67.00 | 

`SellableCar Table`

| id | brand | color | licensePlate | sellPrice | 
|----| ------ | ----  | --------- | ----------- | 
| 2  | Audi | White | KM-956-2 | 45980.00 | 

`RentalBicicyle Table`

| id | brand | color | pricePerHour | 
|----|-------|-------| ---------- | 
| 3  | Moof  | Grey  | 10.50 | 

Q.5.

Answer
> a. False
> 
> b. True
> 
> c. True
> 
> d. False
> 
> e. False
> 
> f. True
> 
> g. False
> 
> h. False
> 
> i. False
> 
> j. False