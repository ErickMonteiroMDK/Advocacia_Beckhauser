package com.advocacia.Advocacia_Beckhauser.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.advocacia.Advocacia_Beckhauser.models.Agenda;
import com.advocacia.Advocacia_Beckhauser.repositories.AgendaRepository;

@Service
public class AgendaService 
{ 
    @Autowired
    private AgendaRepository repository;



    public Agenda salvarAgenda(Agenda agenda) 
    {
        return repository.save(agenda);
    }


    public List<Agenda> trazerTodasAgendas() 
    {
        return repository.findAll();
    }

    public Agenda trazerAgendaPorId(Long id) 
    {
        return repository.findById(id).orElse(null);
    }


    public void removerAgenda(Long id)
    {
        repository.deleteById(id);
    }


    public Agenda alterarAgenda(Long id, Agenda novaAgenda) 
    {
        java.util.Optional<Agenda> porId = repository.findById(id);

        if (porId.isPresent()) 
        {
            Agenda agenda = porId.get();

            agenda.setDataOcorrencia(novaAgenda.getDataOcorrencia());
            agenda.setResponsavel(novaAgenda.getResponsavel());
            agenda.setNumeroProcesso(novaAgenda.getNumeroProcesso());
            agenda.setSituacao(novaAgenda.getSituacao());
            agenda.setFase(novaAgenda.getFase());
            agenda.setLocal(novaAgenda.getLocal());
            agenda.setTipoPrazo(novaAgenda.getTipoPrazo());
            agenda.setDataInicial(novaAgenda.getDataInicial());
            agenda.setPrazo(novaAgenda.getPrazo());
            agenda.setDataFatal(novaAgenda.getDataFatal());

            return repository.save(agenda);
        }
        return null;
    }
}