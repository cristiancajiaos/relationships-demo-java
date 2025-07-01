package com.example.relationshipsdemo.service;

import com.example.relationshipsdemo.dto.StoryDto;
import com.example.relationshipsdemo.exception.StoryNotFoundException;
import java.util.List;

public interface StoryService {
  StoryDto createStory(StoryDto storyDto);

  StoryDto getStoryById(Long id) throws StoryNotFoundException;

  List<StoryDto> getAllStories();

  StoryDto updateStory(StoryDto storyDto) throws StoryNotFoundException;

  StoryDto deleteStory(Long id) throws StoryNotFoundException;
}
