package com.algaworks.banco.app;

import com.algaworks.banco.modelo.CaixaEletronico;
import com.algaworks.banco.modelo.Conta;
import com.algaworks.banco.modelo.ContaEspecial;
import com.algaworks.banco.modelo.ContaInvestimento;
import com.algaworks.banco.modelo.Pessoa;

public class Principal {

  public static void main(String[] args) {
    Pessoa titular1 = new Pessoa();
    titular1.setNome("João da Silva");
    titular1.setDocumento("11111111101");

    Pessoa titular2 = new Pessoa();
    titular2.setNome("Maria Souza");
    titular2.setDocumento("22222222202");

    CaixaEletronico caixaEletronico = new CaixaEletronico();

    ContaInvestimento minhaConta = new ContaInvestimento(titular1, 12345, 67890);
    ContaEspecial suaConta = new ContaEspecial(titular2, 23456, 78901, 1_000);

    Conta conta = minhaConta; // Upcasting
//  Conta conta = (Conta) minhaConta; // Upcasting
//  Conta minhaConta = new ContaInvestimento(titular1, 12345, 67890); // Upcasting
//  conta.creditarRendimento(0.8); // não tem mais acesso
    conta.depositar(1_000);

    minhaConta.depositar(15_000);
    minhaConta.sacar(1_000);
    minhaConta.sacar(1_000, 10);
    minhaConta.creditarRendimento(0.8); // não tem acesso no Upcasting Conta minhaConta = new ContaInvestimento(titular1, 12345, 67890);

    suaConta.depositar(15_000);
    suaConta.sacar(15_000);
    suaConta.sacar(500, 1);

    caixaEletronico.imprimirSaldo(minhaConta);
    System.out.println();
    caixaEletronico.imprimirSaldo(suaConta);
  }

}
