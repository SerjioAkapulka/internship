package com.intership.dto;

import io.swagger.annotations.ApiModelProperty;

import java.util.UUID;

public class ContractDto {
    @ApiModelProperty(value = "Идентификатор контракта")
    private UUID id;
    private UUID clientId;
    private String status;

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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
