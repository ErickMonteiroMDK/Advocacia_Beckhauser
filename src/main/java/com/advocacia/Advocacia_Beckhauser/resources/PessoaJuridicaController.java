package com.advocacia.Advocacia_Beckhauser.resources;

import com.advocacia.Advocacia_Beckhauser.models.PessoaJuridica;
import com.advocacia.Advocacia_Beckhauser.services.PessoaJuridicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;


@RestController
@RequestMapping("/api/pessoaJuridica")
public class PessoaJuridicaController extends AbstractController{

    @Autowired
    private PessoaJuridicaService service;

    @PostMapping
    public ResponseEntity create(@RequestBody PessoaJuridica entity) {
        PessoaJuridica save = service.salvar(entity);
        return ResponseEntity.created(URI.create("/api/pessoaJuridica/" + entity.getId())).body(save);
    }

    @GetMapping
    public ResponseEntity findAll(){
        List<PessoaJuridica> pessoaJuridica = service.buscaTodos();
        return ResponseEntity.ok(pessoaJuridica);
    }

    @GetMapping ("{id}")
    public ResponseEntity findById(@PathVariable ("id") Long id) {
        PessoaJuridica pessoaJuridica = service.buscaPorId(id);
        return ResponseEntity.ok(pessoaJuridica);}

    @PutMapping("{id}")
    public  ResponseEntity update(@PathVariable("id") Long id, @RequestBody PessoaJuridica entity) {
        PessoaJuridica alterado = service.alterar(id, entity);
        return ResponseEntity.ok().body(alterado);
    }

    @DeleteMapping("{id}")
    public ResponseEntity remove(@PathVariable("id") Long id) {
        service.remover(id);
        return ResponseEntity.noContent().build();
    }


}
