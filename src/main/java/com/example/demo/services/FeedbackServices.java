package com.example.demo.services;

import com.example.demo.dto.FeedbackDto;
import com.example.demo.entity.Feedback;
import com.example.demo.entity.Product;
import com.example.demo.mapper.FeedbackMapper;
import com.example.demo.repository.FeedbackRepository;
import com.example.demo.repository.ProductRespository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class FeedbackServices {

    private FeedbackRepository feedbackRepository;
    private FeedbackMapper feedbackMapper;
    private ProductRespository productRespository;

    public FeedbackDto save(FeedbackDto feedbackDto, long productId) {
        Product existingProduct = productRespository.findById(productId)
                        .orElseThrow(
                                () -> new RuntimeException("Product with id: " + productId + " was not found in the database"));
        Feedback feedback = feedbackMapper.mapToEntity(feedbackDto);
        feedback.setProduct(existingProduct);
        Feedback savedFeedback = feedbackRepository.save(feedback);
        return feedbackMapper.mapToDto(savedFeedback);
    }

    public List<FeedbackDto> findAll(long productId) {
        Product existingProduct = productRespository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product with id: " + productId + " was not found in the database"));
        List<Feedback> feedbackList = feedbackRepository.findByProductId(productId);
        return feedbackList.stream().map(feedback -> feedbackMapper.mapToDto(feedback))
                .collect(Collectors.toList());
    }

    public FeedbackDto findById(Long productId, Long feedbackId) {
        Product existingProduct = productRespository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product with id: " + productId + " was not found in the database"));

        Feedback existingFeedback = feedbackRepository.findById(feedbackId)
                .orElseThrow(() -> new RuntimeException("Feedback with id: " + feedbackId + " was not found."));

        if (!((existingProduct.getId()) == (existingFeedback.getProduct().getId()))) {
            throw new RuntimeException("Feedback with id: " + feedbackId + " doesn't correspond to product with id: " + productId);
        }
        return feedbackMapper.mapToDto(existingFeedback);
    }

    public FeedbackDto update(long productId, long feedbackId, FeedbackDto feedbackDto) {
        Product existingProduct = productRespository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product with id: " + productId + " was not found in the database"));
        Feedback existingFeedback = feedbackRepository.findById(feedbackId)
                .orElseThrow(() -> new RuntimeException("Feedback with id: " + feedbackId + " was not found."));
        if (!((existingProduct.getId()) == (existingFeedback.getProduct().getId()))) {
            throw new RuntimeException("Feedback with id: " + feedbackId + " doesn't correspond to product with id: " + productId);
        }
        Feedback feedback = new Feedback();
        feedback.setId(feedbackId);
        feedback.setName(feedbackDto.getName());
        feedback.setEmail(feedbackDto.getEmail());
        feedback.setDescription(feedbackDto.getDescription());
        Feedback savedFeedback = feedbackRepository.save(feedback);
        return feedbackMapper.mapToDto(savedFeedback);
    }

    public void delete(Long productId, Long feedbackId) {
        Product existingProduct = productRespository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product with id: " + productId + " was not found in the database"));
        Feedback existingFeedback = feedbackRepository.findById(feedbackId)
                .orElseThrow(() -> new RuntimeException("Feedback with id: " + feedbackId + " was not found."));
        if (!((existingProduct.getId()) == (existingFeedback.getProduct().getId()))) {
            throw new RuntimeException("Feedback with id: " + feedbackId + " doesn't correspond to product with id: " + productId);
        }
        feedbackRepository.delete(existingFeedback);
    }
}
