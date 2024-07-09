package kafka.dtos;

public class CreateAccountDTO {

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
