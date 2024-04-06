package modernpractises.labs.lab05.prob3;

public class Item {
	String name;
	public Item(String name) {
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
