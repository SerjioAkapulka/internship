package com.intership.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.time.OffsetDateTime;
import java.util.UUID;

@Entity
public class Contract {
    @Id
    private UUID id;

    @ManyToOne
    private Client client;
    private String status;

    @Column(name = "date")
    private OffsetDateTime dateTimeOfConcludeContract;

    public OffsetDateTime getDateTimeOfConcludeContract() {
        return dateTimeOfConcludeContract;
    }

    public void setDateTimeOfConcludeContract(OffsetDateTime dateTimeOfConcludeContract) {
        this.dateTimeOfConcludeContract = dateTimeOfConcludeContract;
    }

    public Contract() {}

    public Contract(UUID id, Client client, String status) {
        this.id = id;
        this.client = client;
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Client getClient() {
        return client;
    }

}
