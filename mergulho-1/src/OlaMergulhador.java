public class OlaMergulhador {
  /*
    Comentário de bloco
  */
  public static void main(String[] args) {
    // Comentário de linha
    System.out.println("Olá, mergulhador!");

    String nomeCompleto = "Um nome qualquer";
    nomeCompleto = "Rodolfo HiOk";
    System.out.println("Nome: " + nomeCompleto);

    int minhaIdade = 41;
    int suaIdade = 25;
    int totalIdades = minhaIdade + suaIdade;
    System.out.println("Idade total: " + totalIdades);

    double peso = 84.9;
    System.out.println("Peso: " + peso);

    float taxa = 1_234.56f;
    System.out.println("Taxa: " + taxa);

    boolean compraAprovada = false;
    System.out.println("Compra Aprovada: " + compraAprovada);

    boolean maiorDeIdade = minhaIdade >= 18;
    System.out.println("Maior de idade: " + maiorDeIdade);

    boolean tem41 = minhaIdade == 41;
    System.out.println("Tem 41 anos: " + tem41);

    boolean idadeDiferente42 = minhaIdade != 42;
    System.out.println("Idade diferente que 42 anos: " + idadeDiferente42);
  }

}
