import java.util.Locale;
import java.util.Scanner;

public class Exercicio009 {
    private static Double temperaturaFahrenheit = null;
    private static Double temperaturaCelsius = null;

    public static void main(String[] args) {
        entrada();
        processamento();
        saida();
    }

    private static void entrada() {
        Scanner teclado = new Scanner(System.in);
        teclado.useLocale(Locale.US);

        do {
            System.out.print("Digite a temperatura em Fahrenheit: ");
            String valorDigitado = teclado.nextLine().replace(",", ".");
            validacoesDeEntrada(valorDigitado);
        } while (temperaturaFahrenheit == null);

        teclado.close();
    }

    private static void validacoesDeEntrada(String valorDigitado) {
        try {
            temperaturaFahrenheit = Double.parseDouble(valorDigitado);
        } catch (Exception e) {
            System.out.println("Erro ao digitar a temperatura, tente novamente!");
        }
    }

    private static void processamento() {
        temperaturaCelsius = (temperaturaFahrenheit - 32) * 5 / 9;
    }

    private static void saida() {
        System.out.println("A temperatura em Celsius é: " + temperaturaCelsius);
    }
}
