package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;
import com.example.demo.entity.UserEntity;

public interface UsersRepo extends CrudRepository<UserEntity, Long> {}
