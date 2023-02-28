package by.bsuir.bankSystem.entity.dto.client;


import by.bsuir.bankSystem.entity.domain.Client;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ClientListDto {
    private List<ClientDto> clients;

    public static ClientListDto of(List<Client> clients) {
        return new ClientListDto(clients.stream().map(ClientDto::miniOf).collect(Collectors.toList()));
    }
}
