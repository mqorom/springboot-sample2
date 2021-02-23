package com.exalt.trainingproject.model;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Machine {

    @Id
    private String id;
    private String name;
    private String ipAddress;
    private String location;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

    public Machine() {
        this.id = "device_".concat(String.valueOf(System.currentTimeMillis()));
    }

    public String getName() {
        return name;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public String getLocation() {
        return location;
    }

    public String getId() {
        return id;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
