package com.vis.controller;

import com.vis.domain.User;
import com.vis.exception.ResourceNotFoundException;
import com.vis.repository.UserRepository;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.inject.Inject;
import java.net.URI;

/**
 * Created by otto on 2016-01-10.
 */


@RestController
public class UserController {

    @Inject
    private UserRepository userRepository;

    @CrossOrigin
    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public ResponseEntity<Iterable<User>> getAllUsers() {
        Iterable<User> allUsers = userRepository.findAll();
        return new ResponseEntity<>(allUsers, HttpStatus.OK);
    }

    @CrossOrigin
    @RequestMapping (value = "/users/{userId}/", method = RequestMethod.GET)
    public ResponseEntity<?> getUser(@PathVariable String userId) {
        User user = userRepository.findOne(userId);
        if (user == null) {
            throw new ResourceNotFoundException("User with email " + userId + " not found");
        }
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @CrossOrigin
    @RequestMapping (value = "/users", method = RequestMethod.POST)
    public ResponseEntity<User> createUser(@RequestBody User user) {
        user = userRepository.save(user);

        // Set the location header for the newly created resource
        HttpHeaders responseHeaders = new HttpHeaders();
        URI newPollUri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getEmail()).toUri();
        responseHeaders.setLocation(newPollUri);

        return new ResponseEntity<>(null, responseHeaders, HttpStatus.CREATED);
    }

    @CrossOrigin
    @RequestMapping(value="/users/{userId}", method=RequestMethod.PUT)
    public ResponseEntity<?> updateUser(@RequestBody User user, @PathVariable String userId) {
        verifyUser(userId);
        userRepository.save(user);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @CrossOrigin
    @RequestMapping(value="/users/{userId}", method=RequestMethod.DELETE)
    public ResponseEntity<?> deleteUser(@PathVariable String userId) {
        verifyUser(userId);
        userRepository.delete(userId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    protected void verifyUser(String userId) throws ResourceNotFoundException {
        User user = userRepository.findOne(userId);
        if(user == null) {
            throw new ResourceNotFoundException("User with email " + userId + " not found");
        }
    }

}


