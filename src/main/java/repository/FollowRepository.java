package repository;

import entity.EnquiryEntity;
import entity.FollowEntity;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface FollowRepository extends CrudRepository<FollowEntity, Integer>{
    FollowEntity findById(int id);
    List<FollowEntity> findByResultLike(String result);
    
    @Query(value = "select * from follow order by id asc LIMIT ?1 offset ?2", nativeQuery = true)
    public List<FollowEntity> getEmployeesByPage5(int limit, int offset);
}