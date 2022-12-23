package com.thkim0022.redisexercise.service;

import com.thkim0022.redisexercise.data.dto.PersonDto;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class RedisTemplateService {

    private final RedisTemplate<String, Object> redisTemplate;

    /**
     * Set
     * @param requestDto
     */
    public void savePerson(PersonDto requestDto) {
        redisTemplate.opsForValue().set(requestDto.getKey(), requestDto);
    }

    /**
     * Get
     * @param personId
     * @return
     */
    public PersonDto getPerson(String personId) {
        return PersonDto.of(redisTemplate.opsForValue().get(PersonDto.keyOf(personId)));
    }

    /**
     * Multi Set
     * @param requestDtos
     */
    public void savePersonList(List<PersonDto> requestDtos) {
        Map<String, PersonDto> requestDtoMap = requestDtos.stream()
            .collect(Collectors.toMap(
                PersonDto::getKey,
                p2 -> p2
            ));
        redisTemplate.opsForValue().multiSet(requestDtoMap);
    }

    /**
     * Multi Get
     * @param personIds
     * @return
     */
    public List<PersonDto> getPersonList(List<String> personIds) {
        return redisTemplate.opsForValue()
            .multiGet(personIds.stream()
                .map(PersonDto::keyOf)
                .collect(Collectors.toList())
            )
            .stream()
            .map(PersonDto::of)
            .collect(Collectors.toList());
    }
}
