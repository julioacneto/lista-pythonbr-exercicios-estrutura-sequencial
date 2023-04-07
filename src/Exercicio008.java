import java.util.Locale;
import java.util.Scanner;

public class Exercicio008 {
    private static Double ganhoPorHora = null;
    private static Integer horasTrabalhadasMes = null;
    private static Double salario = null;

    public static void main(String[] args) {
        entrada();
        processamento();
        saida();
    }

    private static void entrada() {
        Scanner teclado = new Scanner(System.in);
        teclado.useLocale(Locale.US);

        do {
            System.out.print("Digite valores ganhos por hora : ");
            String valorDigitado = teclado.nextLine().replace(",", ".");
            validacoesDeEntradaGanhoPorHora(valorDigitado);
        } while (ganhoPorHora == null);

        do {
            System.out.print("Digite a quantidade de horas trabalhadas por mês: ");
            String valorDigitado = teclado.nextLine().replace(",", ".");
            validacoesDeEntradaHorasTrabalhadasMes(valorDigitado);
        } while (horasTrabalhadasMes == null);

        teclado.close();
    }

    private static void validacoesDeEntradaGanhoPorHora(String valorDigitado) {
        try {
            ganhoPorHora = Double.parseDouble(valorDigitado);
        } catch (Exception e) {
            System.out.println("Erro ao digitar valores ganhos, tente novamente!");
        }
    }

    private static void validacoesDeEntradaHorasTrabalhadasMes(String valorDigitado) {
        try {
            horasTrabalhadasMes = Integer.parseInt(valorDigitado);
        } catch (Exception e) {
            System.out.println("Erro ao digitar quantidade de horas, tente novamente!");
        }
    }

    private static void processamento() {
        salario = (Math.round(ganhoPorHora * 100.0) / 100.0) * horasTrabalhadasMes;
    }

    private static void saida() {
        System.out.printf("Seu salário é de R$ %.2f", salario);
    }
}
