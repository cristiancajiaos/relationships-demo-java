package com.example.relationshipsdemo.service;

import com.example.relationshipsdemo.dto.StoryDto;
import com.example.relationshipsdemo.exception.StoryNotFoundException;

public interface StoryService {
  StoryDto createStory(StoryDto storyDto);

  StoryDto getStoryById(Long id) throws StoryNotFoundException;
}
