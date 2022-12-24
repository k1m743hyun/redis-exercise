package com.thkim0022.redistemplate.controller;

import com.thkim0022.redistemplate.domain.PersonDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/set")
public class RedisTemplateSetController {

    private final RedisTemplateSetController service;

    public void setPerson(@RequestBody PersonDto requestDto) {
        log.info("{}.{}", getClass().getName(), Thread.currentThread().getStackTrace()[1].getMethodName());
        service.setPerson(requestDto);
    }

    @GetMapping("/{personId}")
    public List<PersonDto> getPersonList(@PathVariable String personId) {
        log.info("{}.{}", getClass().getName(), Thread.currentThread().getStackTrace()[1].getMethodName());
        return service.getPersonList(personId);
    }
}
