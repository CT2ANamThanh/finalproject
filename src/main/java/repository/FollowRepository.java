package repository;

import entity.FollowEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface FollowRepository extends CrudRepository<FollowEntity, Integer>{
}