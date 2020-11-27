package repository;

import entity.StudentEntity;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends CrudRepository<StudentEntity, Integer> {
    StudentEntity findById(int id);
   
     List<StudentEntity> findByFirstNameLikeOrLastNameLike(String firstName,String lastName);
} 