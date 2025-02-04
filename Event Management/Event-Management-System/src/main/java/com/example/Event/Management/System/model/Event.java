package com.example.Event.Management.System.model;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@Document(collection = "events")
public class Event {
    @Id
    private String id;

    @NotBlank
    private String name;
    private LocalDate date;

    @NotBlank
    private String location;
    private String description;
    private List<Attendee> attendees = new ArrayList<>();
}