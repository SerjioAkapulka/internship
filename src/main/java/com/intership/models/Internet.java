package com.intership.models;

import javax.persistence.*;
import java.util.UUID;

@Entity
public class Internet {
    @Id
    private UUID id;
    private UUID clientId;
    private String title;
    private int cost;

    @PrePersist
    public void generateUUID() {
        if(this.id == null) {
            this.id = UUID.randomUUID();
        }
    }

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

    public Internet() {

    }

    public Internet(UUID id, UUID clientId, String title, int cost) {
        this.id = id;
        this.clientId = clientId;
        this.title = title;
        this.cost = cost;
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
