package com.example.demo.dto;

import java.sql.Date;
import java.sql.Time;
import java.util.HashSet;
import java.util.Set;

import com.example.demo.entity.EventTypesEntity;

public class EventDTO {
    private Long id;
    private Date date;
    private Time time;
    private String name;
    private String description;
    private String country;
    private String city;
    private String place;
    private Long member_count;
    private Long max_member_count;
    private Long min_age;
    private Long max_age;
    private Long level;
    private Boolean inventory;
    private Boolean is_private;
    private Boolean confirmation;
    private Long author_id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public Long getMemberCount() {
        return member_count;
    }

    public void setMemberCount(Long member_count) {
        this.member_count = member_count;
    }

    public Long getMaxMemberCount() {
        return max_member_count;
    }

    public void setMaxMemberCount(Long max_member_count) {
        this.max_member_count = max_member_count;
    }

    public Long getMinAge() {
        return min_age;
    }

    public void setMinAge(Long min_age) {
        this.min_age = min_age;
    }

    public Long getMaxAge() {
        return max_age;
    }

    public void setMaxAge(Long max_age) {
        this.max_age = max_age;
    }

    public Long getLevel() {
        return level;
    }

    public void setLevel(Long level) {
        this.level = level;
    }

    public Boolean getInventory() {
        return inventory;
    }

    public void setInventory(Boolean inventory) {
        this.inventory = inventory;
    }

    public Boolean getIsPrivate() {
        return is_private;
    }

    public void setIsPrivate(Boolean is_private) {
        this.is_private = is_private;
    }

    public Boolean getConfirmation() {
        return confirmation;
    }

    public void setConfirmation(Boolean confirmation) {
        this.confirmation = confirmation;
    }

    private EventTypesEntity event_type;

    public EventTypesEntity getEventType() {
        return event_type;
    }

    public void setEventType(EventTypesEntity event_type) {
        this.event_type = event_type;
    }

    public Long getAuthorId() {
        return author_id;
    }

    public void setAuthorId(Long author_id) {
        this.author_id = author_id;
    }

    private Set<EventUsersDTO> users = new HashSet<>();

    public Set<EventUsersDTO> getUsers() {
        return users;
    }

    public void setUsers(Set<EventUsersDTO> users) {
        this.users = users;
    }
}
