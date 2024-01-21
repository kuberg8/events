package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;
import com.example.demo.entity.EventTypesEntity;

public interface EventTypesRepo extends CrudRepository<EventTypesEntity, Long> {}
