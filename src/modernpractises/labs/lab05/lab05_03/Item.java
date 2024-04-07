package modernpractises.labs.lab05.lab05_03;

public class Item {

    String name;
    Item(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    @Override
    public String toString() {
        return name;
    }
}
