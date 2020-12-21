package repository;

import entity.EnquiryEntity;
import entity.StudentEntity;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnquiryRepository extends CrudRepository<EnquiryEntity, Integer> {
    EnquiryEntity findById(int id);
    
    List<EnquiryEntity> findByNameLikeOrEnquiryStatusLike(String name,String enquiryStatus);
    
    @Query(value = "select * from enquiry order by id asc LIMIT ?1 offset ?2", nativeQuery = true)
    public List<EnquiryEntity> getEmployeesByPage4(int limit, int offset);
}