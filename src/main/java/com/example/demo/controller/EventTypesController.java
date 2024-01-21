package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.EventTypesEntity;
import com.example.demo.service.EventTypesService;

@RestController
@RequestMapping("/event-types")
public class EventTypesController {

    @Autowired
    private EventTypesService eventTypesService;

    @GetMapping
    public ResponseEntity<Object> getEventTypes() {
        try {
            return ResponseEntity.ok().body(eventTypesService.getEventTypes());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getEventType(@PathVariable(value="id") String id) {
        try {
            Long event_type_id = Long.parseLong(id);
            return ResponseEntity.ok().body(eventTypesService.getEventTypeById(event_type_id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEventType(@PathVariable(value="id") String id) {
        try {
            Long event_type_id = Long.parseLong(id);
            eventTypesService.deleteEventType(event_type_id);
            return ResponseEntity.ok().body("Тип события успешно удален");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }

    @PostMapping
    public ResponseEntity<String> postEventType(@RequestBody EventTypesEntity event_type) {
        try {
            eventTypesService.createEventType(event_type);
            return ResponseEntity.ok().body("Тип события создан");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> putEventType(@RequestBody EventTypesEntity event_type, @PathVariable(value="id") String id) {
        try {
            Long event_type_id = Long.parseLong(id);
            eventTypesService.updateEventType(event_type, event_type_id);
            return ResponseEntity.ok().body("Тип события обновлен");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }
}
