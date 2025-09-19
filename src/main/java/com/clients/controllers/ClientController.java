package com.clients.controllers;

import com.clients.dto.ClientDTO;
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
    public List<ClientDTO> findAll() {
        return clientService.findAll();
    }

    @GetMapping(value = "/{id}")
    public ClientDTO findById(@PathVariable Long id) {
        return clientService.findById(id);
    }

    @PostMapping
    public ClientDTO insert(@RequestBody ClientDTO clientDTO) {
        return clientService.insert(clientDTO);
    }

    @PutMapping(value = "/{id}")
    public ClientDTO update(@PathVariable Long id, ClientDTO clientDTO) {
        return clientService.update(id, clientDTO);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable Long id) {
       clientService.delete(id);
    }
}
