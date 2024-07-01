package com.example.partA;

import com.example.partA.entity.*;
import com.example.partA.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;
import java.util.List;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {
    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private PassengerRepository passengerRepository;

    @Autowired
    private SchoolRepository schoolRepository;

    @Autowired
    private StudentRepository studentRepository;


    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    /**
     * Callback used to run the bean.
     *
     * @param args incoming main method arguments
     * @throws Exception on error
     */
    @Override
    public void run(String... args) throws Exception {

        System.out.println("\n\n------ working with department and employee ------");
        Department department = new Department("Computer Science");
        Employee emp = new Employee("Ben");
        emp.setDepartment(department);

        Employee emp1 = new Employee("Tom");
        emp1.setDepartment(department);

        department.setEmployees(List.of(emp, emp1));

        this.departmentRepository.save(department);

        System.out.println("\n------ fetching department 1 from database");
        System.out.println(this.departmentRepository.findAll());

        System.out.println("\n\n------ working with book and publisher ------");
        Publisher publisher = new Publisher("John");
        Publisher publisher1 = new Publisher("Harold");
        Book b1 = new Book("My Journey");
        b1.setPublisher(publisher);
        Book b2 = new Book("Travel");
        b2.setPublisher(publisher);

        Book b3 = new Book("RunAway");
        b3.setPublisher(publisher1);
        this.bookRepository.saveAll(List.of(b1, b2, b3));
        System.out.println("\n------ fetching books from database");
        System.out.println(this.bookRepository.findAll());

        System.out.println("\n\n------ working with flight and passenger ------");
        Flight f1 = new Flight();
        f1.setFlightNumber(1234);
        f1.setFrom("chicago");
        f1.setTo("new york");
        f1.setTime(LocalDateTime.of(2024, 7, 27, 15, 30));

        Flight f2 = new Flight();
        f2.setFlightNumber(3234);
        f2.setFrom("des moines");
        f2.setTo("new york");
        f2.setTime(LocalDateTime.of(2024, 7, 27, 11, 30));

        Flight f3 = new Flight();
        f3.setFlightNumber(12334);
        f3.setFrom("des moines");
        f3.setTo("new york");
        f3.setTime(LocalDateTime.of(2024, 6, 27, 10, 30));

        Flight f4 = new Flight();
        f4.setFlightNumber(5656);
        f4.setFrom("des moines");
        f4.setTo("new york");
        f4.setTime(LocalDateTime.of(2024, 6, 28, 18, 45));

        Flight f5 = new Flight();
        f5.setFlightNumber(8878);
        f5.setFrom("des moines");
        f5.setTo("new york");
        f5.setTime(LocalDateTime.of(2024, 8, 28, 18, 45));

        Passenger passenger = new Passenger("John");
        passenger.setFlights(List.of(f1, f2));

        Passenger passenger1 = new Passenger("Troy");
        passenger1.addFlight(f5);
        passenger1.addFlight(f3);
        passenger1.addFlight(f4);

        this.passengerRepository.saveAll(List.of(passenger, passenger1));
        System.out.println("\n------ fetching passenger from database");
        System.out.println(this.passengerRepository.findAll());


        System.out.println("\n\n------ working with student and school ------");

        Student s1 = studentRepository.save(new Student("Ben", "Affleck"));
        Student s2 = studentRepository.save(new Student("Hugh", "Jackman"));
        Student s3 = studentRepository.save(new Student("Tom", "Hardy"));
        Student s4 = studentRepository.save(new Student("Tom", "Cruise"));
        Student s5 = studentRepository.save(new Student("Ryan", "Reynolds"));

        School school = new School("myschool");
        School school1 = new School("myschool1");
        school.addStudent(s1);
        school.addStudent(s2);
        school1.addStudent(s3);
        school1.addStudent(s4);
        school1.addStudent(s5);

        this.schoolRepository.save(school);
        this.schoolRepository.save(school1);

        System.out.println("\n------ fetching school from database");
        System.out.println(this.schoolRepository.findAll());
    }
}
