package com.thkim0022.redistemplate.controller;

import com.thkim0022.redistemplate.domain.PersonDto;
import com.thkim0022.redistemplate.service.RedisTemplateStringService;
import java.util.List;
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
@RequestMapping("/redis/string")
public class RedisTemplateStringController {

    private final RedisTemplateStringService service;

    /**
     * STRING - Set
     * @param requestDto
     */
    @PostMapping
    public void setPerson(@RequestBody PersonDto requestDto) {
        log.info("{}.{}", getClass().getName(), Thread.currentThread().getStackTrace()[1].getMethodName());
        service.setPerson(requestDto);
    }

    /**
     * STRING - Get
     * @param personId
     * @return
     */
    @GetMapping("/{personId}")
    public PersonDto getPerson(@PathVariable String personId) {
        log.info("{}.{}", getClass().getName(), Thread.currentThread().getStackTrace()[1].getMethodName());
        return service.getPerson(personId);
    }

    /**
     * STRING - Multi Set
     * @param requestDtos
     */
    @PostMapping("/all")
    public void setPersonList(@RequestBody List<PersonDto> requestDtos) {
        log.info("{}.{}", getClass().getName(), Thread.currentThread().getStackTrace()[1].getMethodName());
        service.setPersonList(requestDtos);
    }

    /**
     * STRING - Multi Get
     * @param personIds
     * @return
     */
    @GetMapping("/all")
    public List<PersonDto> getPersonList(@RequestBody List<String> personIds) {
        log.info("{}.{}", getClass().getName(), Thread.currentThread().getStackTrace()[1].getMethodName());
        return service.getPersonList(personIds);
    }
}
