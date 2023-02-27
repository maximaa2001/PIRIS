package by.bsuir.bankSystem.rest;

import by.bsuir.bankSystem.entity.dto.client.ClientDto;
import by.bsuir.bankSystem.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static by.bsuir.bankSystem.constant.ApiPath.CREATE_CLIENT;

@RestController
public class ClientRest {
    private final ClientService clientService;

    @Autowired
    public ClientRest(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping(CREATE_CLIENT)
    public void createClient(@RequestBody ClientDto clientDto) {
        clientService.createClient(clientDto);
    }
}
