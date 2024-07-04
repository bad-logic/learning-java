package app.domain.company;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ContactData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String phone;
    private String email;
    private String whatsapp;

    public ContactData() {
    }

    public ContactData(String email, String phone, String whatsapp) {
        this.email = email;
        this.phone = phone;
        this.whatsapp = whatsapp;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getWhatsapp() {
        return whatsapp;
    }

    public void setWhatsapp(String whatsapp) {
        this.whatsapp = whatsapp;
    }

    @Override
    public String toString() {
        return "ContactData{" +
                "email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", whatsapp='" + whatsapp + '\'' +
                '}';
    }
}
