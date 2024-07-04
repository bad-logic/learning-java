package app.domain.company;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private String websiteURL;

    @OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id")
    private List<Employee> employeeList  = new ArrayList<>();

    @OneToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JoinColumn(name = "contact_id")
    private ContactData contact;

    public Company() {
    }

    public Company(String name, String websiteURL) {
        this.name = name;
        this.websiteURL = websiteURL;
    }

    public ContactData getContact() {
        return contact;
    }

    public void setContact(ContactData contact) {
        this.contact = contact;
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void addEmployee(Employee employee) {
        this.employeeList.add(employee);
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWebsiteURL() {
        return websiteURL;
    }

    public void setWebsiteURL(String websiteURL) {
        this.websiteURL = websiteURL;
    }

    @Override
    public String toString() {
        return "Company{" +
                "name='" + name + '\'' +
                ", websiteURL='" + websiteURL + '\'' +
                '}';
    }
}
