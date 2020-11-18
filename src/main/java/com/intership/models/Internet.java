package com.intership.models;

import javax.persistence.*;
import java.util.UUID;

@Entity
public class Internet {
    @Id
    private UUID id;

    @ManyToOne
    private Client client;
    private Title title;
    private int cost;
    private boolean wasPayed;

    public enum Title {
        RosTeleKom, MTS, SBER
    }

    public Internet() {
        this.wasPayed = false;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    @PrePersist
    public void generateUUID() {
        if (this.id == null) {
            this.id = UUID.randomUUID();
        }

        //Выбрасывать эксепшон
        if (this.cost <= 0) {

        }
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Internet(UUID id, Client client, Title title, int cost) {
        this.id = id;
        this.client = client;
        this.title = title;
        this.cost = cost;
    }

    public Title getTitle() {
        return title;
    }

    public void setTitle(Title title) {
        this.title = title;
    }

    public boolean isWasPayed() {
        return wasPayed;
    }

    public void setWasPayed(boolean wasPayed) {
        this.wasPayed = wasPayed;
    }
}
