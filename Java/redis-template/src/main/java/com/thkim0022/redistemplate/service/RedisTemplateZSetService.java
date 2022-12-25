package com.thkim0022.redistemplate.service;

import com.thkim0022.redistemplate.domain.PersonDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@Service
public class RedisTemplateZSetService {

    private final RedisTemplate<String, Object> redisTemplate;

    /**
     * ZSET - Set
     * @param score
     * @param requestDto
     */
    public void setPerson(double score, PersonDto requestDto) {
        redisTemplate.opsForZSet().add(requestDto.getKey(), requestDto, score);
    }

    /**
     * ZSET - Get
     * @param personId
     * @return
     */
    public List<PersonDto> getPersonList(String personId) {
        return redisTemplate.opsForZSet()
                .range(PersonDto.keyOf(personId), 0, -1)
                .stream()
                .map(PersonDto::of)
                .collect(Collectors.toList());
    }
}
