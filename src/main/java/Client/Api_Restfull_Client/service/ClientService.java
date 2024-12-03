package Client.Api_Restfull_Client.service;

import Client.Api_Restfull_Client.dto.ClientDTO;
import Client.Api_Restfull_Client.repository.ClientRepository;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import Client.Api_Restfull_Client.entities.Client;
@Service
public class ClientService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ClientRepository clientRepository;

    @Transactional(readOnly = true)
    public ClientDTO findById(Long id){
        Client client = clientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Client not found with ID: " + id));
        return modelMapper.map(client, ClientDTO.class);
    }
    @Transactional(readOnly = true)
    public Page<ClientDTO> serachPage(Pageable pageable){
        Page<Client> page = clientRepository.findAll(pageable);
        return page.map(x -> modelMapper.map(x,ClientDTO.class));
    }



}
