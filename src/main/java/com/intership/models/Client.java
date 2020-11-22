package com.intership.models;

import com.intership.exception.IncorrectInputException;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.util.UUID;

@Entity
public class Client {
    @Id
    private UUID id;


    private String firstName;
    private String lastName;
    private Integer balance;

    public Client() {
    }

    @PrePersist
    public void generateUUID() {
        if (this.id == null) {
            this.id = UUID.randomUUID();
        }
        if (this.balance < 0) {
            throw new IncorrectInputException("Баланс клиента не может быть отрицательным");
        }
    }

    @PreUpdate
    public void correctBalance() {
        if (this.balance < 0) {
            throw new IncorrectInputException("Баланс клиента не может быть отрицательным");
        }
    }

    public Client(String firstName, String lastName, int balance) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.balance = balance;
    }

    public Client(UUID id, String firstName, String lastName, int balance) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.balance = balance;
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}
