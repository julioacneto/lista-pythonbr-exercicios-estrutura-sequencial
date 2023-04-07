import java.util.Locale;
import java.util.Scanner;

public class Exercicio005 {
    private static Double valor = null;
    private static Double resultado = null;

    public static void main(String[] args) {
        entrada();
        processamento();
        saida();
    }

    private static void entrada() {
        Scanner teclado = new Scanner(System.in);
        teclado.useLocale(Locale.US);

        do {
            System.out.print("Digite a quantidade (em metros): ");
            String valorDigitado = teclado.nextLine().replace(",", ".");
            validacoesDeEntrada(valorDigitado);
        } while (valor == null);

        teclado.close();
    }

    private static void validacoesDeEntrada(String valorDigitado) {
        try {
            valor = Double.parseDouble(valorDigitado);
        } catch (Exception e) {
            System.out.println("Erro ao digitar valores, tente novamente!");
        }
    }

    private static void processamento() {
        resultado = valor * 100;
    }

    private static void saida() {
        System.out.printf("A quantidade em centímetros é %.3f cm", resultado);
    }
}
