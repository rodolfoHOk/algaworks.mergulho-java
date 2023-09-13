package com.algaworks.banco.excecao;

public class SaldoInsuficienteException extends RuntimeException {

  public SaldoInsuficienteException(String message) {
    super(message);
  }

}
