package org.example.fluxarbackend.service;

import org.example.fluxarbackend.model.Industria;
import org.example.fluxarbackend.repository.IndustriaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class IndustriaService {
    private IndustriaRepository industriaRepository;

    public IndustriaService(IndustriaRepository industriaRepository) {
        this.industriaRepository = this.industriaRepository;
    }

    public List<Industria> buscarIndustria(){
        return industriaRepository.findAll();
    }

    public Industria buscarIndustria(Long id){
        return industriaRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public Industria salvarIndustria(Industria industria){
        return industriaRepository.save(industria);
    }

    public Industria excluirIndustria(Long id){
        Industria industria = buscarIndustria(id);
        industriaRepository.delete(industria);
        return industria;
    }

    public Industria atualizarIndustria(Long id, Industria industria){
        Industria industriaExistente = buscarIndustria(id);

        industriaExistente.setNome(industria.getNome());
        industriaExistente.setCnpj(industria.getCnpj());
        industriaExistente.setEmail(industria.getEmail());

        return industriaRepository.save(industriaExistente);
    }
}
