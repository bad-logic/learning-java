package customers;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface StudentRepository extends MongoRepository<Student,Long> {

    List<Student> findByName(String name);
    List<Student> findByPhone(String phone);
    List<Student> findByAddressCity(String city);
    List<Student> findByGradesCourseName(String course);
    List<Student> findByGradesCourseNameAndGradesGrade(String course, String grade);

}
