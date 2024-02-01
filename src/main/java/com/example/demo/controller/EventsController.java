package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.EventEntity;
import com.example.demo.service.EventsService;

@CrossOrigin //(origins = "http://localhost:3000")
@RestController
@RequestMapping("/events")
public class EventsController {

    @Autowired
    private EventsService eventService;

    @GetMapping
    public ResponseEntity<Object> getEvents(
        @RequestParam(name="page", defaultValue = "0") Integer page,
        @RequestParam(name="limit", defaultValue = "5") Integer limit,
        @RequestParam(name="sort", defaultValue = "date") String sort,
        @RequestParam(name="sort_type", defaultValue = "asc") String sort_type,
        @RequestParam(name="city", defaultValue = "") String city
    ) {
        try {
            return ResponseEntity.ok().body(eventService.getEventsWithCount(page, limit, sort, sort_type, city));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getEvent(@PathVariable(value="id") String id) {
        try {
            Long event_id = Long.parseLong(id);
            return ResponseEntity.ok().body(eventService.getEventById(event_id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEvent(@PathVariable(value="id") String id) {
        try {
            Long event_id = Long.parseLong(id);
            eventService.deleteEvent(event_id);
            return ResponseEntity.ok().body("Событие успешно удалено");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }

    @PostMapping
    public ResponseEntity<Object> postEvent(@RequestBody EventEntity event) {
        try {
            EventEntity newEvent = eventService.createEvent(event);
            return ResponseEntity.ok().body(newEvent);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }
}
