package com.example.demo.dto;

import java.util.HashSet;
import java.util.Set;

public class UserDTO {
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    private String display_name;

    public String getDisplayName() {
        return display_name;
    }

    public void setDisplayName(String display_name) {
        this.display_name = display_name;
    }    

    private String phone;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }    

    private String avatar_url;

    public String getAvatarUrl() {
        return avatar_url;
    }

    public void setAvatarUrl(String avatar_url) {
        this.avatar_url = avatar_url;
    }

    private Set<UserEventsDTO> events = new HashSet<>();

    public Set<UserEventsDTO> getEvents() {
        return events;
    }

    public void setEvents(Set<UserEventsDTO> events) {
        this.events = events;
    }    
}
