package com.nimsoc.springsec.services;


import com.nimsoc.springsec.entities.Client;
import com.nimsoc.springsec.repositories.ClientRepository;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClient;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClientRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CustomClientService implements RegisteredClientRepository {

  private final ClientRepository clientRepository;

  public CustomClientService(ClientRepository clientRepository) {
    this.clientRepository = clientRepository;
  }

  @Override
  public void save(RegisteredClient registeredClient) {
    clientRepository.save(Client.from(registeredClient));
  }

  @Override
  public RegisteredClient findById(String id) {
    var client =
        clientRepository.findById(Integer.valueOf(id))
            .orElseThrow();
    return Client.from(client);
  }

  @Override
  public RegisteredClient findByClientId(String clientId) {
    var client =
        clientRepository.findByClientId(clientId)
            .orElseThrow();
    return Client.from(client);
  }
}
