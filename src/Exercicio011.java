import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Exercicio011 {
    private static final List<Double> elementos = new ArrayList<>();
    private static Integer resultado1 = null;
    private static Double resultado2 = null;
    private static Double resultado3 = null;

    public static void main(String[] args) {
        entrada();
        processamento();
        saida();
    }

    private static void entrada() {
        Scanner teclado = new Scanner(System.in);
        teclado.useLocale(Locale.US);

        do {
            String tipo = elementos.size() < 2 ? "inteiro" : "real";
            System.out.printf("Digite o %d° número (%s): ", elementos.size() + 1, tipo);
            String valorDigitado = teclado.nextLine().replace(",", ".");
            validacoesDeEntrada(valorDigitado);
        } while (elementos.size() < 3);

        teclado.close();
    }

    private static void validacoesDeEntrada(String valorDigitado) {
        try {
            elementos.add(Double.parseDouble(valorDigitado));
        } catch (Exception e) {
            System.out.printf("Erro ao digitar %d° número, tente novamente!%n", elementos.size() + 1);
        }
    }

    private static void processamento() {
        resultado1 = elementos.get(0).intValue() * 2 * (elementos.get(1).intValue() / 2);
        resultado2 = elementos.get(0).intValue() * 3 + elementos.get(2);
        resultado3 = Math.pow(elementos.get(2), 3);
    }

    private static void saida() {
        System.out.printf("O produto do dobro do primeiro número com metade do segundo número é: %d%n", resultado1);
        System.out.printf("A soma do triplo do primeiro número com o terceiro número é: %f%n", resultado2);
        System.out.printf("O terceiro número elevado ao cubo é: %f", resultado3);
    }
}
