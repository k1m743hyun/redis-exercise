package com.thkim0022.redistemplate.service;

import com.thkim0022.redistemplate.domain.PersonDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ScanOptions;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@Service
public class RedisTemplateSetService {

    private final RedisTemplate<String, Object> redisTemplate;

    /**
     * SET - Set
     * @param requestDto
     */
    public void setPerson(PersonDto requestDto) {
        log.info("{}.{}", getClass().getName(), Thread.currentThread().getStackTrace()[1].getMethodName());
        redisTemplate.opsForSet().add(requestDto.getKey(), requestDto);
    }

    /**
     * SET - Get
     * @param personId
     * @return
     */
    public List<PersonDto> getPersonList(String personId) {
        log.info("{}.{}", getClass().getName(), Thread.currentThread().getStackTrace()[1].getMethodName());
        return redisTemplate.opsForSet()
                .scan(PersonDto.keyOf(personId), ScanOptions.scanOptions().match("*").build())
                .stream()
                .map(PersonDto::of)
                .collect(Collectors.toList());
    }
}
