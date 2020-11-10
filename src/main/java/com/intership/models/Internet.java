package com.intership.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Entity
public class Internet {
    @Id
    private UUID id;
    private UUID clientId;
    private String title;
    private int cost;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getClientId() {
        return clientId;
    }

    public void setClientId(UUID clientId) {
        this.clientId = clientId;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getInternetCost() {
        return cost;
    }

    public void setInternetCost(int cost) {
        this.cost = cost;
    }
}