package com.k1m743hyun.redistemplate.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
@JsonIgnoreProperties(ignoreUnknown = true)
public class PersonDto {

    protected static final ObjectMapper objectMapper = new ObjectMapper();
    public static final String KEY_PREFIX = "Person:";

    private String id;
    private String name;
    private String dept;

    @JsonIgnore
    public String getKey() {
        return KEY_PREFIX + id;
    }

    public static String keyOf(String id) {
        return KEY_PREFIX + id;
    }

    public static PersonDto of(Object json) {
        return objectMapper.convertValue(json, PersonDto.class);
    }
}
