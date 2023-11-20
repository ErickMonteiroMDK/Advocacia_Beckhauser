package com.advocacia.Advocacia_Beckhauser.services;

import com.advocacia.Advocacia_Beckhauser.enterprise.ValidationException;
import com.advocacia.Advocacia_Beckhauser.models.Modelo;
import com.advocacia.Advocacia_Beckhauser.repositories.ModeloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class ModeloService {
    @Autowired
    private ModeloRepository repository;

    @Autowired
    private FileStorageService fileStorageService;


    public Modelo salvar(MultipartFile arquivo, Modelo modelo) {
        try {
            modelo.setDados(arquivo.getBytes());

            fileStorageService.store(arquivo);
            return repository.save(modelo);
        } catch (IOException e) {
            throw new ValidationException("Falha ao salvar o arquivo");
        }
    }


    public List<Modelo> trazerTodos() {
        return repository.findAll();
    }

    public Modelo trazerPorId(Long id) {
        return repository.findById(id).orElse(null);
    }


    public void remover(Long id) {
        repository.deleteById(id);
    }


    public Modelo alterar(Long id, MultipartFile novoArquivo, Modelo alterado) {
        Optional<Modelo> porId = repository.findById(id);

        if (porId.isPresent()) {
            Modelo modelo = porId.get();

            modelo.setNome(alterado.getNome());
            modelo.setDados(alterado.getDados());

            if (novoArquivo != null) {
                try {
                    modelo.setDados(novoArquivo.getBytes());

                    fileStorageService.store(novoArquivo);
                } catch (IOException e) {
                    throw new ValidationException("Falha ao alterar o arquivo");
                }
            }

            return repository.save(modelo);
        }

        return null;
    }
}
