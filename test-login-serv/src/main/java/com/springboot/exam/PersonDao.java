package com.springboot.exam;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface PersonDao extends CrudRepository<Person, Integer>{
	@Query("Select u from Person u where u.username=?1 and u.password=?2")
	 Person findUser(String name,String pwd);
}
