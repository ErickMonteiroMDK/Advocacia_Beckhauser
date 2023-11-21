package com.advocacia.Advocacia_Beckhauser.resources;

import com.advocacia.Advocacia_Beckhauser.models.Anexo;
import com.advocacia.Advocacia_Beckhauser.services.AnexoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.net.URI;

@RestController
@RequestMapping("/api/anexos")
public class AnexoController extends AbstractController {
    @Autowired
    private AnexoService service;



    @GetMapping
    public ResponseEntity trazerTodos() {
        return ResponseEntity.ok(service.trazerTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity trazerPorId(@PathVariable("id") Long id) {
        return ResponseEntity.ok(service.trazerPorId(id));
    }

    @GetMapping("/processo/{id}")
    public ResponseEntity trazerPorProcessoId(@PathVariable("id") Long id) {
        return ResponseEntity.ok(service.trazerPorProcessoId(id));
    }


    @PostMapping
    public ResponseEntity salvar(@RequestParam("arquivo") MultipartFile arquivo, @ModelAttribute Anexo anexo) {
        return ResponseEntity.created(URI.create("/api/anexo/" + anexo.getId())).body(service.salvar(arquivo, anexo));
    }


    @PutMapping("/{id}")
    public ResponseEntity alterar(@PathVariable("id") Long id, @RequestParam(value = "file", required = false) MultipartFile novoArquivo, @RequestBody Anexo alterado) {
        return ResponseEntity.ok().body(service.alterar(id, novoArquivo, alterado));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity remover(@PathVariable("id") Long id) {
        service.remover(id);
        return ResponseEntity.noContent().build();
    }
}