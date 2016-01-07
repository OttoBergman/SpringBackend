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
    @Column(name = "VIS_number")
    private String id;

    @Column(name = "Name")
    private String name;

    @Column(name = "Family_name")
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

    @Column(name = "Origin")
    private String origiin;

    @Column(name = "Student_type")
    private String studentType;

    @Column(name = "Accept_data_collection")
    private boolean acceptsDataCollection;

    @Column(name = "Can_be_shared")
    private boolean acceptsSharing;

    @Column(name = "Length_of_membership")
    private String lengthMembership;

    @Column(name = "Diet_restriction")
    private String dietRestriction;

    @Column(name = "Date_added")
    private String dateAdded;

    public Member() {
    }
}
