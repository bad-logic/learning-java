package modernpractises.labs.lab03.lab03_01.soln;


public class Person {
	private String name;
	Person(String n) {
		name = n;
	}
	public String getName() {
		return name;
	}
	@Override
	public boolean equals(Object aPerson) {
		if(aPerson == null) return false;
		if(!(aPerson instanceof Person)) return false;
		Person p = (Person)aPerson;
		return this.getName().equals(p.getName());
	}
	public static void main(String[] args) {
		
	}

}
