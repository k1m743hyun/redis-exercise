package com.thkim0022.redisexercise.repository;

import com.thkim0022.redisexercise.data.entity.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class RedisRepositoryTest {

    @Autowired
    private RedisRepository repository;

    @Test
    void test() {
        Person person = new Person();
        person.setName("Taehyun Kim");
        person.setAge(30);

        // 저장
        repository.save(person);

        // `keyspace:id` 값을 가져옴
        repository.findById(person.getId());

        // Person Entity 의 @RedisHash 에 정의되어 있는 keyspace (people) 에 속한 키의 갯수를 구함
        repository.count();

        // 삭제
        repository.delete(person);
    }
}