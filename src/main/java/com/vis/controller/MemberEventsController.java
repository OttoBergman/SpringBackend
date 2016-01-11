package com.vis.controller;

import com.vis.domain.Event;
import com.vis.domain.MemberEvents;
import com.vis.exception.ResourceNotFoundException;
import com.vis.keys.MemberEventsKey;
import com.vis.repository.EventRepository;
import com.vis.repository.MemberEventsRepository;
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
public class MemberEventsController {

    @Inject
    private MemberEventsRepository memberEventsRepository;

    @CrossOrigin
    @RequestMapping(value = "/memberevents", method = RequestMethod.GET)
    public ResponseEntity<Iterable<MemberEvents>> getAllMemberEvents() {
        Iterable<MemberEvents> allMemberEvents = memberEventsRepository.findAll();
        return new ResponseEntity<>(allMemberEvents, HttpStatus.OK);
    }

    @CrossOrigin
    @RequestMapping (value = "/memberevents/{memberEventId}", method = RequestMethod.GET)
    public ResponseEntity<?> getMemberEvent(@PathVariable MemberEventsKey key) {
        MemberEvents memberEvent = memberEventsRepository.findOne(key);
        if (memberEvent == null) {
            throw new ResourceNotFoundException("MemberEvent with id " + key + " not found");
        }
        return new ResponseEntity<>(memberEvent, HttpStatus.OK);
    }

    @CrossOrigin
    @RequestMapping (value = "/memberevents", method = RequestMethod.POST)
    public ResponseEntity<?> createMemberEvent(@RequestBody MemberEvents memberEvent) {
        memberEvent = memberEventsRepository.save(memberEvent);

        // Set the location header for the newly created resource
        HttpHeaders responseHeaders = new HttpHeaders();
        URI newPollUri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(
                memberEvent.getEventID() + memberEvent.getId()).toUri();
        responseHeaders.setLocation(newPollUri);

        return new ResponseEntity<>(null, responseHeaders, HttpStatus.CREATED);
    }

}