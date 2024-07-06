package app;


import jakarta.persistence.*;


@Entity
public class Customer {

    @Id
    @GeneratedValue
    private long id;
    private String name;

    @OneToOne(mappedBy = "customer")
    private Account account;

    protected Customer() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Customer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Account getAccount() {
        return account;
    }
}


