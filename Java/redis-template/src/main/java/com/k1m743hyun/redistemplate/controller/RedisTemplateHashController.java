package com.k1m743hyun.redistemplate.controller;

import com.k1m743hyun.redistemplate.domain.PersonDto;
import com.k1m743hyun.redistemplate.service.RedisTemplateHashService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/redis/hash")
public class RedisTemplateHashController {

    private final RedisTemplateHashService service;

    /**
     * HASH - Set
     * @param hashKey
     * @param requestDto
     */
    @PostMapping("/{hashKey}")
    public void setPerson(@PathVariable String hashKey, @RequestBody PersonDto requestDto) {
        log.info("{}.{}", getClass().getName(), Thread.currentThread().getStackTrace()[1].getMethodName());
        service.setPerson(hashKey, requestDto);
    }

    /**
     * HASH - Get
     * @param personId
     * @param hashKey
     * @return
     */
    @GetMapping("/{personId}/{hashKey}")
    public PersonDto getPerson(@PathVariable String personId, @PathVariable String hashKey) {
        log.info("{}.{}", getClass().getName(), Thread.currentThread().getStackTrace()[1].getMethodName());
        return service.getPerson(personId, hashKey);
    }
}
