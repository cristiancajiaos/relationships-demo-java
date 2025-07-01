package com.example.relationshipsdemo.service;

import com.example.relationshipsdemo.dto.StoryDto;
import com.example.relationshipsdemo.entity.Story;
import com.example.relationshipsdemo.exception.StoryNotFoundException;
import com.example.relationshipsdemo.mapper.StoryMapper;
import com.example.relationshipsdemo.repository.StoryRepository;
import java.util.Optional;
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

  @Override
  public StoryDto getStoryById(Long id) throws StoryNotFoundException {
    Optional<Story> foundStory = storyRepository.findById(id);
    if (foundStory.isEmpty()) {
      throw new StoryNotFoundException("Story with ID " + id + " not found");
    }
    return StoryMapper.mapToStoryDto(foundStory.get());
  }
}
