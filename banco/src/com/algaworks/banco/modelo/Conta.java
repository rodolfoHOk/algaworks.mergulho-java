package com.algaworks.banco.modelo;

import java.util.Objects;

// conta abstrata não permite que seja instânciada
public abstract class Conta {

  private Pessoa titular;
  private int agencia;
  private int numero;
  private double saldo;

  Conta() {
  }

  public Conta(Pessoa titular, int agencia, int numero) {
    Objects.requireNonNull(titular);

    this.titular = titular;
    this.agencia = agencia;
    this.numero = numero;
  }

  public void depositar(double valor) {
    if (valor <= 0) {
      throw new IllegalArgumentException("Valor deve ser maior que 0");
    }
    saldo += valor;
  }

  public void sacar(double valor) {
    if (valor <= 0) {
      throw new IllegalArgumentException("Valor deve ser maior que 0");
    }
    if (getSaldoDisponivel() - valor < 0) {
      throw new IllegalStateException("Saldo insuficiente");
    }
    saldo -= valor;
  }

  public abstract void debitarTarifaMensal();

  public void sacar(double valor, double taxaDeSaque) {
    sacar(valor + taxaDeSaque);
  }

  public Pessoa getTitular() {
    return titular;
  }

  public int getAgencia() {
    return agencia;
  }

  public int getNumero() {
    return numero;
  }

  public double getSaldo() {
    return saldo;
  }

  public double getSaldoDisponivel() {
    return getSaldo();
  }

}
