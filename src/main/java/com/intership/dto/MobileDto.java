package com.intership.dto;

import com.intership.models.Mobile;

import javax.validation.constraints.NotNull;
import java.util.UUID;

public class MobileDto {
    @NotNull(message = "Идентификатор мобильного оператора не должен быть null")
    private UUID id;
    @NotNull(message = "Идентификатор клиента не должен быть null")
    private UUID clientId;
    @NotNull(message = "Наименование мобильного оператора  не должен быть null")
    private Mobile.Title title;
    @NotNull(message = "Стоимость не должна быть null")
    private int cost;

    public MobileDto(UUID id, UUID clientId, Mobile.Title title, int cost) {
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

    public Mobile.Title getTitle() {
        return title;
    }

    public void setTitle(Mobile.Title title) {
        this.title = title;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }
}
