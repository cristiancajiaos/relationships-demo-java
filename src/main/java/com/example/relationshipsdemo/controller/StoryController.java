package com.example.relationshipsdemo.controller;

import com.example.relationshipsdemo.dto.StoryDto;
import com.example.relationshipsdemo.service.StoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value = "/story")
public class StoryController {

  @Autowired
  private StoryService storyService;

  @PostMapping(value = "/save")
  public ResponseEntity<StoryDto> createStory(@RequestBody StoryDto storyDto) {
    StoryDto createdStory = storyService.createStory(storyDto);
    return new ResponseEntity<>(createdStory, HttpStatus.OK);
  }



}
