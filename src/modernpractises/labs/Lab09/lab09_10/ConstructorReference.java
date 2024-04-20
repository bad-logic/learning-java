package modernpractises.labs.Lab09.lab09_10;

import modernpractises.labs.Lab09.lab09_7b.TriFunction;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;

class Human
{
	String name;
	int age;
	String gender;
	
	public Human(String name){
		this.name = name;
	}
	public Human(String name,int age){
		this.name = name;
		this.age = age;
	}
	
	public Human(String name,int age, String gender){
		this.name = name;
		this.age = age;
		this.gender = gender;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	@Override
	public String toString() {
		return "Human [name=" + name + ", age=" + age + ", gender=" + gender + "]";
	}
}

interface IHuman<R,N,A,G>{
	R get(N name,A age, G gender);
}

public class ConstructorReference {

	public static void main(String[] args) {
		Human[] list = {new Human("Joe", 35, "Male"), new Human("Jane", 45, "Female"), new Human("John", 30, "Male")};

		// Query 1  : Print only Female candidates names
		List<String> femaleCandidates = Arrays.stream(list).filter(x -> x.gender.equals("Female")).map(x -> x.getName()).collect(Collectors.toList());
		System.out.println("Female Candidates : " + femaleCandidates);

		// Query 2 : Create an object by choosing suitable Interface to the specified constructors(Totally 3 constructor)using fourth
		// type of Method Reference ClassName::new. Then print the object status
		TriFunction<String, Integer, String,Human> createHuman = Human::new;

		Human human1 = createHuman.apply("Jack", 35, "Male");

		BiFunction<String,Integer,Human> createHuman1 = Human::new;
		Human human2 = createHuman1.apply("Anna", 45);

		Function<String,Human> createHuman2 = Human::new;
		Human human3 = createHuman2.apply("Jamie");

		System.out.println(human1);
		System.out.println(human2);
		System.out.println(human3);

		// Query 3 : Count the male candidates whose age is more than 30
		int count = (int) Arrays.stream(list).filter((x -> x.getGender().equals("Male"))).filter(x -> x.getAge() > 30).count();
		System.out.println("Male candidates Count with age > 30 : " + count);

	}
}
