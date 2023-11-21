package com.advocacia.Advocacia_Beckhauser.resources;


import com.advocacia.Advocacia_Beckhauser.models.PessoaJuridica;
import com.advocacia.Advocacia_Beckhauser.models.Processo;
import com.advocacia.Advocacia_Beckhauser.services.ProcessoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("api/processos")
public class ProcessoController {

    @Autowired
    private ProcessoService service;


    @PostMapping
    public ResponseEntity create(@RequestBody Processo entity) {
        Processo save = service.salvar(entity);
        return ResponseEntity.created(URI.create("/api/processos/" + entity.getId())).body(save);
    }

    @GetMapping
    public ResponseEntity findAll() {
        List<Processo> processos = service.buscaTodos();
        return ResponseEntity.ok(processos);
    }

    @GetMapping ("{id}")
    public ResponseEntity findById(@PathVariable ("id") Long id) {
        Processo processo = service.buscaPorId(id);
        return ResponseEntity.ok(processo);}

    @PutMapping("{id}")
    public  ResponseEntity update(@PathVariable("id") Long id, @RequestBody Processo entity) {
        Processo alterado = service.alterar(id, entity);
        return ResponseEntity.ok().body(alterado);
    }

    @DeleteMapping("{id}")
    public ResponseEntity remove(@PathVariable("id") Long id) {
        service.remover(id);
        return ResponseEntity.noContent().build();
    }





}
