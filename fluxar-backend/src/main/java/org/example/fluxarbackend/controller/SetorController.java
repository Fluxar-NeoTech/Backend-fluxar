package org.example.fluxarbackend.controller;

import jakarta.validation.Valid;
import org.example.fluxarbackend.model.Setor;
import org.example.fluxarbackend.service.SetorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/setor")
public class SetorController {
    private final SetorService setorService;

    public SetorController(SetorService setorService) {
        this.setorService = setorService;
    }

    @GetMapping("listar")
    public List<Setor> listar(){
        return setorService.buscarSetor();
    }

    @GetMapping("listar/{id}")
    public Setor listarId(@PathVariable Long id){
        return setorService.buscarSetorPorId(id);
    }

    @PostMapping("adicionarSetor")
    public ResponseEntity<String> adicionarSetor(@Valid @RequestBody Setor setor){
        Setor setorInserido = setorService.salvarSetor(setor);
        return ResponseEntity.status(HttpStatus.CREATED).body(setorInserido.toString());
    }

    @DeleteMapping("deletarSetor/{id}")
    public ResponseEntity<String> deletarSetor(@Valid @PathVariable Long id){
        Setor setorExcluido = setorService.excluirSetor(id);
        return ResponseEntity.status(HttpStatus.OK).body(setorExcluido.toString());
    }

    @PutMapping("atualizarSetor/{id}")
    public ResponseEntity<String> atualizarSetor(@PathVariable Long id, @Valid @RequestBody Setor setor){
        Setor setorAtualizado = setorService.atualizarSetor(id, setor);
        return ResponseEntity.status(HttpStatus.OK).body(setorAtualizado.toString());
    }
}
