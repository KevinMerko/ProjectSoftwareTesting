package com.example.demo.controller;

import com.example.demo.dto.FeedbackDto;
import com.example.demo.services.FeedbackServices;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("api/feedback")
public class FeedbackController {
    private FeedbackServices feedbackServices;

    @PostMapping("/save/{productId}")
    public ResponseEntity<FeedbackDto> save(@RequestBody FeedbackDto feedbackDto, @PathVariable("productId") Long productId){
        return new ResponseEntity<>(feedbackServices.save(feedbackDto,productId), HttpStatus.CREATED);
    }

    @GetMapping("/findAll/{productId}")
    public ResponseEntity<List<FeedbackDto>> findAll(@PathVariable("productId") Long productId){
        return ResponseEntity.ok(feedbackServices.findAll(productId));
    }
    @GetMapping("/findById/{productId}/{feedbackId}")
    public ResponseEntity<FeedbackDto> findById(@PathVariable("productId") Long productId,@PathVariable("feedbackId") Long feedbackId){
        return ResponseEntity.ok(feedbackServices.findById(productId,feedbackId));
    }
    @PutMapping("/update/{productId}/{feedbackId}")
    public ResponseEntity<FeedbackDto> update(@RequestBody FeedbackDto feedbackDto, @PathVariable("productId") Long productId, @PathVariable("feedbackId")Long feedbackId){
        return ResponseEntity.ok(feedbackServices.update(productId,feedbackId,feedbackDto));
    }
    @DeleteMapping("/delete//{productId}/{feedbackId}")
    public ResponseEntity<String> delete(@PathVariable("productId") Long productId, @PathVariable("feedbackId") Long feedbackId){
        feedbackServices.delete(productId, feedbackId);
        return ResponseEntity.ok("Feedback with id:"+feedbackId+"was successfully deleted.");
    }
}
