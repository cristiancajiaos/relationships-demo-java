package com.example.relationshipsdemo.service;

import com.example.relationshipsdemo.dto.StoryDto;
import com.example.relationshipsdemo.entity.Story;
import com.example.relationshipsdemo.mapper.StoryMapper;
import com.example.relationshipsdemo.repository.StoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StoryServiceImpl implements StoryService {

  @Autowired
  private StoryRepository storyRepository;

  @Override
  public StoryDto createStory(StoryDto storyDto) {
    Story story = StoryMapper.mapToStory(storyDto);
    Story createdStory = storyRepository.save(story);
    return StoryMapper.mapToStoryDto(createdStory);
  }
}
