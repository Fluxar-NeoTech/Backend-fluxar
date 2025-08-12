package org.example.fluxarbackend.service;

import org.example.fluxarbackend.exception.CargoInexistenteException;
import org.example.fluxarbackend.exception.ErroLoginException;
import org.example.fluxarbackend.model.Funcionario;
import org.example.fluxarbackend.repository.FuncionarioRepository;
import org.example.fluxarbackend.validacion.FuncionarioPathValidacion;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Map;
import java.util.Optional;

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
    public Funcionario atualizarFuncionario(long id, Funcionario funcionario) {
        Funcionario funcionarioExistente = buscarProdutoPorId(id);

        funcionarioExistente.setNome(funcionario.getNome());
        funcionarioExistente.setSobrenome(funcionario.getSobrenome());
        funcionarioExistente.setCargo(funcionario.getCargo());
        funcionarioExistente.setSenha(funcionario.getSenha());
        funcionarioExistente.setSetor_id(funcionario.getSetor_id());
        funcionarioExistente.setUnidade_id(funcionario.getUnidade_id());

        return funcionarioRepository.save(funcionarioExistente);
    }

    public Funcionario loginFuncionario(Map<String, Object> login) {
        FuncionarioPathValidacion validacion = new FuncionarioPathValidacion();
        String senha = login.get("senha").toString();
        String email = login.get("email").toString();
        validacion.verificarSenha(senha);
        return funcionarioRepository.findByEmailAndSenha(email, senha).orElseThrow(ErroLoginException::new);
    }
}
