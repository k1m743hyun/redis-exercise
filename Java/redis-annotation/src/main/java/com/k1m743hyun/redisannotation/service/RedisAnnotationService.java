package com.k1m743hyun.redisannotation.service;

import com.k1m743hyun.redisannotation.domain.PersonDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class RedisAnnotationService {

    @CachePut(value = PersonDto.KEY_PREFIX, key = "#requestDto.id")
    public PersonDto setPerson(PersonDto requestDto) {
        log.info("{}.{}", getClass().getName(), Thread.currentThread().getStackTrace()[1].getMethodName());
        // TODO - DB 저장
        return requestDto;
    }

    @Cacheable(value = PersonDto.KEY_PREFIX, key = "#personId")
    public PersonDto getPerson(String personId) {
        log.info("{}.{}", getClass().getName(), Thread.currentThread().getStackTrace()[1].getMethodName());
        // TODO - DB 조회
        PersonDto person = PersonDto.builder()
            .id(personId)
            .name("HyunTae Kim")
            //.dept("Megazone")
            .build();
        return setPerson(person);
    }

    @CacheEvict(value = PersonDto.KEY_PREFIX, key = "#personId")
    public void deletePerson(String personId) {
        log.info("{}.{}", getClass().getName(), Thread.currentThread().getStackTrace()[1].getMethodName());
        // TODO - DB 삭제
    }
}

