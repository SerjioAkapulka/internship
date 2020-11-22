package com.intership.dto;

import com.intership.models.Contract;

import javax.validation.constraints.NotNull;
import java.util.UUID;

public class ContractDto {
    @NotNull(message = "Идентификатор контракта не должен быть null")
    private UUID id;
    @NotNull(message = "Идентификатор клиента не должен быть null")
    private UUID clientId;
    @NotNull(message = "Статус не должен быть null")
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
