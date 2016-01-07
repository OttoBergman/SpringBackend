package com.vis.domain;

import javax.persistence.*;

/**
 * Created by otto on 2016-01-07.
 */

@Entity
@Table(name = "MEMBER")
public class Member {

    @Id
    @Column(name = "MEMBER_ID")
    private Long id;


    public Member() {
    }
}
