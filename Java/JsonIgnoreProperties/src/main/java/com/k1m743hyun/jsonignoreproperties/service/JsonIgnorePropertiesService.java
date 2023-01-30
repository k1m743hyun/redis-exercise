package com.k1m743hyun.jsonignoreproperties.service;

import com.k1m743hyun.jsonignoreproperties.domain.NewPersonDto;
import com.k1m743hyun.jsonignoreproperties.domain.PersonDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class JsonIgnorePropertiesService {

    private final RedisTemplate<String, Object> redisTemplate;

    /**
     * STRING - Set
     * @param requestDto
     */
    public void setPerson(NewPersonDto requestDto) {
        log.info("{}.{}", getClass().getName(), Thread.currentThread().getStackTrace()[1].getMethodName());
        redisTemplate.opsForValue().set(requestDto.getKey(), requestDto);
    }

    /**
     * STRING - Get
     * @param personId
     * @return
     */
    public PersonDto getPerson(String personId) {
        log.info("{}.{}", getClass().getName(), Thread.currentThread().getStackTrace()[1].getMethodName());
        return PersonDto.of(redisTemplate.opsForValue().get(PersonDto.keyOf(personId)));
    }
}
