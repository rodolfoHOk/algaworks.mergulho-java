package com.algaworks.banco.app;

import com.algaworks.banco.modelo.Banco;
import com.algaworks.banco.modelo.Conta;

import java.math.BigDecimal;
import java.util.Optional;

public class OptionalMain {

  public static void main(String[] args) {
    Banco banco = new Banco();

    // Sem Optional
    Conta contaEncontradaOld = banco.buscarOld(123, 222);
    if (contaEncontradaOld != null) {
      System.out.println(contaEncontradaOld.getSaldo());
    } else {
      System.out.println("Conta não encontrada");
    }

    Conta contaEncontradaOld2 = banco.buscarOld(123, 333);
    if (contaEncontradaOld2 != null) {
      System.out.println(contaEncontradaOld2.getSaldo());
    } else {
      System.out.println("Conta não encontrada");
    }

    // Com Optional
//    Optional<Conta> contaOptional = banco.buscar(123, 222);
////    if (contaOptional.isPresent()) {
////      Conta contaEncontrada = contaOptional.get();
////      System.out.println(contaEncontrada.getSaldo());
////    } else {
////      System.out.println("Conta não encontrada");
////    }
//    contaOptional.ifPresent(conta -> System.out.println(conta.getSaldo()));

//    banco.buscar(123, 222)
//      .ifPresent(conta -> System.out.println(conta.getSaldo()));

    Conta contaEncontrada = banco.buscar(123, 222)
      .orElseThrow(() -> new RuntimeException("Conta não encontrada"));
    System.out.println("\n" + contaEncontrada.getSaldo());

    try {
      Conta contaEncontrada2 = banco.buscar(123, 333)
        .orElseThrow(() -> new RuntimeException("Conta não encontrada"));
      System.out.println(contaEncontrada2.getSaldo());
    } catch (RuntimeException e) {
      System.out.println(e.getMessage());
    }

    BigDecimal saldo = banco.buscar(123, 222).map(Conta::getSaldo)
      .orElse(BigDecimal.ZERO);
    System.out.println("Saldo: " + saldo);

    BigDecimal saldo2 = banco.buscar(123, 333).map(Conta::getSaldo)
      .orElse(BigDecimal.ZERO);
    System.out.println("Saldo: " + saldo2);

    // Com Stream e Optional
    Optional<Conta> contaStream = banco.buscarStream(123, 222);
    if (contaStream.isPresent()) {
      System.out.println("\n" + contaStream.get().getSaldo());
    } else {
      System.out.println("Conta não encontrada");
    }

    Optional<Conta> contaStream2 = banco.buscarStream(123, 333);
    if (contaStream2.isPresent()) {
      System.out.println(contaStream2.get().getSaldo());
    } else {
      System.out.println("Conta não encontrada");
    }

  }

}
