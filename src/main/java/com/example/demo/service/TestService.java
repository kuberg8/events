package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.entity.TestEntity;
import com.example.demo.repository.TestRepo;

@Service
public class TestService {
    @Autowired
    private TestRepo testRepo;

    public TestEntity createTest(TestEntity test) {
        return testRepo.save(test);
    }

    public TestEntity updateTest(TestEntity newTest, Long id) {
        TestEntity test = testRepo.findById(id).get();
        test.setName(newTest.getName());
        return testRepo.save(test);
    }

    public Iterable<TestEntity> getTest() {
        return testRepo.findAll();
    }

    public Optional<TestEntity> getTestById(Long id) {
        return testRepo.findById(id);
    }

    public Long deleteTest(Long id) {
        testRepo.deleteById(id);
        return id;
    }
}
