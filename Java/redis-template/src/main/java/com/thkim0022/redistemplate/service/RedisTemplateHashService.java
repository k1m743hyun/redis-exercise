package com.thkim0022.redistemplate.service;

import com.thkim0022.redistemplate.domain.PersonDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class RedisTemplateHashService {

    private final RedisTemplate<String, Object> redisTemplate;

    public void setPerson(String hashKey, PersonDto requestDto) {
        log.info("{}.{}", getClass().getName(), Thread.currentThread().getStackTrace()[1].getMethodName());
        redisTemplate.opsForHash().put(requestDto.getKey(), hashKey, requestDto);
    }

    public PersonDto getPerson(String personId, String hashKey) {
        log.info("{}.{}", getClass().getName(), Thread.currentThread().getStackTrace()[1].getMethodName());
        return PersonDto.of(redisTemplate.opsForHash().get(PersonDto.keyOf(personId), hashKey));
    }
}
