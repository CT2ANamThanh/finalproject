package repository;

import entity.DiscountTypeEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiscountTypeRepository extends CrudRepository<DiscountTypeEntity, Integer> {
}
