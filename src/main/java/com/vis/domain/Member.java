package com.vis.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by otto on 2016-01-07.
 */

@Entity
@Table(name = "members")
public class Member {

    @Id
    @Column(name = "Id")
    @GenericGenerator(name="MemberIdGen" , strategy="increment")
    @GeneratedValue(generator = "MemberIdGen")
    private long id;

    @Column(name = "VIS_number")
    private String vis_number;

    @Column(name = "Name")
    private String name;

    @Column(name = "Family_name")
    private String family_name;

    @Column(name = "Gender")
    private String gender;

    @Column(name = "Email")
    private String email;

    @Column(name = "Birthday")
    private String birthday;

    @Column(name = "Address")
    private String address;

    @Column(name = "Phone")
    private String phone;

    @Column(name = "Origin")
    private String origin;

    @Column(name = "Student_type")
    private String student_type;

    @Column(name = "Accept_data_collection")
    private String accepts_data_collection;

    @Column(name = "Can_be_shared")
    private String can_be_shared;

    @Column(name = "Length_of_membership")
    private String length_of_membership;

    @Column(name = "Diet_restriction")
    private String diet_restriction;

    @Column(name = "Date_added")
    private String date_added;

    public Member() {
    }

    public long getId() {
        return id;
    }

        public void setId(long id) {
        this.id = id;
    }

    public String getVis_number() {
        return vis_number;
    }

    public void setVis_number(String vis_number) {
        this.vis_number = vis_number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getFamily_name() {
        return family_name;
    }

    public void setFamily_name(String family_name) {
        this.family_name = family_name;
    }

    public String getStudent_type() {
        return student_type;
    }

    public void setStudent_type(String student_type) {
        this.student_type = student_type;
    }

    public String getAccepts_data_collection() {
        return accepts_data_collection;
    }

    public void setAccepts_data_collection(String accepts_data_collection) {
        this.accepts_data_collection = accepts_data_collection;
    }

    public String getCan_be_shared() {
        return can_be_shared;
    }

    public void setCan_be_shared(String can_be_shared) {
        this.can_be_shared = can_be_shared;
    }

    public String getLength_of_membership() {
        return length_of_membership;
    }

    public void setLength_of_membership(String length_of_membership) {
        this.length_of_membership = length_of_membership;
    }

    public String getDiet_restriction() {
        return diet_restriction;
    }

    public void setDiet_restriction(String diet_restriction) {
        this.diet_restriction = diet_restriction;
    }

    public String getDate_added() {
        return date_added;
    }

    public void setDate_added(String date_added) {
        this.date_added = date_added;
    }
}
