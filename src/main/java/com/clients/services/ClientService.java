package com.clients.services;

import com.clients.entities.Client;
import com.clients.repositories.ClientRepository;
import org.apache.juli.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;

    public List<Client> findAll() {
        return clientRepository.findAll();
    }

    public Client findById(Long id) {
        return clientRepository.findById(id).get();
    }

    public Client insert(Client client) {
        client = clientRepository.save(client);
        return client;
    }

    @Transactional
    public Client update(Long id, Client client) {
        Client client1 = clientRepository.getReferenceById(id);
        client1.setName(client.getName());
        client1.setCpf(client.getCpf());
        client1.setIncome(client.getIncome());
        client1.setBirthDate(client.getBirthDate());
        client1.setChildren(client.getChildren());
        return clientRepository.save(client1);
    }

    @Transactional
    public void delete(Long id) {
        clientRepository.deleteById(id);
    }

}
