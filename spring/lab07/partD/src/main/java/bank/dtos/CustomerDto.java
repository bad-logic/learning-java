package bank.dtos;

public class CustomerDto {

    private int id;

    private String name;

    public CustomerDto(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
