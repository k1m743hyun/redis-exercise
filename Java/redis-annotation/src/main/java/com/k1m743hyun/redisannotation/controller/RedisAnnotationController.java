package com.k1m743hyun.redisannotation.controller;

import com.k1m743hyun.redisannotation.domain.PersonDto;
import com.k1m743hyun.redisannotation.service.RedisAnnotationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/redis/annotation")
public class RedisAnnotationController {

    private final RedisAnnotationService service;

    /**
     * SET
     * @param requestDto
     */
    @PostMapping
    public void setPerson(@RequestBody PersonDto requestDto) {
        log.info("{}.{}", getClass().getName(), Thread.currentThread().getStackTrace()[1].getMethodName());
        service.setPerson(requestDto);
    }

    /**
     * GET
     * @param personId
     * @return
     */
    @GetMapping("/{personId}")
    public PersonDto getPerson(@PathVariable String personId) {
        log.info("{}.{}", getClass().getName(), Thread.currentThread().getStackTrace()[1].getMethodName());
        return service.getPerson(personId);
    }

    /**
     * DELETE
     * @param personId
     */
    @DeleteMapping("/{personId}")
    public void deletePerson(@PathVariable String personId) {
        log.info("{}.{}", getClass().getName(), Thread.currentThread().getStackTrace()[1].getMethodName());
        service.deletePerson(personId);
    }
}
