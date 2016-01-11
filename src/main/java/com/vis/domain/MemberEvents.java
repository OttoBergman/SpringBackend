package com.vis.domain;

import com.vis.keys.MemberEventsKey;

import javax.persistence.*;

/**
 * Created by otto on 2016-01-10.
 */

@Entity
@IdClass(MemberEventsKey.class)
@Table(name = "memberevents")
public class MemberEvents {

    @Id
    @Column(name = "memberID")
    long id;

    @Id
    @Column(name = "eventID")
    long eventID;

    MemberEvents() {

    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getEventID() {
        return eventID;
    }

    public void setEventID(long eventID) {
        this.eventID = eventID;
    }
}
