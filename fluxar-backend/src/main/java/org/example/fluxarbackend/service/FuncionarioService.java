package org.example.fluxarbackend.service;

import org.example.fluxarbackend.exception.CargoInexistenteException;
import org.example.fluxarbackend.exception.ErroLoginException;
import org.example.fluxarbackend.model.Funcionario;
import org.example.fluxarbackend.model.Setor;
import org.example.fluxarbackend.repository.FuncionarioRepository;
import org.example.fluxarbackend.repository.SetorRepository;
import org.example.fluxarbackend.validacion.FuncionarioPathValidator;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Map;

@Service
public class FuncionarioService {
    private FuncionarioRepository funcionarioRepository;

    public FuncionarioService(FuncionarioRepository funcionarioRepository) {
        this.funcionarioRepository = funcionarioRepository;
    }

    public List<Funcionario> buscarFuncionario() {
         return funcionarioRepository.findAll();
    }

    public Funcionario buscarProdutoPorId(long id) {
        return funcionarioRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

    }

    public Funcionario salvarFuncionario(Funcionario funcionario) {
        if (funcionario.getCargo().equals("G") || funcionario.getCargo().equals("A")) {
            return funcionarioRepository.save(funcionario);
        }
        throw new CargoInexistenteException();
    }
    public Funcionario excluirFuncionario(long id) {
        Funcionario funcionario = buscarProdutoPorId(id);
        funcionarioRepository.delete(funcionario);
        return funcionario;
    }

    public Funcionario loginFuncionario(Map<String, Object> login) {
        FuncionarioPathValidator validacion = new FuncionarioPathValidator();
        String senha = login.get("senha").toString();
        String email = login.get("email").toString();
        validacion.verificarSenha(senha);
        return funcionarioRepository.findByEmailAndSenha(email, senha).orElseThrow(ErroLoginException::new);
    }
}
