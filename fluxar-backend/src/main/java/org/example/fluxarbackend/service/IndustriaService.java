package org.example.fluxarbackend.service;

import org.example.fluxarbackend.model.Industria;
import org.example.fluxarbackend.repository.IndustraRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class IndustriaService {
    private IndustraRepository industraRepository;

    public IndustriaService(IndustraRepository industraRepository) {
        this.industraRepository = industraRepository;
    }

    public List<Industria> buscarIndustria(){
        return industraRepository.findAll();
    }

    public Industria buscarIndustria(Long id){
        return industraRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public Industria salvarIndustria(Industria industria){
        return industraRepository.save(industria);
    }

    public Industria excluirIndustria(Long id){
        Industria industria = buscarIndustria(id);
        industraRepository.delete(industria);
        return industria;
    }

    public Industria atualizarIndustria(Long id, Industria industria){
        Industria industriaExistente = buscarIndustria(id);

        industriaExistente.setNome(industria.getNome());
        industriaExistente.setCnpj(industria.getCnpj());
        industriaExistente.setEmail(industria.getEmail());

        return industraRepository.save(industriaExistente);
    }
}
