package com.intership.dto;

import com.intership.models.Contract;
import io.swagger.annotations.ApiModelProperty;

import java.util.UUID;

public class ContractDto {
    @ApiModelProperty(value = "Идентификатор контракта")
    private UUID id;
    private UUID clientId;
    private Contract.Status status;

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

    public Contract.Status getStatus() {
        return status;
    }

    public void setStatus(Contract.Status status) {
        this.status = status;
    }
}
