package com.clients.controllers;

import com.clients.entities.Client;
import com.clients.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.CollationKey;
import java.util.List;

@RestController
@RequestMapping(value = "/clients")
public class ClientController {
    @Autowired
    private ClientService clientService;

    @GetMapping
    public List<Client> findAll() {
        return clientService.findAll();
    }

    @GetMapping(value = "/{id}")
    public Client findById(@PathVariable Long id) {
        return clientService.findById(id);
    }

    @PostMapping
    public Client insert(@RequestBody Client client) {
        return clientService.insert(client);
    }

    @PutMapping(value = "/{id}")
    public Client update(@PathVariable Long id, Client client) {
        return clientService.update(id, client);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable Long id) {
       clientService.delete(id);
    }
}
