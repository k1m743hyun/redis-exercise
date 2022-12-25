package com.thkim0022.redistemplate.controller;

import com.thkim0022.redistemplate.domain.PersonDto;
import com.thkim0022.redistemplate.service.RedisTemplateZSetService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/redis/zset")
public class RedisTemplateZSetController {

    private final RedisTemplateZSetService service;

    /**
     * ZSET - Set
     * @param score
     * @param requestDto
     */
    @PostMapping("/{score}")
    public void setPerson(@PathVariable double score, @RequestBody PersonDto requestDto) {
        log.info("{}.{}", getClass().getName(), Thread.currentThread().getStackTrace()[1].getMethodName());
        service.setPerson(score, requestDto);
    }

    /**
     * ZSET - Get
     * @param personId
     * @return
     */
    @GetMapping("/{personId}")
    public List<PersonDto> getPersonList(@PathVariable String personId) {
        log.info("{}.{}", getClass().getName(), Thread.currentThread().getStackTrace()[1].getMethodName());
        return service.getPersonList(personId);
    }
}
