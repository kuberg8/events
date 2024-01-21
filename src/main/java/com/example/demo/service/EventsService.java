package com.example.demo.service;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.EventDTO;
import com.example.demo.dto.EventUsersDTO;
import com.example.demo.entity.EventEntity;
import com.example.demo.entity.UserEntity;
import com.example.demo.repository.EventsRepo;

@Service
public class EventsService {
    @Autowired
    private EventsRepo eventsRepo;

    private EventDTO setEventDTO(EventEntity e) {
        EventDTO eventDTO = new EventDTO();
        eventDTO.setId(e.getId());
        eventDTO.setDate(e.getDate());
        eventDTO.setTime(e.getTime());
        eventDTO.setName(e.getName());
        eventDTO.setDescription(e.getDescription());
        eventDTO.setEventType(e.getEventType());
        eventDTO.setCountry(e.getCountry());
        eventDTO.setCity(e.getCity());
        eventDTO.setPlace(e.getPlace());
        eventDTO.setInventory(e.getInventory());
        eventDTO.setIsPrivate(e.getIsPrivate());
        eventDTO.setMemberCount(e.getMemberCount());
        eventDTO.setMaxMemberCount(e.getMaxMemberCount());
        eventDTO.setMaxAge(e.getMaxAge());
        eventDTO.setLevel(e.getLevel());
        eventDTO.setMinAge(e.getMinAge());
        eventDTO.setConfirmation(e.getConfirmation());

        UserEntity author = e.getAuthor();
        eventDTO.setAuthorId(author.getId());
        
        return eventDTO;
    }

    public EventEntity createEvent(EventEntity event) {
        return eventsRepo.save(event);
    }

    public Iterable<EventDTO> getEvents() {
        return StreamSupport.stream(eventsRepo.findAll().spliterator(), false)
        .map((e) -> {            
            return this.setEventDTO(e);
        }).collect(Collectors.toList());
    }

    public EventDTO getEventById(Long id) {
        EventEntity eventEntity = eventsRepo.findById(id).get();
        EventDTO eventDTO = new EventDTO();
        Set<UserEntity> eventUsers = eventEntity.getUsers();
        Set<EventUsersDTO> eventUsersDTO = new HashSet<EventUsersDTO>();

        eventDTO = this.setEventDTO(eventEntity);

        for (UserEntity eventUser : eventUsers) {
            EventUsersDTO eventUserDTO = new EventUsersDTO();

            eventUserDTO.setId(eventUser.getId());
            eventUserDTO.setAvatarUrl(eventUser.getAvatarUrl());
            eventUserDTO.setDisplayName(eventUser.getDisplayName());
            eventUserDTO.setPhone(eventUser.getPhone());
            
            eventUsersDTO.add(eventUserDTO);
        } 

        eventDTO.setUsers(eventUsersDTO);

        return eventDTO;
    }

    public Long deleteEvent(Long id) {
        eventsRepo.deleteById(id);
        return id;
    }
}