package com.vis.controller;

import com.vis.domain.Event;
import com.vis.exception.ResourceNotFoundException;
import com.vis.repository.EventRepository;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.inject.Inject;
import java.net.URI;

/**
 * Created by otto on 2016-01-07.
 */

@RestController
public class EventController {

    @Inject
    private EventRepository eventRepository;

    @CrossOrigin
    @RequestMapping(value = "/events", method = RequestMethod.GET)
    public ResponseEntity<Iterable<Event>> getAllEvents() {
        Iterable<Event> allEvents = eventRepository.findAll();
        return new ResponseEntity<>(allEvents, HttpStatus.OK);
    }

    @CrossOrigin
    @RequestMapping (value = "/events/{eventId}", method = RequestMethod.GET)
    public ResponseEntity<?> getEvent(@PathVariable Long eventId) {
        Event event = eventRepository.findOne(eventId);
        if (event == null) {
            throw new ResourceNotFoundException("Member with id " + eventId + " not found");
        }
        return new ResponseEntity<>(event, HttpStatus.OK);
    }

    @CrossOrigin
    @RequestMapping (value = "/events", method = RequestMethod.POST)
    public ResponseEntity<?> createMember(@RequestBody Event event) {
        event = eventRepository.save(event);

        // Set the location header for the newly created resource
        HttpHeaders responseHeaders = new HttpHeaders();
        URI newPollUri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(event.getEventID()).toUri();
        responseHeaders.setLocation(newPollUri);

        return new ResponseEntity<>(null, responseHeaders, HttpStatus.CREATED);
    }

    @CrossOrigin
    @RequestMapping(value="/events/{eventId}", method=RequestMethod.PUT)
    public ResponseEntity<?> updateEvent(@RequestBody Event event, @PathVariable Long eventId) {
        verifyEvent(eventId);
        eventRepository.save(event);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @CrossOrigin
    @RequestMapping(value="/events/{eventId}", method=RequestMethod.DELETE)
    public ResponseEntity<?> deleteEvent(@PathVariable Long eventId) {
        verifyEvent(eventId);
        eventRepository.delete(eventId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @CrossOrigin
    protected void verifyEvent(Long eventId) throws ResourceNotFoundException {
        Event event = eventRepository.findOne(eventId);
        if(event == null) {
            throw new ResourceNotFoundException("Event with id " + eventId + " not found");
        }
    }

}