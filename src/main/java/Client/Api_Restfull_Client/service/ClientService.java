package Client.Api_Restfull_Client.service;

import Client.Api_Restfull_Client.dto.ClientDTO;
import Client.Api_Restfull_Client.repository.ClientRepository;
import Client.Api_Restfull_Client.service.mapper.Genericmapper;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import Client.Api_Restfull_Client.entities.Client;
@Service
public class ClientService {

    @Autowired
    Genericmapper genericmapper;

    @Autowired
    private ClientRepository clientRepository;

    @Transactional(readOnly = true)
    public ClientDTO findById(Long id){
        Client client = clientRepository.findById(id).get();
        return genericmapper.entityToDto(client,ClientDTO.class);
    }


}
