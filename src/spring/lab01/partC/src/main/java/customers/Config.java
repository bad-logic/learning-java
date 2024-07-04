package customers;

import org.springframework.context.annotation.Bean;

public class Config {

    @Bean
    public Logger getLogger(){
        return new Logger();
    }

    @Bean
    public CustomerDAO getCustomerDAO(){
        return new CustomerDAO(getLogger());
    }

    @Bean
    public EmailSender getEmailSender(){
        return new EmailSender(getLogger());
    }

    @Bean
    public CustomerService customerService(){
        CustomerService customerService  = new CustomerService();
        customerService.setCustomerDAO(getCustomerDAO());
        customerService.setEmailSender(getEmailSender());
        return customerService;
    }


}
