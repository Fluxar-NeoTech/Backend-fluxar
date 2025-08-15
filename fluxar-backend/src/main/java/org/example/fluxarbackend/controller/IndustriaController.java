package org.example.fluxarbackend.controller;

import jakarta.validation.Valid;
import org.example.fluxarbackend.model.Industria;
import org.example.fluxarbackend.service.IndustriaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/industria")
public class IndustriaController {
    private final IndustriaService industriaService;

    public IndustriaController(IndustriaService industriaService) {
        this.industriaService = industriaService;
    }

    @GetMapping("listar")
    public List<Industria> listar() {
        return industriaService.buscarIndustria();
    }

    @GetMapping("listar/{id}")
    public ResponseEntity<String> listar(@PathVariable Long id) {
        Industria industria = industriaService.buscarIndustria(id);
        return ResponseEntity.status(HttpStatus.OK).body(industria.toString());
    }

    @PostMapping("adicionarIndustria")
    public ResponseEntity<String> adicionarIndustria(@Valid @RequestBody Industria industria) {
        Industria industriaInserida = industriaService.salvarIndustria(industria);
        return ResponseEntity.status(HttpStatus.CREATED).body(industriaInserida.toString());
    }

    @DeleteMapping ("deletarIndustria/{id}")
    public ResponseEntity<String> excluirIndustria(@Valid @PathVariable Long id) {
        Industria industriaExcluida = industriaService.excluirIndustria(id);
        return ResponseEntity.status(HttpStatus.OK).body(industriaExcluida.toString());
    }
}


