package com.vis.keys;

import java.io.Serializable;

/**
 * Created by otto on 2016-01-10.
 */
public class MemberEventsKey implements Serializable {
    private long id;
    private long eventID;


    public MemberEventsKey() {
    }

    public long getId() {
        return id;
    }

    public void setId(long memberID) {
        this.id = id;
    }

    public long getEventID() {
        return eventID;
    }

    public void setEventID(long eventID) {
        this.eventID = eventID;
    }


    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (!(obj instanceof MemberEventsKey)) return false;
        if (obj == null) return false;
        MemberEventsKey pk = (MemberEventsKey) obj;
        return pk.id == id && pk.eventID == eventID;
    }
}