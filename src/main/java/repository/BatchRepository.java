package repository;

import entity.BatchEntity;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BatchRepository extends CrudRepository<BatchEntity, Integer> {
     BatchEntity findById(int id);
     
     List<BatchEntity> findByBatchStatusLikeOrClassNameLike(String batchStatus,String className);
}