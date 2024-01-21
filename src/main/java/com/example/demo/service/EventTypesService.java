package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.entity.EventTypesEntity;
import com.example.demo.repository.EventTypesRepo;

@Service
public class EventTypesService {
    @Autowired
    private EventTypesRepo eventTypesRepo;

    public EventTypesEntity createEventType(EventTypesEntity eventType) {
        return eventTypesRepo.save(eventType);
    }

    public EventTypesEntity updateEventType(EventTypesEntity newEventType, Long id) {
        EventTypesEntity eventType = eventTypesRepo.findById(id).get();
        eventType.setEventName(newEventType.getEventName());
        return eventTypesRepo.save(eventType);
    }

    public Iterable<EventTypesEntity> getEventTypes() {
        return eventTypesRepo.findAll();
    }

    public Optional<EventTypesEntity> getEventTypeById(Long id) {
        return eventTypesRepo.findById(id);
    }

    public Long deleteEventType(Long id) {
        eventTypesRepo.deleteById(id);
        return id;
    }
}
