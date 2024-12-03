package Client.Api_Restfull_Client.controller;

import Client.Api_Restfull_Client.dto.ClientDTO;
import Client.Api_Restfull_Client.service.ClientService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/clients")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping(value ="/{id}")
    public ResponseEntity<ClientDTO> getClientById(@PathVariable Long id){
        ClientDTO dto = clientService.findById(id);
        return ResponseEntity.ok(dto);
    }

    @GetMapping
    ResponseEntity<Page<ClientDTO>> findAll(Pageable pageable){
        Page<ClientDTO> page = clientService.serachPage(pageable);
        return ResponseEntity.ok(page);
    }
    @PostMapping
    public ResponseEntity<ClientDTO> insert(@Valid @RequestBody ClientDTO dto){
        dto = clientService.insert(dto);
        URI uri =  ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

}
 