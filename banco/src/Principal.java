public class Principal {

  public static void main(String[] args) {
    Pessoa titular1 = new Pessoa();
    titular1.nome = "João da Silva";
    titular1.documento = "11111111101";

    Pessoa titular2 = new Pessoa();
    titular2.nome = "Maria Souza";
    titular2.documento = "22222222202";

    Conta minhaConta = new Conta();
    minhaConta.titular = titular1;
    minhaConta.agencia = 12345;
    minhaConta.numero = 67890;
    minhaConta.saldo = 15_000;

    Conta suaConta = new Conta();
    suaConta.titular = titular2;
    suaConta.agencia = 23456;
    suaConta.numero = 78901;
    suaConta.saldo = 30_000;

    System.out.println("Titular: " + minhaConta.titular.nome);
    System.out.println("Saldo: " + minhaConta.saldo);

    System.out.println("Titular: " + suaConta.titular.nome);
    System.out.println("Saldo: " + suaConta.saldo);
  }

}
