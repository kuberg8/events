package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;
import com.example.demo.entity.EventEntity;

public interface EventsRepo extends CrudRepository<EventEntity, Long> {}
