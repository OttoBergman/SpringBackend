package com.vis.controller;

import com.vis.domain.Member;
import com.vis.exception.ResourceNotFoundException;
import com.vis.repository.MemberRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;

/**
 * Created by otto on 2016-01-07.
 */

@RestController
public class MemberController {

    @Inject
    private MemberRepository memberRepository;


    @RequestMapping(value = "/members", method = RequestMethod.GET)
    public ResponseEntity<?> getMembers(@RequestHeader RequestHeader requestHeader) {
        ResponseEntity<?> response = new ResponseEntity<>(memberRepository.findAll(), HttpStatus.OK);
        return response;
    }

    @RequestMapping (value = "/members/{memberId}", method = RequestMethod.GET)
    public ResponseEntity<?> getMember(@PathVariable Long memberId) {
        Member member = memberRepository.findOne(memberId);
        if (member == null) {
            throw new ResourceNotFoundException("Member with id " + memberId + " not found");
        }
        return new ResponseEntity<>(member, HttpStatus.OK);
    }

}
