package app.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class CreateAccountDTO {

    @NotBlank(message = "name is mandatory")
    @Size(min = 2, max = 10, message = "name must be between 2 and 10 characters")
    private String name;

    public CreateAccountDTO() {
    }

    public CreateAccountDTO(String name) {
        this.name = name;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "CreateAccountDTO{" +
                ", name='" + name + '\'' +
                '}';
    }
}
