package org.example.fluxarbackend.controller;

import jakarta.validation.Valid;
import org.example.fluxarbackend.model.Funcionario;
import org.example.fluxarbackend.repository.FuncionarioRepository;
import org.example.fluxarbackend.service.FuncionarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/funcionario")
public class FucionarioController {
    private final FuncionarioService funcionarioService;

    public FucionarioController(FuncionarioRepository funcionarioRepository, FuncionarioService funcionarioService) {
        this.funcionarioService = new FuncionarioService(funcionarioRepository);
    }

    @GetMapping("listar")
    public List<Funcionario> listar() {
        return funcionarioService.buscarFuncionario();
    }

    @GetMapping("listar/{id}")
    public ResponseEntity<String> listar(@PathVariable Long id) {
        Funcionario funcionario = funcionarioService.buscarProdutoPorId(id);
        return ResponseEntity.ok(funcionario.toString());
    }

    @PostMapping("adicionarFuncionario")
    public ResponseEntity<String> adicionarFuncionario ( @Valid @RequestBody Funcionario funcionario) {
        Funcionario funcionarioInserido = funcionarioService.salvarFuncionario(funcionario);
        return ResponseEntity.status(HttpStatus.CREATED).body(funcionarioInserido.toString());
    }

    @DeleteMapping("deletarFuncionario/{id}")
    public ResponseEntity<String> deletarFuncionario ( @Valid @PathVariable Long id) {
        Funcionario funcionarioExcluido = funcionarioService.excluirFuncionario(id);
        return ResponseEntity.status(HttpStatus.OK).body(funcionarioExcluido.toString());
    }

    @PutMapping("atulizarFuncionario/{id}")
    public ResponseEntity<String> atualizarFuncionario ( @Valid @PathVariable Long id, @Valid @RequestBody Funcionario funcionario) {
        Funcionario funcionarioAtualizado = funcionarioService.atualizarFuncionario(id, funcionario);
        return ResponseEntity.status(HttpStatus.OK).body(funcionarioAtualizado.toString());
    }

    @PostMapping("login")
    public ResponseEntity<String> login ( @RequestBody Map<String, Object> login) {
        Funcionario loginFuncionario = funcionarioService.loginFuncionario(login);
        return ResponseEntity.status(HttpStatus.OK).body(loginFuncionario.toString());
    }

}
