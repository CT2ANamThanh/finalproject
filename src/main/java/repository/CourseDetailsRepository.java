package repository;

import entity.CourseDetailsEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseDetailsRepository extends CrudRepository<CourseDetailsEntity, Integer> {
}
