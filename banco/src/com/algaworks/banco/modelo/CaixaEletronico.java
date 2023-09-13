package com.algaworks.banco.modelo;

public class CaixaEletronico {

  public void imprimirSaldo(Conta conta) { // usando Polimorfismo
    System.out.println("Conta: " + conta.getAgencia() + "/" + conta.getNumero());
    System.out.println("Titular: " + conta.getTitular().getNome());
    System.out.println("Saldo: " + conta.getSaldo());
    System.out.println("Saldo disponível: " + conta.getSaldoDisponivel());
  }

}
