package com.projedata.test.service;

import com.projedata.test.model.Funcionario;
import com.projedata.test.repository.FuncionarioRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FuncionarioService {

  @Autowired
  private FuncionarioRepository funcionarioRepository;

  public List<Funcionario> findAll() {
    return funcionarioRepository.findAll();
  }

}
