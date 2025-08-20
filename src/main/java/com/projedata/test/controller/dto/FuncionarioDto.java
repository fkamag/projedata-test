package com.projedata.test.controller.dto;

import com.projedata.test.model.Funcionario;
import java.math.BigDecimal;
import java.time.LocalDate;

public record FuncionarioDto(
    String nome,
    LocalDate data_nascimento,
    BigDecimal salario,
    String funcao
) {

  public static FuncionarioDto fromEntity(Funcionario funcionario) {
    return new FuncionarioDto(
        funcionario.getNome(),
        funcionario.getDataNascimento(),
        funcionario.getSalario(),
        funcionario.getFuncao()
    );
  }

}
