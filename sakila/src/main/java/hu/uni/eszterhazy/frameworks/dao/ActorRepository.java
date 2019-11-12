package hu.uni.eszterhazy.frameworks.dao;

import hu.uni.eszterhazy.frameworks.model.Actor;
import org.springframework.data.repository.CrudRepository;

public interface ActorRepository extends CrudRepository<Actor, Long> {
}
