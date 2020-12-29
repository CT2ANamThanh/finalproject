package repository;

import entity.BatchEntity;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BatchRepository extends CrudRepository<BatchEntity, Integer> {
     BatchEntity findById(int id);
     
     List<BatchEntity> findByBatchStatusLikeOrClassNameLike(String batchStatus,String className);
     
 
     @Query(value="select * from batch order by id asc limit ?1 offset ?2", nativeQuery = true)
     public List<BatchEntity> getEmployeesByPage2(int limit, int offset);
}