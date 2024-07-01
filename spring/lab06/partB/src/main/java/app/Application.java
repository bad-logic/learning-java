package app;

import domain.Course;
import domain.Department;
import domain.Grade;
import domain.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import repositories.StudentRepository;

import java.util.List;

@SpringBootApplication
@EnableJpaRepositories("repositories")
@EntityScan("domain")
@ComponentScan("repositories")
public class Application implements CommandLineRunner{

	@Autowired
	private StudentRepository studentRepository;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Department softwareDevelopment = new Department("SD");
		Department artificialIntelligence = new Department("AI");

		Course wad = new Course("Web Application Development");
		Course ea = new Course("Enterprise Application");
		Course asd = new Course("Advanced Software Development");
		Course ml = new Course("Machine Learning");
		Course ds = new Course("Data Science");
		Course al = new Course("Algorithm");

		Student ben = new Student("Ben",artificialIntelligence, List.of(new Grade("A",ml),new Grade("A+",ds), new Grade("A+",al)));
		Student tony = new Student("Tony",softwareDevelopment, List.of(new Grade("B+",wad),new Grade("A+",asd), new Grade("A+",ea)));
		Student mary = new Student("Mary", artificialIntelligence, List.of(new Grade("A+",ml),new Grade("A+",al)));
		this.studentRepository.saveAll(List.of(ben,tony,mary));

		System.out.println("----------- queries using method names: ----------------");
		System.out.println("Get all students from a certain department\n"+this.studentRepository.findByDepartmentName("AI"));
		System.out.println("Get all students who took a course with a certain name\n"+this.studentRepository.findByGradesCourseName("Machine Learning"));

		System.out.println("----------- queries using @Query:: ----------------");
		System.out.println("Get all students from a certain department\n"+this.studentRepository.getStudentsByDepartment("AI"));
		System.out.println("Get all students who took a course with a certain name\n"+this.studentRepository.getStudentsWhoTookACourse("Machine Learning"));
	}


}
