package com.algaworks.banco.app;

import com.algaworks.banco.modelo.Banco;
import com.algaworks.banco.modelo.Conta;
import com.algaworks.banco.modelo.Pessoa;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class StreamAPIMain {

  public static void main(String[] args) {
    Banco banco = new Banco();

    Stream<Conta> stream = banco.getContas().stream();

//    stream.forEach(conta -> {
//      conta.depositar(new BigDecimal("10"));
//      System.out.println(conta.getAgencia() + "/" + conta.getNumero() + " = " + conta.getSaldo());
//    });

    Stream<Conta> stream2 = stream
      .filter(conta -> conta.getSaldo().compareTo(new BigDecimal("130")) > 0);

//    stream2.forEach(conta -> {
//      System.out.println(conta.getAgencia() + "/" + conta.getNumero() + " = " + conta.getSaldo());
//    });

    Stream<Conta> stream3 = stream2.filter(conta -> conta.getNumero() > 300);

    stream3.forEach(conta -> {
      System.out.println(conta.getAgencia() + "/" + conta.getNumero() + " = " + conta.getSaldo());
    });

    // Simplificando
    System.out.println("\nSimplificado");

    banco.getContas().stream()
      .filter(conta -> conta.getSaldo().compareTo(new BigDecimal("50")) > 0)
      .filter(conta -> conta.getNumero() > 200)
      .sorted(Comparator.comparingInt(Conta::getNumero))
      .forEach(conta -> {
        System.out.println(conta.getAgencia() + "/" + conta.getNumero() + " = " + conta.getSaldo());
      });

    System.out.println("\nTitulares de conta");
    banco.getContas().stream()
      .filter(conta -> conta.getSaldo().compareTo(new BigDecimal("50")) > 0)
      .filter(conta -> conta.getNumero() > 200)
      .map(Conta::getTitular)
      .distinct()
      .forEach(System.out::println);

    BigDecimal total = banco.getContas().stream()
      .map(Conta::getSaldo)
      .reduce(BigDecimal.ZERO, BigDecimal::add);
    System.out.println("\nTotal: " + total);


    List<Pessoa> titulares = banco.getContas().stream()
      .map(Conta::getTitular)
      .distinct()
//      .collect(Collectors.toList());
      .toList(); // a partir da versão 16 do java
    System.out.println("\nLista de titulares: " + titulares);

  }

}
