package com.advocacia.Advocacia_Beckhauser.resources;

import com.advocacia.Advocacia_Beckhauser.models.Documento;
import com.advocacia.Advocacia_Beckhauser.models.Modelo;
import com.advocacia.Advocacia_Beckhauser.services.ModeloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/modelos")
public class ModeloController extends AbstractController {
    @Autowired
    private ModeloService service;



    @GetMapping
    public ResponseEntity trazerTodos() {
        List<Modelo> modelos = service.trazerTodos();
        return ResponseEntity.ok(modelos);
    }

    @GetMapping("/{id}")
    public ResponseEntity trazerPorId(@PathVariable("id") Long id) {
        return ResponseEntity.ok(service.trazerPorId(id));
    }


    @PostMapping
    public ResponseEntity salvar(@RequestParam("arquivo") MultipartFile arquivo, @ModelAttribute Modelo modelo) {
        return ResponseEntity.created(URI.create("/api/modelos/" + modelo.getId())).body(service.salvar(arquivo, modelo));
    }


    @PutMapping("/{id}")
    public ResponseEntity alterar(@PathVariable("id") Long id, @RequestParam(value = "file", required = false) MultipartFile novoArquivo, @RequestBody Modelo alterado) {
        return ResponseEntity.ok().body(service.alterar(id, novoArquivo, alterado));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity remover(@PathVariable("id") Long id) {
        service.remover(id);
        return ResponseEntity.noContent().build();
    }
}