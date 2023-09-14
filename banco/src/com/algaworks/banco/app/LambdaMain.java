package com.algaworks.banco.app;

import com.algaworks.banco.modelo.Banco;
import com.algaworks.banco.modelo.Conta;

import java.util.Comparator;

public class LambdaMain {

  public static void main(String[] args) {
    Banco banco = new Banco();

    // sem expressão lambda necessário criar a classe NumeroContaFunction
//    banco.getContas().sort(Comparator.comparingInt(new NumeroContaFunction()));

    // com expressão lambda
//    ToIntFunction<Conta> function = (Conta conta) -> {
//      return conta.getNumero();
//    };
//    banco.getContas().sort(Comparator.comparingInt(function));

    // com expressão lambda simplificado
//    banco.getContas().sort(Comparator.comparingInt(conta -> conta.getNumero()));

    // com expressão lambda simplificado com reference method
    banco.getContas().sort(Comparator.comparingInt(Conta::getNumero));

    for (Conta conta: banco.getContas()) {
      System.out.println(conta.getAgencia() + "/" + conta.getNumero());
    }
  }

}
