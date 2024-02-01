package com.example.demo.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.EventEntity;

public interface EventsRepo extends JpaRepository<EventEntity, Long> {
    Page<EventEntity> findByCityLike(String city, PageRequest pageable);
    
    // @Query("SELECT * FROM events")
    // Page<EventEntity> findByDateLike(String date, PageRequest pageable);
}
