package com.hioktec.rh.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

@Entity
public class Funcionario {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(length = 120, nullable = false)
  private String nome;

  @Column(length = 200, nullable = false, unique = true)
  private String email;

  private BigDecimal salario;

  @Column(nullable = false)
  private LocalDate dataAdmissao;

  @Column(length = 15, columnDefinition = "varchar default 'ATIVO'")
  private StatusFuncionario status;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public BigDecimal getSalario() {
    return salario;
  }

  public void setSalario(BigDecimal salario) {
    this.salario = salario;
  }

  public LocalDate getDataAdmissao() {
    return dataAdmissao;
  }

  public void setDataAdmissao(LocalDate dataAdmissao) {
    this.dataAdmissao = dataAdmissao;
  }

  public StatusFuncionario getStatus() {
    return status;
  }

  public void setStatus(StatusFuncionario status) {
    this.status = status;
  }

  @Override
  public String toString() {
    return "Funcionario{" +
      "id=" + id +
      ", nome='" + nome + '\'' +
      ", email='" + email + '\'' +
      ", salario=" + salario +
      ", dataAdmissao=" + dataAdmissao +
      ", status=" + status +
      '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Funcionario that = (Funcionario) o;
    return Objects.equals(id, that.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }

}
