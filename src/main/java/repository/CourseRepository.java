package repository;

import entity.CourseEntity;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends CrudRepository<CourseEntity, Integer> {
    CourseEntity findById(int id);
    
    List<CourseEntity> findByNameContaining(String name);
}