package com.intership.dto;


import com.intership.models.Penalty;

import java.util.UUID;

public class PenaltyDto {
    private UUID id;
    private UUID clientId;
    private Penalty.Title title;
    private int cost;

    public PenaltyDto(UUID id, UUID clientId, Penalty.Title title, int cost) {
        this.id = id;
        this.clientId = clientId;
        this.title = title;
        this.cost = cost;
    }

    public PenaltyDto() {

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

    public Penalty.Title getTitle() {
        return title;
    }

    public void setTitle(Penalty.Title title) {
        this.title = title;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }
}
