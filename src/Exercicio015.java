import java.util.Locale;
import java.util.Scanner;

public class Exercicio015 {
    private static final Double ALIQUOTA_IRPF = 0.11;
    private static final Double ALIQUOTA_INSS = 0.08;
    private static final Double ALIQUOTA_SINDICATO = 0.05;
    private static Double horasTrabalhadas = null;
    private static Double ganhosPorHora = null;
    private static Double salarioBruto = null;
    private static Double irpf = null;
    private static Double inss = null;
    private static Double sindicato = null;
    private static Double salarioLiquido = null;

    public static void main(String[] args) {
        entrada();
        processamento();
        saida();
    }

    private static void entrada() {
        Scanner teclado = new Scanner(System.in);
        teclado.useLocale(Locale.US);

        do {
            System.out.print("Digite a quantidade de horas trabalhadas: ");
            String valorDigitado = teclado.nextLine().replace(",", ".");
            validacoesDeEntradaQuantidadeDeHoras(valorDigitado);
        } while (horasTrabalhadas == null);

        do {
            System.out.print("Digite o valor ganho por hora: ");
            String valorDigitado = teclado.nextLine().replace(",", ".");
            validacoesDeEntradaValorGanhoPorHora(valorDigitado);
        } while (ganhosPorHora == null);

        teclado.close();
    }

    private static void validacoesDeEntradaQuantidadeDeHoras(String valorDigitado) {
        try {
            horasTrabalhadas = Double.parseDouble(valorDigitado);
        } catch (Exception e) {
            System.out.println("Erro ao digitar quantidade de horas, tente novamente!");
        }
    }

    private static void validacoesDeEntradaValorGanhoPorHora(String valorDigitado) {
        try {
            ganhosPorHora = Double.parseDouble(valorDigitado);
        } catch (Exception e) {
            System.out.println("Erro ao digitar valores ganhos por hora, tente novamente!");
        }
    }

    private static void processamento() {
        salarioBruto = horasTrabalhadas * ganhosPorHora;
        irpf = salarioBruto * ALIQUOTA_IRPF;
        inss = salarioBruto * ALIQUOTA_INSS;
        sindicato = salarioBruto * ALIQUOTA_SINDICATO;
        salarioLiquido = salarioBruto - irpf - inss - sindicato;
    }

    private static void saida() {
        System.out.printf("+ %-30s: R$ %10.2f %n", "Salário Bruto", salarioBruto);
        System.out.printf("- %-30s: R$ %10.2f %n", "IR (11%)", irpf);
        System.out.printf("- %-30s: R$ %10.2f %n", "INSS (8%) ", inss);
        System.out.printf("- %-30s: R$ %10.2f %n", "Sindicato ( 5%) ", sindicato);
        System.out.printf("= %-30s: R$ %10.2f", "Salário Liquido ", salarioLiquido);
    }
}
