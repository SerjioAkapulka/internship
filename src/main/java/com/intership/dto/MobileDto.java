package com.intership.dto;

import java.util.UUID;

public class MobileDto {
    private UUID id;
    private UUID clientId;
    private String title;
    private int cost;

    public MobileDto(UUID id, UUID clientId, String title, int cost) {
        this.id = id;
        this.clientId = clientId;
        this.title = title;
        this.cost = cost;
    }

    public MobileDto() {

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
