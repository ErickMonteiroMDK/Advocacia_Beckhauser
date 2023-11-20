package com.advocacia.Advocacia_Beckhauser.resources;

import com.advocacia.Advocacia_Beckhauser.models.Documento;
import com.advocacia.Advocacia_Beckhauser.services.DocumentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.net.URI;

@RestController
@RequestMapping("/api/documentos")
public class DocumentoController extends AbstractController {
    @Autowired
    private DocumentoService service;



    @GetMapping
    public ResponseEntity trazerTodos() {
        return ResponseEntity.ok(service.trazerTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity trazerPorId(@PathVariable("id") Long id) {
        return ResponseEntity.ok(service.trazerPorId(id));
    }


    @PostMapping
    public ResponseEntity salvar(@RequestParam("arquivo") MultipartFile arquivo, @ModelAttribute Documento documento) {
        return ResponseEntity.created(URI.create("/api/documento/" + documento.getId())).body(service.salvar(arquivo, documento));
    }


    @PutMapping("/{id}")
    public ResponseEntity alterar(@PathVariable("id") Long id, @RequestParam(value = "file", required = false) MultipartFile novoArquivo, @RequestBody Documento alterado) {
        return ResponseEntity.ok().body(service.alterar(id, novoArquivo, alterado));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity remover(@PathVariable("id") Long id) {
        service.remover(id);
        return ResponseEntity.noContent().build();
    }
}