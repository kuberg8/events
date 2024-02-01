package com.example.demo.service;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import com.example.demo.dto.EventDTO;
import com.example.demo.dto.EventUsersDTO;
import com.example.demo.dto.EventsWithCountDTO;
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

    public Iterable<EventDTO> getEvents(
        @RequestParam(name="page", defaultValue = "0") Integer page,
        @RequestParam(name="limit", defaultValue = "5") Integer limit,
        @RequestParam(name="sort", defaultValue = "date") String sort,
        @RequestParam(name="sort_type", defaultValue = "asc") String sort_type,
        @RequestParam(name="city", defaultValue = "") String city
    ) {
        PageRequest pageRequest = PageRequest.of(
            page, 
            limit, 
            Sort.by(sort_type.equals("asc") ? Sort.Direction.ASC : Sort.Direction.DESC, sort)
        );

        Page<EventEntity> events;
        if (city.isEmpty()) {
            events = eventsRepo.findAll(pageRequest);
        } else {
            events = eventsRepo.findByCityLike(city, pageRequest);
        }

        return StreamSupport.stream(events.spliterator(), false)
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

    public EventsWithCountDTO getEventsWithCount(
        @RequestParam(name="page", defaultValue = "0") Integer page,
        @RequestParam(name="limit", defaultValue = "5") Integer limit,
        @RequestParam(name="sort", defaultValue = "date") String sort,
        @RequestParam(name="sort_type", defaultValue = "asc") String sort_type,
        @RequestParam(name="city", defaultValue = "") String city
    ) {
        EventsWithCountDTO eventsWithCount = new EventsWithCountDTO();
        eventsWithCount.setItems(this.getEvents(page, limit, sort, sort_type, city));
        eventsWithCount.setTotalCount(eventsRepo.count());
        return eventsWithCount;
    }
}
