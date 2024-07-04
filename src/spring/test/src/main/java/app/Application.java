package app;

import app.domain.company.Address;
import app.domain.company.Company;
import app.domain.company.ContactData;
import app.domain.company.Employee;
import app.domain.product.Product;
import app.domain.product.ProductCategory;
import app.domain.vehicle.RentalBicycle;
import app.domain.vehicle.RentalCar;
import app.domain.vehicle.SellableCar;
import app.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class Application implements CommandLineRunner {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    CompanyRepository companyRepository;

    @Autowired
    AddressRepository addressRepository;

    @Autowired
    RentalCarRepository rentalCarRepository;
    @Autowired
    SellableCarRepository sellableCarRepository;
    @Autowired
    RentalBicycleRepository rentalBicycleRepository;

    public static void main(String[] args){
        SpringApplication.run(Application.class,args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("\n\n\n---------------------- Product ----------------------\n");
        Product prod1 = new Product(ProductCategory.CLOTHING,"dress",10,101);
        Product prod2 = new Product(ProductCategory.CLOTHING,"dress1",10,102);
        Product prod3 = new Product(ProductCategory.TOYS,"car",15,103);
        Product prod4 = new Product(ProductCategory.ELECTRONICS,"Monitor",45,104);
        Product prod5 = new Product(ProductCategory.ELECTRONICS,"Refrigerator",65.78,105);
        Product prod6 = new Product(ProductCategory.CLOTHING,"dress3",25,106);
        productRepository.saveAll(List.of(prod1,prod2,prod3,prod4,prod5,prod6));

        System.out.println("Give all products with a price bigger than a given amount");
        System.out.println(productRepository.findProductByPriceGreaterThan(10));
        System.out.println("Give all products from a certain category");
        System.out.println(productRepository.findProductByCategoryName(ProductCategory.TOYS));

        System.out.println("\n\n\n---------------------- Company ----------------------\n");
        Employee emp1 = new Employee("Ben","emp1@xyz.com");
        emp1.setAddress(new Address("1000 S 5th street","focus","23890"));

        Employee emp2 = new Employee("Tom","emp2@xyz.com");
        emp2.setAddress(new Address("99th street","focus","6767"));

        Employee emp3 = new Employee("Jill","emp3@xyz.com");
        emp3.setAddress(new Address("3rd street","focus","345345"));

        Employee emp4 = new Employee("Mary","emp4@xyz.com");
        emp4.setAddress(new Address("1000 S 5th street","focus","4555"));

        Employee emp5 = new Employee("John","emp5@xyz.com");
        emp5.setAddress(new Address("99th street","destined","65756765"));

        Employee emp6 = new Employee("Tony","emp6@xyz.com");
        emp6.setAddress(new Address("3rd street","destined","657567"));

        Employee emp7 = new Employee("Markham","emp7@xyz.com");
        emp7.setAddress(new Address("2nd street 4th ave","fiverr","5446"));

        Employee emp8 = new Employee("Melisa","emp8_@xyz.com");
        emp8.setAddress(new Address("art part","fiverr","3455"));

        Employee emp9 = new Employee("Ben","emp9@xyz.com");
        emp9.setAddress(new Address("3rd street","jealous","454546"));

        Company comp1 = new Company("company","company.com");
        comp1.addEmployee(emp1);
        comp1.addEmployee(emp2);
        comp1.addEmployee(emp3);
        comp1.setContact(new ContactData("enquiry@company.com","23492874983","290832098402384"));


        Company comp2 = new Company("company","comp.com");
        comp2.addEmployee(emp5);
        comp2.addEmployee(emp6);
        comp2.addEmployee(emp9);
        comp2.setContact(new ContactData("info@comp.com","09284302384","09284302384"));

        Company comp3 = new Company("mero company","mero_company.com");
        comp3.addEmployee(emp4);
        comp3.addEmployee(emp7);
        comp3.addEmployee(emp8);
        comp3.addEmployee(emp9);
        comp3.setContact(new ContactData("info@merocompany.com","345245546","345245546"));


        companyRepository.saveAll(List.of(comp1,comp2,comp3));


        System.out.println("------- companies with a name ---------------");
        System.out.println(companyRepository.findCompanyByName("mero company"));

        System.out.println("----- street from a given city and zip -------");
        System.out.println(addressRepository.findStreetByCityAndZip("fiverr","5446"));

        System.out.println("------------- Give the name of all companies from a given city -------------");
        System.out.println(companyRepository.getCompaniesNameFromCity("focus"));
        System.out.println("------------- Give the name of the company given a certain phone number -------------");
        System.out.println(companyRepository.getCompanyNameFromPhone("23492874983"));
        System.out.println("------------- Give all Companies where an employee works with a certain given name -------------");
        System.out.println(companyRepository.getCompaniesWhereEmployeeWithGivenNameWorks("Ben"));
        System.out.println(companyRepository.findAll(CompanySpecification.withEmployeeNamed("Ben")));

        System.out.println("\n\n\n---------------------- Vehicle ----------------------\n");
        RentalCar rentalCar = new RentalCar("BMW", "Black", "KL-980-1", 67.00);
        rentalCarRepository.save(rentalCar);
        SellableCar sellableCar = new SellableCar("Audi", "White", "KM-956-2",
                45980.00);
        sellableCarRepository.save(sellableCar);
        RentalBicycle rentalBicycle = new RentalBicycle("Moof", "Grey", 10.50);
        rentalBicycleRepository.save(rentalBicycle);
    }
}
