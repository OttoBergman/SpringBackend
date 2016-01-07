package com.vis.domain;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by otto on 2016-01-07.
 */

@Entity
@Table(name = "MEMBER")
public class Member {

    @Id
    @Column(name = "VIS number")
    private Long id;

    @Column(name = "First name")
    private String name;

    @Column(name = "Last name")
    private String familyName;

    @Column(name = "Gender")
    private String sex;

    @Column(name = "Email")
    private String email;

    @Column(name = "Birthday")
    private Date birthday;

    @Column(name = "Address")
    private String address;

    @Column(name = "Phone")
    private String phoneNumber;

    @Column(name = "Country of origin")
    private String origiin;

    @Column(name = "Student type")
    private String studentType;

    @Column(name = "Accept data collection")
    private boolean acceptsDataCollection;

    @Column(name = "Can be shared")
    private boolean acceptsSharing;

    @Column(name = "Length of membership")
    private String lengthMembership;

    @Column(name = "Diet Restriction")
    private String dietRestriction;

    @Column(name = "Date added")
    private String dateAdded;

    public Member() {
    }
}
