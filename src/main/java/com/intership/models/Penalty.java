package com.intership.models;

import com.intership.exception.IncorrectInputException;

import javax.persistence.*;
import java.util.UUID;
@Entity
public class Penalty {
    @Id
    private UUID id;


    @ManyToOne
    private Client client;
    private Title title;
    private int cost;
    private boolean wasPayed;

    public enum Title {
        Administrative, Car, Labor
    }

    public boolean isWasPayed() {
        return wasPayed;
    }

    public void setWasPayed(boolean wasPayed) {
        this.wasPayed = wasPayed;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Penalty() {
        this.wasPayed = false;
    }
    @PrePersist
    public void generateUUID() {
        if(this.id == null) {
            this.id = UUID.randomUUID();
        }
        if (this.cost <= 0) {
            throw new IncorrectInputException("Стоимость штрафа не может быть отрицательной");
        }
    }
    @PreUpdate
    public void correctCost() {
        if (this.cost < 0) {
            throw new IncorrectInputException("Стоимость штрафа не может быть отрицательным");
        }
    }
    public Penalty(UUID id, Client client, Title title, int cost) {
        this.id = id;
        this.client = client;
        this.title = title;
        this.cost = cost;
    }



    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Title getTitle() {
        return title;
    }

    public void setTitle(Title title) {
        this.title = title;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }
}
