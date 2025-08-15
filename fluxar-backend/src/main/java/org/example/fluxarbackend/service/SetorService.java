package org.example.fluxarbackend.service;

import org.example.fluxarbackend.model.Setor;
import org.example.fluxarbackend.repository.SetorRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class SetorService {
    private SetorRepository setorRepository;

    public SetorService(SetorRepository setorRepository) {
        this.setorRepository = setorRepository;
    }

    public List<Setor> buscarSetor() {
        return setorRepository.findAll();
    }

    public Setor buscarSetorPorId(Long id) {
        return setorRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public Setor salvarSetor(Setor setor) {
        return setorRepository.save(setor);
    }

    public Setor excluirSetor(Long id) {
        Setor setor = buscarSetorPorId(id);
        setorRepository.delete(setor);
        return setor;
    }
}
