package repository;

import entity.ActionEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ActionRepository extends CrudRepository<ActionEntity, Integer>{
}