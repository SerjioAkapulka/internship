package com.intership.dto;

import javax.validation.constraints.NotNull;
import java.util.UUID;

public class ClientDto {

    @NotNull(message = "Идентификатор не должен быть null")
    private UUID id;
    @NotNull(message = "Имя не должен быть null")
    private String firstName;
    @NotNull(message = "Фамилия не должен быть null")
    private String lastName;
    @NotNull(message = "Баланс не должен быть null")
    private Integer balance;


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
