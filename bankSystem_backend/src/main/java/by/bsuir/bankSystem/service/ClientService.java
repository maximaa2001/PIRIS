package by.bsuir.bankSystem.service;

import by.bsuir.bankSystem.entity.dto.client.ClientDto;
import by.bsuir.bankSystem.entity.dto.client.ClientListDto;

public interface ClientService {
    void createClient(ClientDto clientDto);
    ClientListDto getClients();
    ClientDto getClient(Integer id);
    void deleteClient(Integer id);
    void updateClient(ClientDto clientDto);
}
