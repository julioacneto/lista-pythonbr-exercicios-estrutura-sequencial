import java.util.Locale;
import java.util.Scanner;

public class Exercicio016 {
    private static final Integer LITROS_POR_LATA = 18;
    private static final Integer METROS_POR_LITRO = 3;
    private static final Double PRECO = 80.00;
    private static Integer metros = null;
    private static Integer quantidadeDeLatas = null;

    public static void main(String[] args) {
        entrada();
        processamento();
        saida();
    }

    private static void entrada() {
        Scanner teclado = new Scanner(System.in);
        teclado.useLocale(Locale.US);

        do {
            System.out.print("Digite o tamanho (em metros quadrados): ");
            String valorDigitado = teclado.nextLine().replace(",", ".");
            validacoesDeEntrada(valorDigitado);
        } while (metros == null || metros <= 0);

        teclado.close();
    }

    private static void validacoesDeEntrada(String valorDigitado) {
        try {
            metros = Integer.parseInt(valorDigitado);
        } catch (Exception e) {
            System.out.println("Erro ao digitar o tamanho, tente novamente!");
        }
    }

    private static void processamento() {
        quantidadeDeLatas = metros / (LITROS_POR_LATA * METROS_POR_LITRO);
        Integer resto = metros - (LITROS_POR_LATA * METROS_POR_LITRO * quantidadeDeLatas);

        if (resto > 0) {
            quantidadeDeLatas += 1;
        }
    }

    private static void saida() {
        System.out.printf("Quantidade de latas: %d%n", quantidadeDeLatas);
        System.out.printf("Preço Total: R$ %.2f", (quantidadeDeLatas * PRECO));
    }
}
