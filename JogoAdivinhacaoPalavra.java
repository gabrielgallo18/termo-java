// primeira versao

// import java.io.IOException;
// import java.nio.file.Files;
// import java.nio.file.Path;
// import java.nio.file.Paths;
// import java.text.Normalizer;
// import java.util.ArrayList;
// import java.util.List;
// import java.util.Random;
// import java.util.Scanner;
// import java.util.regex.Pattern;

// public class JogoAdivinhacaoPalavra {
//     public static void main(String[] args) throws IOException {
//         Path path = Paths.get("br-utf8.txt");
//         List<String> lista = Files.readAllLines(path);
//         List<String> palavrasValidas = new ArrayList<>();

//         for (var linha : lista) {
//             if (linha.length() == 5) {
//                 String palavraSemAcento = removerAcentos(linha);
//                 palavrasValidas.add(palavraSemAcento);
//             }
//         }

//         Random random = new Random();
//         int numeroAleatorio = random.nextInt(palavrasValidas.size());
//         String palavraAleatoria = palavrasValidas.get(numeroAleatorio);

//         char[] arrayDeLetras = new char[palavraAleatoria.length()];
//         for (int i = 0; i < palavraAleatoria.length(); i++) {
//             arrayDeLetras[i] = '_';
//         }

//         Scanner scanner = new Scanner(System.in);

//         while (true) {
//             // Imprimir o estado atual da palavra
//             for (char letra : arrayDeLetras) {
//                 System.out.print(letra + " ");
//             }
//             System.out.println();

//             // Pedir ao jogador para fazer uma tentativa
//             System.out.print("Digite uma palavra (5 letras): ");
//             String tentativa = scanner.next().toLowerCase();

//             // Verificar o comprimento da tentativa
//             if (tentativa.length() != 5) {
//                 System.out.println("A palavra deve ter exatamente 5 letras. Tente novamente.");
//                 continue; // Reiniciar o loop para obter outra tentativa válida
//             }

//             // Verificar se a tentativa está correta
//             if (tentativa.equals(palavraAleatoria)) {
//                 System.out.println("Parabéns! Você acertou a palavra: " + palavraAleatoria);
//                 break;
//             }

//             // Revelar letras corretas na posição ou apenas corretas
//             for (int i = 0; i < tentativa.length(); i++) {
//                 char letraJogador = tentativa.charAt(i);

//                 // Verificar se a letra está na palavra aleatória
//                 if (palavraAleatoria.indexOf(letraJogador) != -1) {
//                     // Verificar se a letra está na posição correta
//                     if (palavraAleatoria.charAt(i) == letraJogador) {
//                         arrayDeLetras[i] = letraJogador;
//                     } else {
//                         System.out.println("A letra '" + letraJogador + "' está na palavra, mas na posição errada.");
//                     }
//                 }
//             }

//             // Se a tentativa estiver incorreta, informar ao jogador
//             System.out.println("Algumas letras estão corretas. Tente novamente.");
//         }
//     }

//     public static String removerAcentos(String texto) {
//         String textoNormalizado = Normalizer.normalize(texto, Normalizer.Form.NFD);
//         Pattern padrao = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
//         return padrao.matcher(textoNormalizado).replaceAll("");
//     }
// }

// -------------------

// segunda versao 


// import java.io.IOException;
// import java.nio.file.Files;
// import java.nio.file.Path;
// import java.nio.file.Paths;
// import java.text.Normalizer;
// import java.util.ArrayList;
// import java.util.List;
// import java.util.Random;
// import java.util.Scanner;
// import java.util.regex.Pattern;

// public class JogoAdivinhacaoPalavra {
//     public static void main(String[] args) throws IOException {
//         Path path = Paths.get("br-utf8.txt");
//         List<String> lista = Files.readAllLines(path);
//         List<String> palavrasValidas = new ArrayList<>();

//         for (var linha : lista) {
//             if (linha.length() == 5) {
//                 String palavraSemAcento = removerAcentos(linha);
//                 palavrasValidas.add(palavraSemAcento);
//             }
//         }

//         Random random = new Random();
//         int numeroAleatorio = random.nextInt(palavrasValidas.size());
//         String palavraAleatoria = palavrasValidas.get(numeroAleatorio);

//         char[] arrayDeLetras = new char[palavraAleatoria.length()];
//         for (int i = 0; i < palavraAleatoria.length(); i++) {
//             arrayDeLetras[i] = '_';
//         }

