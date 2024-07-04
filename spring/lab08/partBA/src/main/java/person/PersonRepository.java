package person;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PersonRepository extends JpaRepository<Person,Integer> {
    @Query("select p from Person p join fetch p.pets")
    List<Person> getAllWithJoinFetch();
}
