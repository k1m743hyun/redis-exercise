package com.thkim0022.redistemplate.service;

import com.thkim0022.redistemplate.domain.PersonDto;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class RedisTemplateListService {

    private final RedisTemplate<String, Object> redisTemplate;

    /**
     * LIST - Set
     * @param requestDto
     */
    public void setPerson(PersonDto requestDto) {
        log.info("{}.{}", getClass().getName(), Thread.currentThread().getStackTrace()[1].getMethodName());
        //redisTemplate.opsForList().leftPush(requestDto.getKey(), requestDto);
        redisTemplate.opsForList().rightPush(requestDto.getKey(), requestDto);
    }

    /**
     * LIST - Get
     * @param personId
     * @return
     */
    public List<PersonDto> getPersonList(String personId) {
        log.info("{}.{}", getClass().getName(), Thread.currentThread().getStackTrace()[1].getMethodName());
        return redisTemplate.opsForList()
            .range(PersonDto.keyOf(personId), 0, -1)
            .stream()
            .map(PersonDto::of)
            .collect(Collectors.toList());
    }
}