//         Scanner scanner = new Scanner(System.in);

//         while (true) {
//             // Imprimir o estado atual da palavra
//             for (char letra : arrayDeLetras) {
//                 System.out.print(letra + " ");
//             }
//             System.out.println();

//             // Pedir ao jogador para fazer uma tentativa
//             System.out.print("Digite uma palavra (5 letras): ");
//             String tentativa = scanner.next().toLowerCase();

//             // Verificar o comprimento da tentativa
//             if (tentativa.length() != 5) {
//                 System.out.println("A palavra deve ter exatamente 5 letras. Tente novamente.");
//                 continue; // Reiniciar o loop para obter outra tentativa válida
//             }

//             // Verificar se a tentativa está correta
//             if (tentativa.equals(palavraAleatoria)) {
//                 System.out.println("Parabéns! Você acertou a palavra: " + palavraAleatoria);
//                 break;
//             }

//             // Atualizar o arrayDeLetras com as letras corretas na posição correta
//             for (int i = 0; i < tentativa.length(); i++) {
//                 char letraJogador = tentativa.charAt(i);

//                 // Verificar se a letra está na palavra aleatória e na posição correta
//                 if (palavraAleatoria.charAt(i) == letraJogador) {
//                     arrayDeLetras[i] = letraJogador;
//                 } else {
//                     System.out.println("A letra '" + letraJogador + "' está na palavra, mas na posição errada.");
//                 }
//             }

//             // Verificar se a palavra foi totalmente adivinhada
//             if (new String(arrayDeLetras).equals(palavraAleatoria)) {
//                 System.out.println("Parabéns! Você acertou a palavra: " + palavraAleatoria);
//                 break;
//             }

//             // Se a tentativa estiver incorreta, informar ao jogador
//             System.out.println("Algumas letras estão corretas. Tente novamente.");
//         }
//     }

//     public static String removerAcentos(String texto) {
//         String textoNormalizado = Normalizer.normalize(texto, Normalizer.Form.NFD);
//         Pattern padrao = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
//         return padrao.matcher(textoNormalizado).replaceAll("");
//     }
// }
// ----------------

// a ultima e a correta

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

        Scanner scanner = new Scanner(System.in);

        while (true) {
            // Imprimir o estado atual da palavra
            for (int i = 0; i < arrayDeLetras.length; i++) {
                char letra = arrayDeLetras[i];
                if (letra != '_') {
                    System.out.print("\u001B[32m" + letra + " \u001B[0m");
                } else {
                    System.out.print("_ ");
                }
            }
            System.out.println();

            // Pedir ao jogador para fazer uma tentativa
            System.out.print("Digite uma palavra (5 letras): ");
            String tentativa = scanner.next().toLowerCase();

            // Verificar o comprimento da tentativa
            if (tentativa.length() != 5) {
                System.out.println("A palavra deve ter exatamente 5 letras. Tente novamente.");
                continue; // Reiniciar o loop para obter outra tentativa válida
            }

            // Verificar se a tentativa está correta
            if (tentativa.equals(palavraAleatoria)) {
                System.out.println("Parabéns! Você acertou a palavra: " + palavraAleatoria);
                break;
            }

            // Atualizar o arrayDeLetras com as letras corretas na posição correta
            for (int i = 0; i < tentativa.length(); i++) {
                char letraJogador = tentativa.charAt(i);

                // Verificar se a letra está na palavra aleatória e na posição correta
                if (palavraAleatoria.charAt(i) == letraJogador) {
                    arrayDeLetras[i] = letraJogador;
                } else if (palavraAleatoria.indexOf(letraJogador) != -1) {
                    System.out.print("\u001B[33m" + letraJogador + " \u001B[0m");
                    System.out.println("A letra '" + letraJogador + "' está na palavra, mas na posição errada.");
                } else {
                    System.out.print(letraJogador + " ");
                }
            }

            // Verificar se a palavra foi totalmente adivinhada
            if (new String(arrayDeLetras).equals(palavraAleatoria)) {
                System.out.println("Parabéns! Você acertou a palavra: " + palavraAleatoria);
                break;
            }

            // Se a tentativa estiver incorreta, informar ao jogador
            System.out.println("Algumas letras estão corretas. Tente novamente.");
        }
    }

    public static String removerAcentos(String texto) {
        String textoNormalizado = Normalizer.normalize(texto, Normalizer.Form.NFD);
        Pattern padrao = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
        return padrao.matcher(textoNormalizado).replaceAll("");
    }
}
