package repositories;

import domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {
    List<Student> findByDepartmentName(String department);
    List<Student> findByGradesCourseName(String name);

    @Query("select distinct s from Student s join fetch s.department d where d.name=:department")
    List<Student> getStudentsByDepartment(@Param("department") String department);

    @Query("select distinct s from Student s join fetch s.grades g join fetch g.course c where c.name=:course")
    List<Student> getStudentsWhoTookACourse(@Param("course") String course);
}
