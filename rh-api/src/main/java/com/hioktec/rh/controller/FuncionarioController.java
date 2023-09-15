package com.hioktec.rh.controller;

import com.hioktec.rh.model.Funcionario;
import com.hioktec.rh.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {

  private final FuncionarioRepository funcionarioRepository;

  @Autowired
  public FuncionarioController(FuncionarioRepository funcionarioRepository) {
    this.funcionarioRepository = funcionarioRepository;
  }

  @GetMapping
  public List<Funcionario> listar() {
    return funcionarioRepository.findAll();
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public Funcionario cadastrar(@RequestBody Funcionario funcionario) {
    return funcionarioRepository.save(funcionario);
  }

  @GetMapping("/{funcionarioId}")
  public ResponseEntity<Funcionario> obterPorId(@PathVariable Long funcionarioId) {
    return funcionarioRepository.findById(funcionarioId)
      .map(ResponseEntity::ok)
      .orElse(ResponseEntity.notFound().build());
  }

  @PutMapping("/{funcionarioId}")
  public ResponseEntity<Funcionario> atualizar(@PathVariable Long funcionarioId, @RequestBody Funcionario funcionario) {
    if (!funcionarioRepository.existsById(funcionarioId)) {
      return ResponseEntity.notFound().build();
    }

    funcionario.setId(funcionarioId);
    Funcionario funcionarioAtualizado = funcionarioRepository.save(funcionario);

    return ResponseEntity.ok(funcionario);
  }

}
