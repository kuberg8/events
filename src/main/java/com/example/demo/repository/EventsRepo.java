package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entity.EventEntity;

public interface EventsRepo extends JpaRepository<EventEntity, Long> {}
