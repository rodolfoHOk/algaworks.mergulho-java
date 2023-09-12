package com.algaworks.banco.app;

import com.algaworks.banco.modelo.Conta;
import com.algaworks.banco.modelo.Pessoa;

public class Principal {

  public static void main(String[] args) {
    Pessoa titular1 = new Pessoa();
    titular1.setNome("João da Silva");
    titular1.setDocumento("11111111101");

    Pessoa titular2 = new Pessoa();
    titular2.setNome("Maria Souza");
    titular2.setNome("22222222202");

    Conta minhaConta = new Conta(titular1, 12345, 67890);
//    minhaConta.titular = titular1;
//    minhaConta.agencia = 12345;
//    minhaConta.numero = 67890;
//    minhaConta.saldo = 15_000;

//    com.algaworks.banco.modelo.Conta suaConta = new com.algaworks.banco.modelo.Conta(null, 23456, 78901);
    Conta suaConta = new Conta(titular2, 23456, 78901);
//    suaConta.setTitular(titular2);
//    suaConta.setAgencia(23456);
//    suaConta.setNumero(78901);
//    suaConta.saldo = 30_000;

    minhaConta.depositar(15_000);
    suaConta.depositar(30_000);

//    minhaConta.sacar(20_000);
    minhaConta.sacar(1_000);
    suaConta.sacar(2_000);

    minhaConta.sacar(1_000, 10);
    suaConta.sacar(2_000, 20);

//    minhaConta.saldo = minhaConta.saldo - 40_000;
//    minhaConta.setSaldo(minhaConta.getSaldo() - 40_000);

    System.out.println("Titular: " + minhaConta.getTitular().getNome());
    System.out.println("Saldo: " + minhaConta.getSaldo());

    System.out.println("Titular: " + suaConta.getTitular().getNome());
    System.out.println("Saldo: " + suaConta.getSaldo());
  }

}
