package com.example.demo.mapper;

import com.example.demo.dto.FeedbackDto;
import com.example.demo.entity.Feedback;
import org.springframework.stereotype.Component;

@Component
public class FeedbackMapper {
    public Feedback mapToEntity(FeedbackDto feedbackDto){
        Feedback feedback = new Feedback();
        feedback.setId(feedbackDto.getId());
        feedback.setName(feedbackDto.getName());
        feedback.setEmail(feedbackDto.getEmail());
        feedback.setDescription(feedbackDto.getDescription());
        return feedback;
    }
    public FeedbackDto mapToDto(Feedback feedback){
        FeedbackDto feedbackDto = new FeedbackDto();
        feedbackDto.setId(feedback.getId());
        feedbackDto.setName(feedback.getName());
        feedbackDto.setDescription(feedback.getDescription());
        feedback.setEmail(feedback.getEmail());
        return feedbackDto;
    }
}
