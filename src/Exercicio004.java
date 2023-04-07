import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Exercicio004 {
    private static final Integer QUANTIDADE_DE_AVALIACOES = 4;
    private static final ArrayList<Double> notas = new ArrayList<>();
    private static Double soma = null;
    private static Double media = null;

    public static void main(String[] args) {
        entrada();
        processamento();
        saida();
    }

    private static void entrada() {
        Scanner teclado = new Scanner(System.in);
        teclado.useLocale(Locale.US);

        do {
            System.out.printf("Digite a nota %d: ", notas.size() + 1);
            String valorDigitado = teclado.nextLine().replace(",", ".");
            validacoesDeEntrada(valorDigitado);
        } while (notas.size() < QUANTIDADE_DE_AVALIACOES);

        teclado.close();
    }

    private static void validacoesDeEntrada(String valorDigitado) {
        try {
            notas.add(Double.parseDouble(valorDigitado));
        } catch (Exception e) {
            System.out.println("Erro ao digitar nota, tente novamente!");
        }
    }

    private static void processamento() {
        soma = notas.stream().mapToDouble(nota -> nota).sum();
        media = soma / notas.size();
    }

    private static void saida() {
        System.out.printf("Soma das notas: %.2f%n", soma);
        System.out.printf("Média das notas: %.2f", media);
    }
}
