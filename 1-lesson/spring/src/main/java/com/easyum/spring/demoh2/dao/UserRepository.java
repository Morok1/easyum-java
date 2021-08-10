package com.easyum.spring.demoh2.dao;




import com.easyum.spring.demoh2.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {
}
