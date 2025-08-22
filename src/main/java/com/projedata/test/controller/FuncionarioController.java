package com.projedata.test.controller;

import com.projedata.test.controller.dto.FuncionarioDto;
import com.projedata.test.model.Funcionario;
import com.projedata.test.service.FuncionarioService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/funcionarios")
public class FuncionarioController {

  @Autowired
  private FuncionarioService funcionarioService;

  @GetMapping
  public String findAll(Model model) {
    List<Funcionario> funcionarios = funcionarioService.findAll();
    model.addAttribute("funcionarios", funcionarios);
    return "funcionarios";
  }

}
