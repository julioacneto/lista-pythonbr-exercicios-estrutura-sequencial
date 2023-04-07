import java.util.Locale;
import java.util.Scanner;

public class Exercicio014 {
    private static final Double PESO_LIMITE = 50.0;
    private static final Double VALOR_DA_MULTA_POR_EXCESSO = 4.00;
    private static Double pesagem = null;
    private static Double excesso = null;
    private static Double multa = null;

    public static void main(String[] args) {
        entrada();
        processamento();
        saida();
    }

    private static void entrada() {
        Scanner teclado = new Scanner(System.in);
        teclado.useLocale(Locale.US);

        do {
            System.out.print("Digite a quantidade de peixes (kg): ");
            String valorDigitado = teclado.nextLine().replace(",", ".");
            validacoesDeEntrada(valorDigitado);
        } while (pesagem == null);

        teclado.close();
    }

    private static void validacoesDeEntrada(String valorDigitado) {
        try {
            pesagem = Double.parseDouble(valorDigitado);
        } catch (Exception e) {
            System.out.println("Erro ao digitar quantidade de kilos, tente novamente!");
        }
    }

    private static void processamento() {
        excesso = pesagem <= PESO_LIMITE ? 0 : pesagem - PESO_LIMITE;
        multa = excesso <= 0 ? 0.00 : excesso * VALOR_DA_MULTA_POR_EXCESSO;
    }

    private static void saida() {
        if (excesso <= 0) {
            System.out.println("Sem excesso de pesagem e sem multas :)");
        } else {
            System.out.printf("Foram excedidos %.3f kgs%n", excesso);
            System.out.printf("Você terá que pagar R$ %.2f referente a multa por excesso", multa);
        }
    }
}
