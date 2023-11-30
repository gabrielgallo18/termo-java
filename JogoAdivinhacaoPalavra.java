import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.regex.Pattern;

public class JogoAdivinhacaoPalavra {
  public static void main(String[] args) throws IOException {
    Path path = Paths.get("br-utf8.txt");
    List<String> lista = Files.readAllLines(path);
    List<String> palavrasValidas = new ArrayList<>();
    
    for (var linha : lista) {
      if (linha.length() == 5) {
        String palavraSemAcento = removerAcentos(linha);
        palavrasValidas.add(palavraSemAcento);
      }
    }
    Random random = new Random();
    int numeroAleatorio = random.nextInt(palavrasValidas.size());
    String palavraAleatoria = palavrasValidas.get(numeroAleatorio);
    char[] arrayDeLetras = new char[palavraAleatoria.length()];
    for (int i = 0; i < palavraAleatoria.length(); i++) {
      arrayDeLetras[i] = '_';
    }
    
    Integer contador = 0;
    Integer maxTentativas = 6;
    boolean acertou = false;
    Scanner scanner = new Scanner(System.in);
    while (contador < maxTentativas) {
      boolean tentativaValida = true;
      // Pedir ao jogador para fazer uma tentativa
      System.out.print("\nDigite uma palavra (5 letras): ");
      String tentativa = scanner.next().toLowerCase();
      
      // Verificar o comprimento da tentativa
      if (tentativa.length() != 5) {
        tentativaValida = false;
        System.out.println("A palavra escrita não é válida. Tente novamente.");
        continue; // Reiniciar o loop para obter outra tentativa válida
      }
      
      // Verificar se a tentativa está correta
      if (tentativa.equals(palavraAleatoria)) {
        acertou = true;
        break;
      }
      
      // Imprimir o estado atual da palavra
      for (int i = 0; i < arrayDeLetras.length; i++) {
        char letra = arrayDeLetras[i];
        letra = tentativa.charAt(i);
        if (palavraAleatoria.charAt(i) == letra) {
          System.out.print("\u001B[32m" + letra + " \u001B[0m");
        } else if(palavraAleatoria.indexOf(letra) != -1) {
          System.out.print("\u001B[33m" + letra + " \u001B[0m");
        } else {
          System.out.print(letra+" ");
        }
      }
      if (tentativaValida){
        System.out.print("\n¨ ¨ ¨ ¨ ¨");
        contador++;
      }
    }
    if(acertou){
      System.out.println("\nParabéns! Você acertou a palavra: " + palavraAleatoria);
    }else{
      System.out.println("\nBah meu não foi dessa vez. A palavra era: " + palavraAleatoria);
    }
  }

  public static String removerAcentos(String texto) {
    String textoNormalizado = Normalizer.normalize(texto, Normalizer.Form.NFD);
    Pattern padrao = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
    return padrao.matcher(textoNormalizado).replaceAll("");
  }
}
