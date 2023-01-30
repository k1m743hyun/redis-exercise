package com.k1m743hyun.jsonignoreproperties.controller;

import com.k1m743hyun.jsonignoreproperties.domain.NewPersonDto;
import com.k1m743hyun.jsonignoreproperties.domain.PersonDto;
import com.k1m743hyun.jsonignoreproperties.service.JsonIgnorePropertiesService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/redis/json")
public class JsonIgnorePropertiesController {

    private final JsonIgnorePropertiesService service;

    /**
     * Set
     * @param requestDto
     */
    @PostMapping
    public void setPerson(@RequestBody NewPersonDto requestDto) {
        log.info("{}.{}", getClass().getName(), Thread.currentThread().getStackTrace()[1].getMethodName());
        service.setPerson(requestDto);
    }

    /**
     * Get
     * @param personId
     * @return
     */
    @GetMapping("/{personId}")
    public PersonDto getPerson(@PathVariable String personId) {
        log.info("{}.{}", getClass().getName(), Thread.currentThread().getStackTrace()[1].getMethodName());
        return service.getPerson(personId);
    }
}
