import java.util.Locale;
import java.util.Scanner;

public class Exercicio018 {
    private static Double tamanhoDoArquivo = null;
    private static Double velocidadeDoLink = null;
    private static Double estimativa = null;

    public static void main(String[] args) {
        entrada();
        processamento();
        saida();
    }

    private static void entrada() {
        Scanner teclado = new Scanner(System.in);
        teclado.useLocale(Locale.US);

        do {
            System.out.print("Digite o tamanho do arquivo (em Megabytes): ");
            String valorDigitado = teclado.nextLine().replace(",", ".");
            validacoesDeEntradaTamanhoDoArquivo(valorDigitado);
        } while (tamanhoDoArquivo == null || tamanhoDoArquivo <= 0);

        do {
            System.out.print("Digite a velocidade da internet (Megabits por segundo): ");
            String valorDigitado = teclado.nextLine().replace(",", ".");
            validacoesDeEntradaVelocidadeDaInternet(valorDigitado);
        } while (velocidadeDoLink == null || velocidadeDoLink <= 0);

        teclado.close();
    }

    private static void validacoesDeEntradaTamanhoDoArquivo(String valorDigitado) {
        try {
            tamanhoDoArquivo = Double.parseDouble(valorDigitado);
        } catch (Exception e) {
            System.out.println("Erro ao digitar o tamanho do arquivo, tente novamente!");
        }
    }

    private static void validacoesDeEntradaVelocidadeDaInternet(String valorDigitado) {
        try {
            velocidadeDoLink = Double.parseDouble(valorDigitado);
        } catch (Exception e) {
            System.out.println("Erro ao digitar o tamanho, tente novamente!");
        }
    }

    private static void processamento() {
        estimativa = tamanhoDoArquivo / (velocidadeDoLink / 8) / 60;
    }

    private static void saida() {
        System.out.printf("Estimativa: %.3f minutos", estimativa);
    }
}
