package com.advocacia.Advocacia_Beckhauser.resources;

import com.advocacia.Advocacia_Beckhauser.models.Advogado;
import com.advocacia.Advocacia_Beckhauser.services.AdvogadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/advogado")
public class AdvogadoController extends AbstractController {
    @Autowired
    AdvogadoService service;

    @PostMapping
    public ResponseEntity salvarAdvogado(@RequestBody Advogado advogado){
        Advogado salvar = service.salvar(advogado);
        return ResponseEntity.created(URI.create("/api/advogado" + advogado.getId())).body(salvar);
    }

    @GetMapping
    public  ResponseEntity lerAdvogado() {
        List<Advogado> advogados = service.trazerTodos();
        return  ResponseEntity.ok(advogados);
    }

    @GetMapping("/{id}")
    public  ResponseEntity trazerporId(@PathVariable("id") Long id){
        Advogado advogado = service.trazerporId(id);
        return ResponseEntity.ok(advogado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity removerAdvogado(@PathVariable("id")Long id){
        service.removerAdvogado(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity atualizarAdvogado(@PathVariable("id") Long id, @RequestBody Advogado entity) {

        return ResponseEntity.ok().body(service.alterarAdvogado(id, entity));
    }
}