package com.advocacia.Advocacia_Beckhauser.resources;

import java.net.URI;
import java.time.temporal.ChronoUnit;
import java.util.List;

import com.advocacia.Advocacia_Beckhauser.enterprise.ValidationException;
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
public class AgendaController extends AbstractController
{
    @Autowired
    AgendaService service;



    // ResponseEntity recebe <?> para obter qualquer tipo de retorno(String ou Agenda). Deus nos proteja de qualquer erro com 500 linhas

    /*
    * Autor: Lucas Ronchi
    *
    * Mensagem à Raphael:
    *   Então tá jóia...
    * */



    @PostMapping
    public ResponseEntity salvarAgenda(@RequestBody Agenda agenda)
    {
        if (agenda.getDataInicial().isAfter(agenda.getDataFatal())) 
        {
            throw new ValidationException("data inicial deve ser anterior ou igual a data fatal");
        }

        Long prazo = ChronoUnit.DAYS.between(agenda.getDataInicial(), agenda.getDataFatal());
        agenda.setPrazo(Math.toIntExact(prazo));
        
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

    // ResponseEntity recebe <?> para obter qualquer tipo de retorno(String ou Agenda). Deus nos proteja de qualquer erro com 500 linhas
    @PutMapping("/{id}")
    public ResponseEntity<?> atualizarAgenda(@PathVariable("id") Long id, @RequestBody Agenda entity) 
    {
        if (entity.getDataInicial().isAfter(entity.getDataFatal())) 
        {
            return ResponseEntity.badRequest().body("data inicial deve ser anterior ou igual a data fatal");
        }

        Long prazo = ChronoUnit.DAYS.between(entity.getDataInicial(), entity.getDataFatal());
        entity.setPrazo(Math.toIntExact(prazo));

        return ResponseEntity.ok().body(service.alterarAgenda(id, entity));
    }
    
}
