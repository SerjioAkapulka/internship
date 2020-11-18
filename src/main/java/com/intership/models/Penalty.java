package com.intership.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import java.util.UUID;
@Entity
public class Penalty {
    @Id
    private UUID id;


    @ManyToOne
    private Client client;
    private String title;
    private int cost;
    private boolean wasPayed;

    public boolean isWasPayed() {
        return wasPayed;
    }

    public void setWasPayed(boolean wasPayed) {
        this.wasPayed = wasPayed;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Penalty() {
        this.wasPayed = false;
    }
    @PrePersist
    public void generateUUID() {
        if(this.id == null) {
            this.id = UUID.randomUUID();
        }
    }
    public Penalty(UUID id, Client client, String title, int cost) {
        this.id = id;
        this.client = client;
        this.title = title;
        this.cost = cost;
    }



    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
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
