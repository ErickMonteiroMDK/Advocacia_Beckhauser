package com.advocacia.Advocacia_Beckhauser.resources;

import com.advocacia.Advocacia_Beckhauser.models.PessoaJuridica;
import com.advocacia.Advocacia_Beckhauser.services.PessoaJuridicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequestMapping("/api/pessoaJuridica")
public class PessoaJuridicaController {

    @Autowired
    private PessoaJuridicaService service;

    @PostMapping
    public ResponseEntity create(@RequestBody PessoaJuridica entity) {
        PessoaJuridica save = service.salvar(entity);
        return ResponseEntity.created(URI.create("/api/pessoaJuridica/" + entity.getId())).body(save);
    }

}
