package com.example.relationshipsdemo.service;

import com.example.relationshipsdemo.dto.StoryDto;
import com.example.relationshipsdemo.entity.Story;
import com.example.relationshipsdemo.exception.StoryNotFoundException;
import com.example.relationshipsdemo.mapper.StoryMapper;
import com.example.relationshipsdemo.repository.StoryRepository;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
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

  @Override
  public List<StoryDto> getAllStories() {
    List<Story> stories = storyRepository.findAll();
    return stories.stream().map((st) -> StoryMapper.mapToStoryDto(st)).collect(Collectors.toList());
  }

  @Override
  public StoryDto updateStory(StoryDto storyDto) throws StoryNotFoundException {
    Long id = storyDto.getStoryId();
    Optional<Story> foundStory = storyRepository.findById(id);
    if (foundStory.isEmpty()) {
      throw new StoryNotFoundException("Story with ID " + id + " not found");
    }
    Story storyToUpdate = foundStory.get();
    storyToUpdate.setStoryName(storyDto.getStoryName());
    storyToUpdate.setBook(storyDto.getBook());
    Story updatedStory = storyRepository.save(storyToUpdate);
    return StoryMapper.mapToStoryDto(updatedStory);
  }

  @Override
  public StoryDto deleteStory(Long id) throws StoryNotFoundException {
    Optional<Story> foundStory = storyRepository.findById(id);
    if (foundStory.isEmpty()) {
      throw new StoryNotFoundException("Story with ID " + id + " not found");
    }
    Story foundStoryToBeDeleted = foundStory.get();
    storyRepository.deleteById(id);
    return StoryMapper.mapToStoryDto(foundStoryToBeDeleted);
  }
}
