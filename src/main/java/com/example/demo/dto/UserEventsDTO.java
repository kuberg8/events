package com.example.demo.dto;

import java.sql.Date;
import java.sql.Time;

import com.example.demo.entity.EventTypesEntity;

public class UserEventsDTO {
    private Long id;
    private Date date;
    private Time time;
    private String name;
    private String description;
    private String country;
    private String city;
    private Long member_count;
    private Long max_member_count;

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
    public Boolean getConfirmation() {
        return confirmation;
    }
    public void setConfirmation(Boolean confirmation) {
        this.confirmation = confirmation;
    }
    private Boolean confirmation;

    private EventTypesEntity event_type;

    public EventTypesEntity getEventType() {
        return event_type;
    }
    public void setEventType(EventTypesEntity event_type) {
        this.event_type = event_type;
    }
}
