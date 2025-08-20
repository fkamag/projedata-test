package com.projedata.test.config;

import com.projedata.test.model.Funcionario;
import com.projedata.test.repository.FuncionarioRepository;
import jakarta.annotation.PostConstruct;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer {

  @Autowired
  private FuncionarioRepository funcionarioRepository;

  @PostConstruct
  public void carregarDados() throws IOException {
    try
      (Reader reader = new FileReader("Dados.csv");
      CSVParser parser = new CSVParser(reader, CSVFormat.DEFAULT.withFirstRecordAsHeader())) {

      DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

      for (CSVRecord record : parser) {
        String nome = record.get("Nome");
        LocalDate data_nascimento = LocalDate.parse(record.get("Data Nascimento"), formatter);
        BigDecimal salario = new BigDecimal(record.get("Salário"));
        String funcao = record.get("Função");
        Funcionario funcionario = new Funcionario(nome, data_nascimento, salario, funcao);
        funcionarioRepository.save(funcionario);
      }

      System.out.println("Dados carregados com sucesso!");
    }
    catch (Exception e) {
      e.printStackTrace();
    }
  }

}
