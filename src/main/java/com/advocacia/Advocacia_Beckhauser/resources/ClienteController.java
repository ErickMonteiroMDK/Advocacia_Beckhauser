package com.advocacia.Advocacia_Beckhauser.resources;

import com.advocacia.Advocacia_Beckhauser.models.Cliente;
import com.advocacia.Advocacia_Beckhauser.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private ClienteService service;

    @PostMapping
    public ResponseEntity salvarCliente(@RequestBody Cliente cliente){
        Cliente salvar = service.salvar(cliente);
        return ResponseEntity.created(URI.create("/cliente" + cliente.getId())).body(salvar);
    }


    @GetMapping("/cliente/{id}")
    public ResponseEntity 
}
