package models;

import java.util.UUID;

public class Contract {
    private UUID clientId;
    private UUID contractId;
    private String status;

    public Contract(UUID clientId, UUID contractId, String status) {
        this.clientId = clientId;
        this.contractId = contractId;
        this.status = status;
    }

    public UUID getClientId() {
        return clientId;
    }

    public void setClientId(UUID clientId) {
        this.clientId = clientId;
    }

    public UUID getContractId() {
        return contractId;
    }

    public void setContractId(UUID contractId) {
        this.contractId = contractId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
