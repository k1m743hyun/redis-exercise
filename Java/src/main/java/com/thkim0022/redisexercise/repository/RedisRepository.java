package com.thkim0022.redisexercise.repository;

import com.thkim0022.redisexercise.data.entity.Person;
import org.springframework.data.repository.CrudRepository;

public interface RedisRepository extends CrudRepository<Person, String> {

}
