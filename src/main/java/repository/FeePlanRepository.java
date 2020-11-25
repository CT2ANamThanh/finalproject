package repository;

import entity.FeePlanEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeePlanRepository extends CrudRepository<FeePlanEntity, Integer> {
}