package com.advocacia.Advocacia_Beckhauser.services;

import com.advocacia.Advocacia_Beckhauser.enterprise.ValidationException;
import com.advocacia.Advocacia_Beckhauser.models.Anexo;
import com.advocacia.Advocacia_Beckhauser.repositories.AnexoRepository;
import com.advocacia.Advocacia_Beckhauser.repositories.ProcessoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class AnexoService {
    @Autowired
    private AnexoRepository repository;

    @Autowired
    private ProcessoRepository processoRepository;

    @Autowired
    private FileStorageService fileStorageService;



    public Anexo salvar(MultipartFile arquivo, Anexo anexo) {
        try {
            anexo.setDados(arquivo.getBytes());
            anexo.setNomeArquivoOriginal(arquivo.getOriginalFilename());
            anexo.setTipoConteudo(arquivo.getContentType());

            if(processoRepository.findById(anexo.getProcesso().getId()) == null) {
                throw new ValidationException("Processo não existente!");
            }

            fileStorageService.store(arquivo);
            return repository.save(anexo);
        } catch (IOException e) {
            throw new ValidationException("Falha ao salvar o arquivo | Ex: " + e.getMessage());
        }
    }


    public List<Anexo> trazerTodos() {
        return repository.findAll();
    }

    public Anexo trazerPorId(Long id) {
        return repository.findById(id).orElse(null);
    }

    public List<Anexo> trazerPorProcessoId(Long id) {
        return repository.findByProcessoId(id);
    }


    public void remover(Long id) {
        repository.deleteById(id);
    }


    public Anexo alterar(Long id, MultipartFile novoArquivo, Anexo alterado) {
        Optional<Anexo> porId = repository.findById(id);

        if (porId.isPresent()) {
            Anexo anexo = porId.get();

            anexo.setNome(alterado.getNome());
            anexo.setTipoConteudo(alterado.getTipoConteudo());
            anexo.setProcesso(alterado.getProcesso());
            anexo.setProcesso(alterado.getProcesso());

            if (novoArquivo != null) {
                try {
                    anexo.setDados(novoArquivo.getBytes());
                    anexo.setNomeArquivoOriginal(novoArquivo.getOriginalFilename());
                    anexo.setTipoConteudo(novoArquivo.getContentType());

                    fileStorageService.store(novoArquivo);
                } catch (IOException e) {
                    throw new ValidationException("Falha ao salvar o novo arquivo | Ex:" + e.getMessage());
                }
            }

            return repository.save(anexo);
        }

        return null;
    }
}