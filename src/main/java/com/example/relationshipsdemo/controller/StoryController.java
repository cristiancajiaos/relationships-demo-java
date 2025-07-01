package com.example.relationshipsdemo.controller;

import com.example.relationshipsdemo.dto.StoryDto;
import com.example.relationshipsdemo.exception.StoryNotFoundException;
import com.example.relationshipsdemo.service.StoryService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.graphql.GraphQlProperties.Http;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

  @GetMapping(value = "/{id}")
  public ResponseEntity<StoryDto> getStoryById(@PathVariable("id") Long id)
      throws StoryNotFoundException {
    try {
      StoryDto foundStory = storyService.getStoryById(id);
      return new ResponseEntity<>(foundStory, HttpStatus.OK);
    } catch (StoryNotFoundException ex) {
      throw ex;
    }
  }

  @GetMapping(value = "")
  public ResponseEntity<List<StoryDto>> getAllStories() {
    List<StoryDto> stories = storyService.getAllStories();
    return new ResponseEntity<>(stories, HttpStatus.OK);
  }
}
