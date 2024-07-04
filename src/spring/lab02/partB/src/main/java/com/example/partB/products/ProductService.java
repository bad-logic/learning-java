package com.example.partB.products;


import com.example.partB.integrations.IEmailSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService implements IProductService {

    IProductDAO productDAO;
    IEmailSender emailSender;

    @Autowired
    public void setCustomerDAO(IProductDAO productDAO){
        this.productDAO = productDAO;
    }

    @Autowired
    public void setEmailSender(IEmailSender emailSender){
        this.emailSender = emailSender;
    }
    @Override
    public void addProduct(String name, String slug, double price, String email) {

        Product customer = new Product(name,slug,price);

        productDAO.save(customer);

        emailSender.sendEmail(email, "New Product " + name + " added to the inventory");

    }
}
