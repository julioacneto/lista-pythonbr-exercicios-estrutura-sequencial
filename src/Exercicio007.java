import java.util.Locale;
import java.util.Scanner;

public class Exercicio007 {
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
            System.out.print("Digite a base do quadrado: ");
            String valorDigitado = teclado.nextLine().replace(",", ".");
            validacoesDeEntrada(valorDigitado);
        } while (valor == null);

        teclado.close();
    }

    private static void validacoesDeEntrada(String valorDigitado) {
        try {
            valor = Double.parseDouble(valorDigitado);
        } catch (Exception e) {
            System.out.println("Erro ao digitar valor da base, tente novamente!");
        }
    }

    private static void processamento() {
        area = Math.pow(valor, 2);
    }

    private static void saida() {
        System.out.printf("Área é de %.2f%n", area);
        System.out.printf("Dobro da área é de %.2f", area * 2);
    }
}
