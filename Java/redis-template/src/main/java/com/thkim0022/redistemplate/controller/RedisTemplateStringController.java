package com.thkim0022.redistemplate.controller;

import com.thkim0022.redistemplate.domain.PersonDto;
import com.thkim0022.redistemplate.service.RedisTemplateStringService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/redis/string")
@RestController
public class RedisTemplateStringController {

    private final RedisTemplateStringService service;

    /**
     * String - Set
     * @param requestDto
     */
    @PostMapping
    public void setPerson(@RequestBody PersonDto requestDto) {
        service.setPerson(requestDto);
    }

    /**
     * String - Get
     * @param personId
     * @return
     */
    @GetMapping("/{personId}")
    public PersonDto getPerson(@PathVariable String personId) {
        return service.getPerson(personId);
    }

    /**
     * String - Multi Set
     * @param requestDtos
     */
    @PostMapping("/all")
    public void setPersonList(@RequestBody List<PersonDto> requestDtos) {
        service.setPersonList(requestDtos);
    }

    /**
     * String - Multi Get
     * @param personIds
     * @return
     */
    @GetMapping("/all")
    public List<PersonDto> getPersonList(@RequestBody List<String> personIds) {
        return service.getPersonList(personIds);
    }
}
