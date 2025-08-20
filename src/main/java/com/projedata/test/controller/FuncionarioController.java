package com.projedata.test.controller;

import com.projedata.test.controller.dto.FuncionarioDto;
import com.projedata.test.model.Funcionario;
import com.projedata.test.service.FuncionarioService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {

  @Autowired
  private FuncionarioService funcionarioService;

  @GetMapping
  public ResponseEntity<List<FuncionarioDto>> findAll() {
    List<Funcionario> funcionarios = funcionarioService.findAll();
    List<FuncionarioDto> funcionariosDtos = funcionarios.stream()
        .map(FuncionarioDto::fromEntity)
        .toList();
    return ResponseEntity.status(HttpStatus.OK).body(funcionariosDtos);
  }

}
