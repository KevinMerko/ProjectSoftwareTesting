package com.example.demo.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
public class FeedbackDto {
    private long id;
    private String name;
    private String email;
    private String description;

}
