package repository;

import entity.EnquiryEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnquiryRepository extends CrudRepository<EnquiryEntity, Integer> {
}
