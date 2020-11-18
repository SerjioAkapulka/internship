package com.intership.dto;

import com.intership.models.Internet;

import java.util.UUID;

public class InternetDto {

    private UUID clientId;
    private Internet.Title title;
    private int cost;
    private UUID id;

    public InternetDto(UUID id, UUID clientId, Internet.Title title, int cost) {

        this.clientId = clientId;
        this.title = title;
        this.cost = cost;
        this.id = id;
    }

    public  InternetDto(){

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

    public Internet.Title getTitle() {
        return title;
    }

    public void setTitle(Internet.Title title) {
        this.title = title;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }
}
