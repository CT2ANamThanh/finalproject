package repository;

import entity.StudentEntity;
import java.time.LocalDate;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends CrudRepository<StudentEntity, Integer> {
    StudentEntity findById(int id);
   StudentEntity findByUserId(int id);
   
   @Query(value="select * from student join users on student.userId= users.id where userName=?1",nativeQuery = true)
    StudentEntity getStudentByUserName(String userName);
   
     List<StudentEntity> findByFirstNameLikeOrLastNameLike(String firstName,String lastName);
     
     List<StudentEntity> findByStartDateBetween(LocalDate startDate,LocalDate endDate);
} 