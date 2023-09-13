package com.algaworks.banco.app;

import com.algaworks.banco.excecao.SaldoInsuficienteException;
import com.algaworks.banco.modelo.TipoPessoa;
import com.algaworks.banco.modelo.atm.CaixaEletronico;
import com.algaworks.banco.modelo.ContaEspecial;
import com.algaworks.banco.modelo.ContaInvestimento;
import com.algaworks.banco.modelo.Pessoa;
import com.algaworks.banco.modelo.pagamento.Boleto;
import com.algaworks.banco.modelo.pagamento.Holerite;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Principal {

  public static void main(String[] args) {
    Pessoa titular1 = new Pessoa();
    titular1.setNome("João da Silva");
    titular1.setDocumento("11111111101");

//  titular1.setRendimentoAnual(Double.valueOf(15_000)); // Boxing
    titular1.setRendimentoAnual(new BigDecimal("15000")); // Auto boxing
    BigDecimal rendimento = titular1.getRendimentoAnual(); // Auto unboxing
    System.out.println("Rendimento titular 1: " + rendimento);

    titular1.setTipo(TipoPessoa.JURIDICA);
    System.out.println(titular1.getTipo());

    titular1.setDataUltimaAtualizacao(LocalDateTime.parse("2023-09-12T13:20:00"));
    System.out.println(titular1.getDataUltimaAtualizacao());

    Pessoa titular2 = new Pessoa();
    titular2.setNome("Maria Souza");
    titular2.setDocumento("22222222202");

    CaixaEletronico caixaEletronico = new CaixaEletronico();

    ContaInvestimento minhaConta = new ContaInvestimento(titular1, 12345, 67890);
    ContaEspecial suaConta = new ContaEspecial(titular2, 23456, 78901, new BigDecimal("1000"));

    try {
      minhaConta.depositar(new BigDecimal("30000"));
      minhaConta.sacar(new BigDecimal("1000"));
      minhaConta.sacar(new BigDecimal("1000"), new BigDecimal("10"));
      minhaConta.creditarRendimento(new BigDecimal("0.8"));
      minhaConta.debitarTarifaMensal();

      suaConta.depositar(new BigDecimal("15000"));
      suaConta.sacar(new BigDecimal("15000"));
      suaConta.sacar(new BigDecimal("500"), new BigDecimal("1"));
      suaConta.debitarTarifaMensal();

      Boleto boletoEscola = new Boleto(titular2, new BigDecimal("800"));
      Holerite salarioFuncionario = new Holerite(titular2, new BigDecimal("100"), 160);
      caixaEletronico.pagar(boletoEscola, minhaConta);
      caixaEletronico.pagar(salarioFuncionario, minhaConta);
      caixaEletronico.estornarPagamento(boletoEscola, minhaConta);

      Boleto boletoCompra = new Boleto(titular2, new BigDecimal("20000"));
      caixaEletronico.pagar(boletoCompra, minhaConta);

      boletoEscola.imprimirRecibo();
      System.out.println();
      salarioFuncionario.imprimirRecibo();
      System.out.println();
    } catch (SaldoInsuficienteException e) {
      System.out.println("Erro ao executar operação na conta: " + e.getMessage());
      System.out.println();
    }

    caixaEletronico.imprimirSaldo(minhaConta);
    System.out.println();
    caixaEletronico.imprimirSaldo(suaConta);
  }

}
