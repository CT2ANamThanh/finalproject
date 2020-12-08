package repository;

import entity.EnquiryEntity;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnquiryRepository extends CrudRepository<EnquiryEntity, Integer> {
    EnquiryEntity findById(int id);
    
    List<EnquiryEntity> findByNameLikeOrEnquiryStatusLike(String name,String enquiryStatus);
}