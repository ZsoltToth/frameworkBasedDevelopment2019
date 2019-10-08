package hu.uni.eszterhazy.framework.data.repository;


import hu.uni.eszterhazy.framework.data.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface UserRepository extends CrudRepository<User, Long> {

    List<User> findUserByFirstname(String firstname);
}
