import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Exercicio003 {
    private static final ArrayList<Double> numeros = new ArrayList<>();
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
            System.out.printf("Digite o %s número: ", numeros.isEmpty() ? "primeiro" : "segundo");
            String valorDigitado = teclado.nextLine().replace(",", ".");
            validacoesDeEntrada(valorDigitado);
        } while (numeros.size() < 2);

        teclado.close();
    }

    private static void validacoesDeEntrada(String valorDigitado) {
        try {
            numeros.add(Double.parseDouble(valorDigitado));
        } catch (Exception e) {
            System.out.println("Erro ao digitar número, tente novamente!");
        }
    }

    private static void processamento() {
        resultado = numeros.stream().reduce(0.0, Double::sum);
    }

    private static void saida() {
        System.out.printf("A soma dos dois números é %.3f", resultado);
    }
}
