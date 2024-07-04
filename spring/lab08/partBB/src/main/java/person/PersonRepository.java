package person;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface PersonRepository extends MongoRepository<Person,String> {
    @Query("{}")
    List<Person> getAllPersonsWithPets();
}
