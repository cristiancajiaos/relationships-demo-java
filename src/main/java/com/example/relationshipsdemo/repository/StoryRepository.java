package com.example.relationshipsdemo.repository;

import com.example.relationshipsdemo.entity.Story;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoryRepository extends JpaRepository<Story, Long> {

}
