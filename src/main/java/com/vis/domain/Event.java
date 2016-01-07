package com.vis.domain;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by oerlex on 2016-01-07.
 */

@Entity
@Table(name = "Event")
public class Event {
        @Id
        @GeneratedValue
        @Column(name = "EventID")
        private long eventID;

        @Column(name = "Name")
        private String Name;

        @Column(name = "Start_date")
        private Date startDate;

        @Column(name = "End_date")
        private Date endDate;

        @Column(name = "Price")
        private int price;

        @Column(name = "Max_tickets")
        private int maxTickets;

        @Column(name = "Rem_tickets")
        private int remTickets;

        @Column(name = "Max_temp_tickets")
        private int maxTempTickets;

        @Column(name = "Rem_temp_tickets")
        private int remainingTempTickets;

        @Column(name = "Description")
        private String description;

        public Event() {
        }

    public long getEventID() {
        return eventID;
    }

    public void setEventID(long eventID) {
        this.eventID = eventID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getMaxTickets() {
        return maxTickets;
    }

    public void setMaxTickets(int maxTickets) {
        this.maxTickets = maxTickets;
    }

    public int getRemTickets() {
        return remTickets;
    }

    public void setRemTickets(int remTickets) {
        this.remTickets = remTickets;
    }

    public int getMaxTempTickets() {
        return maxTempTickets;
    }

    public void setMaxTempTickets(int maxTempTickets) {
        this.maxTempTickets = maxTempTickets;
    }

    public int getRemainingTempTickets() {
        return remainingTempTickets;
    }

    public void setRemainingTempTickets(int remainingTempTickets) {
        this.remainingTempTickets = remainingTempTickets;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
