import java.util.Locale;
import java.util.Scanner;

public class Exercicio012 {
    private static Double altura = null;
    private static Double pesoIdeal = null;

    public static void main(String[] args) {
        entrada();
        processamento();
        saida();
    }

    private static void entrada() {
        Scanner teclado = new Scanner(System.in);
        teclado.useLocale(Locale.US);

        do {
            System.out.print("Digite sua altura: ");
            String valorDigitado = teclado.nextLine().replace(",", ".");
            validacoesDeEntrada(valorDigitado);
        } while (altura == null);

        teclado.close();
    }

    private static void validacoesDeEntrada(String valorDigitado) {
        try {
            altura = Double.parseDouble(valorDigitado);
        } catch (Exception e) {
            System.out.println("Erro ao digitar altura, tente novamente!");
        }
    }

    private static void processamento() {
        pesoIdeal = (72.7 * altura) - 58;
    }

    private static void saida() {
        System.out.printf("Seu peso ideal é de %.2f", pesoIdeal);
    }
}
