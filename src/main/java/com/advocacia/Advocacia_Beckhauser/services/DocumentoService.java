package com.advocacia.Advocacia_Beckhauser.services;

import com.advocacia.Advocacia_Beckhauser.enterprise.ValidationException;
import com.advocacia.Advocacia_Beckhauser.models.Documento;
import com.advocacia.Advocacia_Beckhauser.repositories.DocumentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class DocumentoService {
    @Autowired
    private DocumentoRepository repository;

    @Autowired
    private FileStorageService fileStorageService;



    public Documento salvar(MultipartFile arquivo, Documento documento) {
        try {
            documento.setDados(arquivo.getBytes());
            documento.setNomeArquivoOriginal(arquivo.getOriginalFilename());
            documento.setTipoConteudo(arquivo.getContentType());

            fileStorageService.store(arquivo);
            return repository.save(documento);
        } catch (IOException e) {
            throw new ValidationException("Falha ao salvar o arquivo");
        }
    }


    public List<Documento> trazerTodos() {
        return repository.findAll();
    }

    public Documento trazerPorId(Long id) {
        return repository.findById(id).orElse(null);
    }


    public void remover(Long id) {
        repository.deleteById(id);
    }


    public Documento alterar(Long id, MultipartFile novoArquivo, Documento alterado) {
        Optional<Documento> porId = repository.findById(id);

        if (porId.isPresent()) {
            Documento documento = porId.get();

            documento.setNome(alterado.getNome());
            documento.setTipoConteudo(alterado.getTipoConteudo());

            if (novoArquivo != null) {
                try {
                    documento.setDados(novoArquivo.getBytes());
                    documento.setNomeArquivoOriginal(novoArquivo.getOriginalFilename());
                    documento.setTipoConteudo(novoArquivo.getContentType());

                    fileStorageService.store(novoArquivo);
                } catch (IOException e) {
                    throw new ValidationException("Falha ao salvar o novo arquivo");
                }
            }

            return repository.save(documento);
        }

        return null;
    }
}