package Client.Api_Restfull_Client.service;

import Client.Api_Restfull_Client.dto.ClientDTO;
import Client.Api_Restfull_Client.repository.ClientRepository;

import Client.Api_Restfull_Client.service.exceptions.DatabaseException;
import Client.Api_Restfull_Client.service.exceptions.ResourceNotFoundException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.modelmapper.ModelMapper;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Propagation;
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
    public ClientDTO findById(Long id) {
        Client client = clientRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Client not found with ID: " + id));
        return modelMapper.map(client, ClientDTO.class);
    }

    @Transactional(readOnly = true)
    public Page<ClientDTO> serachPage(Pageable pageable) {
        Page<Client> page = clientRepository.findAll(pageable);
        return page.map(x -> modelMapper.map(x, ClientDTO.class));
    }

    @Transactional
    public ClientDTO insert(ClientDTO clientDTO) {
        Client client = modelMapper.map(clientDTO, Client.class);
        client = clientRepository.save(client);
        return modelMapper.map(client, ClientDTO.class);
    }

    @Transactional
    public ClientDTO update(Long id, ClientDTO dto) {
        Client client = clientRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Client not found with ID: " + id));
        modelMapper.map(dto, client);
        Client clientUpdate = clientRepository.save(client);
        return modelMapper.map(clientUpdate, ClientDTO.class);

    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public void delete(Long id) {
        if (!clientRepository.existsById(id)) {
            throw new ResourceNotFoundException("Resource not found");
        }
        try {
            clientRepository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Referential integrity failure");

        }
    }
}