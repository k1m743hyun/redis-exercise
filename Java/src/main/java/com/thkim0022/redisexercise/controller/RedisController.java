package com.thkim0022.redisexercise.controller;

import com.thkim0022.redisexercise.data.dto.PersonDto;
import com.thkim0022.redisexercise.service.RedisTemplateService;
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
public class RedisController {

    private final RedisTemplateService service;

    /**
     * Set
     * @param requestDto
     */
    @PostMapping
    public void savePerson(@RequestBody PersonDto requestDto) {
        service.savePerson(requestDto);
    }

    /**
     * Get
     * @param personId
     * @return
     */
    @GetMapping("/{personId}")
    public PersonDto getPerson(@PathVariable String personId) {
        return service.getPerson(personId);
    }

    /**
     * Multi Set
     * @param requestDtos
     */
    @PostMapping("/all")
    public void savePersonList(@RequestBody List<PersonDto> requestDtos) {
        service.savePersonList(requestDtos);
    }

    /**
     * Multi Get
     * @param personIds
     * @return
     */
    @GetMapping("/all")
    public List<PersonDto> getPersonList(@RequestBody List<String> personIds) {
        return service.getPersonList(personIds);
    }
}
