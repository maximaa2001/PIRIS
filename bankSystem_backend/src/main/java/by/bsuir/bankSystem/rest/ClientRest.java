package by.bsuir.bankSystem.rest;

import by.bsuir.bankSystem.entity.dto.client.ClientDto;
import by.bsuir.bankSystem.entity.dto.client.ClientListDto;
import by.bsuir.bankSystem.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static by.bsuir.bankSystem.constant.ApiPath.CLIENT;
import static by.bsuir.bankSystem.constant.ApiPath.CLIENTS;

@RestController
public class ClientRest {
    private final ClientService clientService;

    @Autowired
    public ClientRest(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping(CLIENT)
    public void createClient(@RequestBody ClientDto clientDto) {
        clientService.createClient(clientDto);
    }

    @GetMapping(CLIENTS)
    public ClientListDto getClients() {
        return clientService.getClients();
    }

    @GetMapping(CLIENT)
    public ClientDto getClient(@RequestParam Integer id) {
        return clientService.getClient(id);
    }

    @DeleteMapping(CLIENT)
    public void deleteClient(@RequestParam Integer id) {
        clientService.deleteClient(id);
    }

    @PutMapping(CLIENT)
    public void updateClient(@RequestBody ClientDto clientDto) {
        clientService.updateClient(clientDto);
    }
}
