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
    Integer contador = 0;
    Integer maxTentativas = 6;
    boolean acertou = false;
    Scanner scanner = new Scanner(System.in);

    List<String> palavrasValidas = separandoPalavras();
    String palavraAleatoria = sorteandoPalavra(palavrasValidas);
    char[] arrayDeLetras = preparandoJogo(palavraAleatoria);

    while (contador < maxTentativas) {
      boolean tentativaValida = true;

      System.out.print("\nDigite uma palavra (5 letras): ");
      String tentativa = scanner.next().toLowerCase();
      
      
      if (tentativa.length() != 5) {
        tentativaValida = false;
        System.out.println("A palavra escrita não é válida. Tente novamente.");
        continue; // Reiniciar o loop para obter outra tentativa válida
      }
      
      
      if (tentativa.equals(palavraAleatoria)) {
        acertou = true;
        break;
      }
      
      
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
    ultimasPalavras(acertou, palavraAleatoria);
  }

  public static List<String> separandoPalavras() throws IOException {
    Path path = Paths.get("br-utf8.txt");
    List<String> lista = Files.readAllLines(path);
    List<String> palavrasValidas = new ArrayList<>();
    for (var linha : lista) {
      if (linha.length() == 5) {
        String palavraSemAcento = removerAcentos(linha);
        palavrasValidas.add(palavraSemAcento);
      }
    }
    return palavrasValidas;
  }

  public static String removerAcentos(String texto) {
    String textoNormalizado = Normalizer.normalize(texto, Normalizer.Form.NFD);
    Pattern padrao = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
    return padrao.matcher(textoNormalizado).replaceAll("");
  }

  public static String sorteandoPalavra(List<String> palavrasValidas) {
    Random random = new Random();
    int numeroAleatorio = random.nextInt(palavrasValidas.size());
    String palavraAleatoria = palavrasValidas.get(numeroAleatorio);
    System.out.println(palavraAleatoria);
    return palavraAleatoria;
  }

  public static char[] preparandoJogo(String palavraAleatoria) {
    char[] arrayDeLetras = new char[palavraAleatoria.length()];
    for (int i = 0; i < palavraAleatoria.length(); i++) {
      arrayDeLetras[i] = '_';
    }
    return arrayDeLetras;
  }

  public static void ultimasPalavras(boolean acertou, String palavraAleatoria) {
    if(acertou){
      System.out.println("\nParabéns! Você acertou a palavra: " + palavraAleatoria);
    }else{
      System.out.println("\nBah meu não foi dessa vez. A palavra era: " + palavraAleatoria);
    }
  }
}
