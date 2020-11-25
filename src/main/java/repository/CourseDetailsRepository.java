package repository;

import entity.CourseDetailsEntity;
import entity.CourseEntity;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseDetailsRepository extends CrudRepository<CourseDetailsEntity, Integer> {
    CourseEntity findById(int id);
    
    List<CourseEntity> findByNameContainingOrFeePlanContaining(String name,String feeplan);
}