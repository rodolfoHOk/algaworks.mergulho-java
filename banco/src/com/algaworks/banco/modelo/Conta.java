package com.algaworks.banco.modelo;

import java.util.Objects;

public class Conta {

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
    if (saldo - valor < 0) {
      throw new IllegalStateException("Saldo insuficiente");
    }
    saldo -= valor;
  }

  public void sacar(double valor, double taxaDeSaque) {
    sacar(valor + taxaDeSaque);
  }

  public Pessoa getTitular() {
    return titular;
  }

//  public void setTitular(com.algaworks.banco.modelo.Pessoa titular) {
//    this.titular = titular;
//  }

  public int getAgencia() {
    return agencia;
  }

//  public void setAgencia(int agencia) {
//    this.agencia = agencia;
//  }

  public int getNumero() {
    return numero;
  }

//  public void setNumero(int numero) {
//    this.numero = numero;
//  }

  public double getSaldo() {
    return saldo;
  }

}
