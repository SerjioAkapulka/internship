package com.intership.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import java.util.UUID;
@Entity
public class Penalty {
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

    public Penalty() {

    }
    @PrePersist
    public void generateUUID() {
        if(this.id == null) {
            this.id = UUID.randomUUID();
        }
    }
    public Penalty(UUID id, UUID clientId, String title, int cost) {
        this.id = id;
        this.clientId = clientId;
        this.title = title;
        this.cost = cost;
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

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }
}
