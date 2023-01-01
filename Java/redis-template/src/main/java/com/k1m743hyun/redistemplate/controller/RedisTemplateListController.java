package com.k1m743hyun.redistemplate.controller;

import com.k1m743hyun.redistemplate.domain.PersonDto;
import com.k1m743hyun.redistemplate.service.RedisTemplateListService;
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
@RequestMapping("/redis/list")
public class RedisTemplateListController {

    private final RedisTemplateListService service;

    /**
     * LIST - Set
     * @param requestDto
     */
    @PostMapping
    public void setPerson(@RequestBody PersonDto requestDto) {
        log.info("{}.{}", getClass().getName(), Thread.currentThread().getStackTrace()[1].getMethodName());
        service.setPerson(requestDto);
    }

    /**
     * LIST - Get
     * @param personId
     * @return
     */
    @GetMapping("/{personId}")
    public List<PersonDto> getPersonList(@PathVariable String personId) {
        log.info("{}.{}", getClass().getName(), Thread.currentThread().getStackTrace()[1].getMethodName());
        return service.getPersonList(personId);
    }
}
