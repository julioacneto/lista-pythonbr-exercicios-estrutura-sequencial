import java.util.Locale;
import java.util.Scanner;

public class Exercicio013 {
    private static char sexo = '?';
    private static Double altura = null;
    private static Double peso = null;

    public static void main(String[] args) {
        entrada();
        processamento();
        saida();
    }

    private static void entrada() {
        Scanner teclado = new Scanner(System.in);
        teclado.useLocale(Locale.US);

        do {
            System.out.print("(H)omem ou (M)ulher ? ");
            String valorDigitado = teclado.nextLine();
            validacoesDeEntradaSexo(valorDigitado);
        } while (sexo != 'H' && sexo != 'M');

        do {
            System.out.print("Digite sua altura: ");
            String valorDigitado = teclado.nextLine().replace(",", ".");
            validacoesDeEntradaAltura(valorDigitado);
        } while (altura == null);

        teclado.close();
    }

    private static void validacoesDeEntradaSexo(String valorDigitado) {
        try {
            sexo = valorDigitado.length() != 1 ? '?' : valorDigitado.toUpperCase().charAt(0);
        } catch (Exception e) {
            System.out.println("Erro ao informar sexo, tente novamente!");
        }
    }

    private static void validacoesDeEntradaAltura(String valorDigitado) {
        try {
            altura = Double.parseDouble(valorDigitado);
        } catch (Exception e) {
            System.out.println("Erro ao digitar altura, tente novamente!");
        }
    }

    private static void processamento() throws IllegalArgumentException {
        switch (sexo) {
            case 'H' -> peso = 72.7 * altura - 58;
            case 'M' -> peso = 62.1 * altura - 44.7;
            default -> throw new IllegalArgumentException("Erro de validacao");
        }
    }

    private static void saida() {
        System.out.printf("Seu peso ideal é de %f (%s)", peso, sexo);
    }
}
