package com.example.partC_configuration;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@ConfigurationProperties(prefix = "app")
@Validated
public class ApplicationProperties {
    @NotBlank
    private String name;
    @NotBlank
    private String version;
    @NotBlank
    private String serverUrl;
    @NotBlank
    private String serverName;

    private User user;
    private List<String> countries;

    static class User{
        @NotBlank
        private String firstName;
        @NotBlank
        private String lastName;
        @NotBlank
        @Size(min = 8,max = 15)
        private String userName;
        @NotBlank
        @Size(min = 8,max = 15)
        private String password;

        public User(String firstName, String lastName, String password, String userName) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.password = password;
            this.userName = userName;
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        @Override
        public String toString() {
            return "User{" +
                    "firstName='" + firstName + '\'' +
                    ", lastName='" + lastName + '\'' +
                    ", userName='" + userName + '\'' +
                    ", password='" + password + '\'' +
                    '}';
        }
    }

    public void setCountries(List<String> countries) {
        this.countries = countries;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setServerName(String serverName) {
        this.serverName = serverName;
    }

    public void setServerUrl(String serverUrl) {
        this.serverUrl = serverUrl;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public List<String> getCountries() {
        return countries;
    }

    public String getName() {
        return name;
    }

    public String getServerName() {
        return serverName;
    }

    public String getServerUrl() {
        return serverUrl;
    }

    public String getVersion() {
        return version;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "ApplicationProperties{" +
                "countries=" + countries +
                ", name='" + name + '\'' +
                ", version='" + version + '\'' +
                ", serverUrl='" + serverUrl + '\'' +
                ", serverName='" + serverName + '\'' +
                ", user=" + user +
                '}';
    }
}
