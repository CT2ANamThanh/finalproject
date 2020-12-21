package repository;

import entity.BatchEntity;
import entity.CourseEntity;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends CrudRepository<CourseEntity, Integer> {
    CourseEntity findById(int id);
    
    List<CourseEntity> findByNameContaining(String name);
    
    @Query(value="select * from course order by id asc limit ?1 offset ?2", nativeQuery = true)
     public List<CourseEntity> getEmployeesByPage3(int limit, int offset);
}