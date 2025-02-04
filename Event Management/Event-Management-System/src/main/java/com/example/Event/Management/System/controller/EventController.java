package com.example.Event.Management.System.controller;

import com.example.Event.Management.System.model.Attendee;
import com.example.Event.Management.System.model.Event;
import com.example.Event.Management.System.service.EventService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/events")
public class EventController {
    private final EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping
    public List<Event> getAllEvents() {
        return eventService.getAllEvents();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Event> getEventById(@PathVariable String id) {
        return eventService.getEventById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Event createEvent(@Valid @RequestBody Event event) {
        return eventService.createEvent(event);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Event> updateEvent(@PathVariable String id, @Valid @RequestBody Event eventDetails) {
        return ResponseEntity.ok(eventService.updateEvent(id, eventDetails));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEvent(@PathVariable String id) {
        eventService.deleteEvent(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{id}/attendees")
    public ResponseEntity<Event> addAttendee(@PathVariable String id, @Valid @RequestBody Attendee attendee) {
        return ResponseEntity.ok(eventService.addAttendee(id, attendee));
    }

    @GetMapping("/{id}/attendees")
    public ResponseEntity<List<Attendee>> getAttendees(@PathVariable String id) {
        return eventService.getEventById(id)
                .map(event -> ResponseEntity.ok(event.getAttendees()))
                .orElse(ResponseEntity.notFound().build());
    }
}