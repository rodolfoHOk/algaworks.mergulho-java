package com.algaworks.banco.app;

import com.algaworks.banco.modelo.Pessoa;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CollectionsMain {

  public static void main(String[] args) {
    Pessoa pessoa1 = new Pessoa("João da Silva", "111111111-11");
    Pessoa pessoa2 = new Pessoa("Maria Souza", "222222222-22");

    // Listas
    System.out.println("Listas");

    List<Pessoa> pessoas = new ArrayList<>();
    pessoas.add(pessoa1);
    pessoas.add(pessoa2);

    System.out.println("Lista: " +pessoas);

    Pessoa pessoa3 = pessoas.get(1);
    System.out.println("Pessoa3: " + pessoa3);

    for (int i = 0; i < pessoas.size(); i++) {
      System.out.println("for1: " + pessoas.get(i).getNome());
    }

    for(Pessoa pessoa : pessoas) {
      System.out.println("for2: " + pessoa.getNome());
    }

    boolean existe1 = pessoas.contains(pessoa1);
    System.out.println("Contains1: " + existe1);

    Pessoa pessoa4 = new Pessoa("João da Silva", "111111111-11");
    boolean existe4 = pessoas.contains(pessoa4); // com a sobrescrita do equals da classe Pessoa é true senão false
    System.out.println("Contains4: " + existe4);

    System.out.println("1 == 1: " + (pessoa1 == pessoa1));
    System.out.println("1 == 4: " + (pessoa1 == pessoa4));
    System.out.println("1 equals 4: " + pessoa1.equals(pessoa4)); // com a sobrescrita do equals da classe Pessoa é true senão false

    // Conjuntos
    System.out.println("\nConjuntos");

    Set<Pessoa> conjuntoPessoas = new HashSet<>();
    conjuntoPessoas.add(pessoa1);
    conjuntoPessoas.add(pessoa2);

//    for (int i = 0; i < conjuntoPessoas.size(); i++) {
//      System.out.println("for1: " + conjuntoPessoas.get(i).getNome()); // hashset não tem índice
//    }

    for(Pessoa pessoa : conjuntoPessoas) { // ok
      System.out.println("for3: " + pessoa.getNome());
    }

    boolean existe4emc = conjuntoPessoas.contains(pessoa4);
    System.out.println("Contains4: " + existe4emc); // Retorna false se não sobrescrever o hashCode da classe Pessoa se sim true

  }

}
