package repository;

import entity.CenterEntity;
import entity.CourseEntity;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CenterRepository extends CrudRepository<CenterEntity, Integer> {
     @Query(value="select * from course order by id asc limit ?1 offset ?2", nativeQuery = true)
     public List<CourseEntity> getEmployeesByPage4(int limit, int offset);
}