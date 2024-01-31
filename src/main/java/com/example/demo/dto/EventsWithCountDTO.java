package com.example.demo.dto;

public class EventsWithCountDTO {
    private Iterable<EventDTO> items;

    public Iterable<EventDTO> getItems() {
        return items;
    }

    public void setItems(Iterable<EventDTO> items) {
        this.items = items;
    }

    private Long total_count;

    public Long getTotalCount() {
        return total_count;
    }

    public void setTotalCount(Long total_count) {
        this.total_count = total_count;
    }
}
