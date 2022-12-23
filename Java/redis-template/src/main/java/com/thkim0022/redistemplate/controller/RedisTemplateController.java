package com.thkim0022.redistemplate.controller;

import com.thkim0022.redistemplate.domain.PersonDto;
import com.thkim0022.redistemplate.service.RedisTemplateService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/redis")
@RestController
public class RedisTemplateController {

    private final RedisTemplateService service;

    // Set
    @PostMapping
    public void savePerson(@RequestBody PersonDto requestDto) {
        service.savePerson(requestDto);
    }

    // Get
    @GetMapping("/{personId}")
    public PersonDto getPerson(@PathVariable String personId) {
        return service.getPerson(personId);
    }

    // Multi Set
    @PostMapping("/all")
    public void savePersonList(@RequestBody List<PersonDto> requestDtos) {
        service.savePersonList(requestDtos);
    }

    // Multi Get
    @GetMapping("/all")
    public List<PersonDto> getPersonList(@RequestBody List<String> personIds) {
        return service.getPersonList(personIds);
    }
}
