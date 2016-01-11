package com.vis.controller;

import com.vis.domain.Member;
import com.vis.exception.ResourceNotFoundException;
import com.vis.repository.MemberRepository;
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
public class MemberController {

    @Inject
    private MemberRepository memberRepository;

    @CrossOrigin
    @RequestMapping(value = "/members", method = RequestMethod.GET)
    public ResponseEntity<Iterable<Member>> getAllMembers() {
        Iterable<Member> allMembers = memberRepository.findAll();
        return new ResponseEntity<>(allMembers, HttpStatus.OK);
    }

    @CrossOrigin
    @RequestMapping (value = "/members/{memberId}", method = RequestMethod.GET)
    public ResponseEntity<?> getMember(@PathVariable Long memberId) {
        Member member = memberRepository.findOne(memberId);
        if (member == null) {
            throw new ResourceNotFoundException("Member with id " + memberId + " not found");
        }
        return new ResponseEntity<>(member, HttpStatus.OK);
    }

    @CrossOrigin
    @RequestMapping (value = "/members", method = RequestMethod.POST)
    public ResponseEntity<Member> createMember(@RequestBody Member member) {
        member = memberRepository.save(member);

        // Set the location header for the newly created resource
        HttpHeaders responseHeaders = new HttpHeaders();
        URI newPollUri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(member.getId()).toUri();
        responseHeaders.setLocation(newPollUri);

        return new ResponseEntity<>(null, responseHeaders, HttpStatus.CREATED);
    }

    @CrossOrigin
    @RequestMapping(value="/members/{memberId}", method=RequestMethod.PUT)
    public ResponseEntity<?> updateMember(@RequestBody Member member, @PathVariable Long memberId) {
        verifyMember(memberId);
        memberRepository.save(member);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @CrossOrigin
    @RequestMapping(value="/members/{memberId}", method=RequestMethod.DELETE)
    public ResponseEntity<?> deleteMember(@PathVariable Long memberId) {
        verifyMember(memberId);
        memberRepository.delete(memberId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    protected void verifyMember(Long memberId) throws ResourceNotFoundException {
        Member member = memberRepository.findOne(memberId);
        if(member == null) {
            throw new ResourceNotFoundException("Member with id " + memberId + " not found");
        }
    }

}
