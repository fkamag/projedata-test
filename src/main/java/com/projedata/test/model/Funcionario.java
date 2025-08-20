package com.projedata.test.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class Funcionario extends Pessoa {

  @Column(nullable = false)
  private BigDecimal salario;

  @Column(nullable = false)
  private String funcao;

  public Funcionario() {
    super();
  }

  public Funcionario(String nome, LocalDate dataNascimento, BigDecimal salario,
      String funcao) {
    super(nome, dataNascimento);
    this.salario = salario;
    this.funcao = funcao;
  }

  public BigDecimal getSalario() {
    return salario;
  }

  public void setSalario(BigDecimal salario) {
    this.salario = salario;
  }

  public String getFuncao() {
    return funcao;
  }

  public void setFuncao(String funcao) {
    this.funcao = funcao;
  }
}
