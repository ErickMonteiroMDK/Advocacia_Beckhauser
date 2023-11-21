package com.advocacia.Advocacia_Beckhauser.resources;

import com.advocacia.Advocacia_Beckhauser.models.Cliente;
import com.advocacia.Advocacia_Beckhauser.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/cliente")
public class ClienteController extends AbstractController {

    @Autowired
    private ClienteService service;

    @PostMapping
    public ResponseEntity salvarCliente(@RequestBody Cliente cliente){
        Cliente salvar = service.salvar(cliente);
        return ResponseEntity.created(URI.create("/api/cliente" + cliente.getId())).body(salvar);
    }

    @GetMapping
    public ResponseEntity buscaTodos(){
        List<Cliente> clientes = service.buscaTodos();
        return ResponseEntity.ok(clientes);
    }

    @GetMapping("/{id}")
    public ResponseEntity buscaPorId(@PathVariable("id") Long id){
        Cliente cliente = service.buscaPorId(id);
        return ResponseEntity.ok(cliente);
    }

    @PutMapping("/{id}")
    public ResponseEntity atualizar(@PathVariable("id") Long id, @RequestBody Cliente atualizado){
        Cliente cliente = service.atualizar(id, atualizado);
        return ResponseEntity.ok().body(cliente);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletarPorId(@PathVariable("id") Long id){
        service.deletarPorId(id);
        return ResponseEntity.noContent().build();
    }
}
