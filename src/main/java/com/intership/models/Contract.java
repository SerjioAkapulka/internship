package com.intership.models;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
public class Contract {
    @Id
    private UUID id;

    @ManyToOne
    @JoinColumn(updatable = false)
    private Client client;
    private Status status;

    public enum Status {
        ACTIVE,FROZEN,EXPIRED
    }

    @Column(name = "date")
    private Date dateTimeOfConcludeContract;

    public Date getDateTimeOfConcludeContract() {
        return dateTimeOfConcludeContract;
    }



    public void setDateTimeOfConcludeContract(Date dateTimeOfConcludeContract) {
        this.dateTimeOfConcludeContract = dateTimeOfConcludeContract;
    }

    public Contract() {}

    public Contract(UUID id, Client client, Status status) {
        this.id = id;
        this.client = client;
        this.status = status;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
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
