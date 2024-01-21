package com.example.demo.service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.UserDTO;
import com.example.demo.dto.UserEventsDTO;
import com.example.demo.entity.EventEntity;
import com.example.demo.entity.UserEntity;
import com.example.demo.repository.UsersRepo;

@Service
public class UsersService {
    @Autowired
    private UsersRepo usersRepo;

    private UserDTO setUserDTO(UserEntity e) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(e.getId());
        userDTO.setDisplayName(e.getDisplayName());
        userDTO.setAvatarUrl(e.getAvatarUrl());
        userDTO.setPhone(e.getPhone());
        
        return userDTO;
    }

    public UserEntity createUser(UserEntity user) {
        return usersRepo.save(user);
    }

    public List<UserDTO> getUsers() {
        return StreamSupport.stream(usersRepo.findAll().spliterator(), false)
        .map((e) -> {
            return this.setUserDTO(e);
        }).collect(Collectors.toList());
    }

    public UserDTO getUserById(Long id) {
        Optional<UserEntity> optioanlUserEntity = usersRepo.findById(id);
        UserEntity userEntity = optioanlUserEntity.get();
        UserDTO userDTO = new UserDTO();
        Set<EventEntity> userEvents = userEntity.getEvents();
        Set<UserEventsDTO> userEventsDTO = new HashSet<UserEventsDTO>();

        userDTO = this.setUserDTO(userEntity);

        for (EventEntity event : userEvents) {
            UserEventsDTO userEventDTO = new UserEventsDTO();

            userEventDTO.setId(event.getId());
            userEventDTO.setName(event.getName());
            userEventDTO.setDate(event.getDate());
            userEventDTO.setTime(event.getTime());
            userEventDTO.setCountry(event.getCountry());
            userEventDTO.setCity(event.getCity());
            userEventDTO.setConfirmation(event.getConfirmation());
            userEventDTO.setEventType(event.getEventType());

            userEventsDTO.add(userEventDTO);
        }

        userDTO.setEvents(userEventsDTO);

        return userDTO;
    }

    public Long deleteUser(Long id) {
        usersRepo.deleteById(id);
        return id;
    }

    public UserEntity updateUser(UserEntity newUser, Long id) {
        UserEntity user = usersRepo.findById(id).get();

        user.setAvatarUrl(newUser.getAvatarUrl());
        user.setDisplayName(newUser.getDisplayName());
        user.setPhone(newUser.getPhone());

        return usersRepo.save(user);
    }
}
