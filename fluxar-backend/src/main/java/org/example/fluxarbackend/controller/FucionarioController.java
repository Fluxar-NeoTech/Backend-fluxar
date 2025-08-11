package org.example.fluxarbackend.controller;

import jakarta.validation.Valid;
import org.example.fluxarbackend.model.Funcionario;
import org.example.fluxarbackend.repository.FuncionarioRepository;
import org.example.fluxarbackend.service.FuncionarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public ResponseEntity<String> adicionar_funcionario ( @Valid @RequestBody Funcionario funcionario) {
        Funcionario funcionarioinserido = funcionarioService.salvarFuncionario(funcionario);
        return ResponseEntity.status(HttpStatus.CREATED).body(funcionarioinserido.toString());
    }

    @PostMapping("deletarFuncionario/{id}")
    public ResponseEntity<String> deletar_funcionario ( @Valid @PathVariable Long id) {
        Funcionario funcionarioInserido = funcionarioService.excluirFuncionario(id);
        return ResponseEntity.status(HttpStatus.OK).body(funcionarioInserido.toString());
    }

    @PutMapping("atulizarFuncionario/{id}")
    public ResponseEntity<String> atualizar_funcionario ( @Valid @PathVariable Long id, @Valid @RequestBody Funcionario funcionario) {
        Funcionario funcionarioAtualizado = funcionarioService.atualizarFuncionario(id, funcionario);
        return ResponseEntity.status(HttpStatus.OK).body(funcionarioAtualizado.toString());
    }

    @PostMapping("login/{email}/{senha}")
    public ResponseEntity<String> login (@Valid @PathVariable String email, @Valid @PathVariable String senha) {
        Funcionario funcionario = funcionarioService.loginFuncionario(email, senha);
        return ResponseEntity.status(HttpStatus.OK).body(funcionario.toString());
    }

}
