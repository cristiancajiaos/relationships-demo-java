package com.example.relationshipsdemo.mapper;

import com.example.relationshipsdemo.dto.StoryDto;
import com.example.relationshipsdemo.entity.Story;

public class StoryMapper {

  public static StoryDto mapToStoryDto(Story story) {
    return new StoryDto(story.getStoryId(), story.getStoryName(), story.getBook(), story.getCreated(), story.getUpdated());
  }

  public static Story mapToStory(StoryDto storyDto) {
    return new Story(storyDto.getStoryId(), storyDto.getStoryName(), storyDto.getBook(), storyDto.getCreated(), storyDto.getUpdated());
  }
}
