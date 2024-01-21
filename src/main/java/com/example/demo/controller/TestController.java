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

import com.example.demo.entity.TestEntity;
import com.example.demo.service.TestService;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private TestService testService;

    @GetMapping
    public ResponseEntity<Object> getTests() {
        try {
            return ResponseEntity.ok().body(testService.getTest());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getTest(@PathVariable(value="id") String id) {
        try {
            Long test_id = Long.parseLong(id);
            return ResponseEntity.ok().body(testService.getTestById(test_id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTest(@PathVariable(value="id") String id) {
        try {
            Long test_id = Long.parseLong(id);
            testService.deleteTest(test_id);
            return ResponseEntity.ok().body("Пользователь успешно удален");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }

    @PostMapping
    public ResponseEntity<String> postTest(@RequestBody TestEntity test) {
        try {
            testService.createTest(test);
            return ResponseEntity.ok().body("Пользователь создан");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> putTest(@RequestBody TestEntity test, @PathVariable(value="id") String id) {
        try {
            Long test_id = Long.parseLong(id);
            testService.updateTest(test, test_id);
            return ResponseEntity.ok().body("Пользователь обновлен");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }
}
