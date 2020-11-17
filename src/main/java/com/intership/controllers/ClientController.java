package com.intership.controllers;

import com.intership.dto.ClientDto;
import com.intership.models.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.intership.services.ClientService;

//import javax.jms.*;
import javax.jms.*;
import java.util.UUID;

@RestController
public class ClientController {
    @Autowired
    private ClientService clientService;
    @Autowired
    private ConnectionFactory connectionFactory;

    @PostMapping(value = "/clients", consumes = "application/json", produces = "application/json")
    public Client save(@RequestBody ClientDto clientDto) {
        Client client = new Client(clientDto.getId(), clientDto.getFirstName(), clientDto.getLastName(), clientDto.getBalance());
        return clientService.save(client);
    }

    //На вход clientId -> MobileRepository.findByClientId(), PenaltyRepository.findByClientId(), InternetRepository.findByClientId() -> Передаёшь в дто

    @GetMapping("/clients/{clientId}")
    public Client getClientById(@PathVariable UUID clientId) throws JMSException {
        final Connection connection = connectionFactory.createConnection();
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        Queue queue = session.createQueue("input");
        //Added as a producer
        javax.jms.MessageProducer producer = session.createProducer(queue);
        // Create and send the message
        TextMessage msg = session.createTextMessage();
        msg.setText("TestMessage");
        producer.send(msg);
        return clientService.getClient(clientId);
    }


    @DeleteMapping("/clients")
    public void deleteAll() {
        clientService.deleteAll();
    }

    @DeleteMapping("/client/{clientId}")
    public void delete(@PathVariable UUID clientId) {
        clientService.delete(clientId);
    }
}
