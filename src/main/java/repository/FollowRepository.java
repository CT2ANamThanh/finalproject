package repository;

import entity.FollowEntity;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface FollowRepository extends CrudRepository<FollowEntity, Integer>{
    FollowEntity findById(int id);
    List<FollowEntity> findByResultLike(String result);
}