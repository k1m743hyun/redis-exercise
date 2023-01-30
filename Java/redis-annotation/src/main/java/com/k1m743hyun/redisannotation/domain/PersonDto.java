package com.k1m743hyun.redisannotation.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class PersonDto {

    protected static final ObjectMapper objectMapper = new ObjectMapper();
    public static final String KEY_PREFIX = "Person:";

    private String id;
    private String name;
    private String dept;
}
