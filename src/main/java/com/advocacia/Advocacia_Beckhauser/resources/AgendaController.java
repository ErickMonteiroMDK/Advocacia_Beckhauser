package com.advocacia.Advocacia_Beckhauser.resources;

import java.net.URI;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.advocacia.Advocacia_Beckhauser.models.Agenda;
import com.advocacia.Advocacia_Beckhauser.services.AgendaService;

@RestController
@RequestMapping("/api/agenda")
public class AgendaController 
{
    @Autowired
    AgendaService service;

    @PostMapping
    public ResponseEntity<Agenda> salvarAgenda(@RequestBody Agenda agenda) 
    {
        Agenda savedAgenda = service.salvarAgenda(agenda);
        return ResponseEntity.created(URI.create("/api/agenda/" + savedAgenda.getId())).body(savedAgenda);
    }

    @GetMapping
    public ResponseEntity<List<Agenda>> lerAgenda() 
    {
        List<Agenda> agendas = service.trazerTodasAgendas();
        return ResponseEntity.ok(agendas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Agenda> trazerporId(@PathVariable("id") Long id) 
    {
        Agenda agenda = service.trazerAgendaPorId(id);
        return ResponseEntity.ok(agenda);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removerAgenda(@PathVariable("id") Long id) 
    {
        service.removerAgenda(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Agenda> atualizarAgenda(@PathVariable("id") Long id, @RequestBody Agenda entity) 
    {
        return ResponseEntity.ok().body(service.alterarAgenda(id, entity));
    }
    
}
