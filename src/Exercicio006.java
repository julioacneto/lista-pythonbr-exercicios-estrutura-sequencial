import java.util.Locale;
import java.util.Scanner;

public class Exercicio006 {
    private static Double valor = null;
    private static Double area = null;

    public static void main(String[] args) {
        entrada();
        processamento();
        saida();
    }

    private static void entrada() {
        Scanner teclado = new Scanner(System.in);
        teclado.useLocale(Locale.US);

        do {
            System.out.print("Digite o raio da circunferência (em cm): ");
            String valorDigitado = teclado.nextLine().replace(",", ".");
            validacoesDeEntrada(valorDigitado);
        } while (valor == null);

        teclado.close();
    }

    private static void validacoesDeEntrada(String valorDigitado) {
        try {
            valor = Double.parseDouble(valorDigitado);
        } catch (Exception e) {
            System.out.println("Erro ao digitar o raio, tente novamente!");
        }
    }

    private static void processamento() {
        area = Math.pow(valor, 2) * Math.PI;
    }

    private static void saida() {
        System.out.printf("A área dacircunferência é %.2f cm", area);
    }
}
