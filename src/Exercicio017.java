import java.util.Locale;
import java.util.Scanner;

public class Exercicio017 {
    private static final Double METROS_POR_LITRO = 6.0;
    private static Double metros = null;
    private static Double margemDeErro = null;
    private static Integer quantidadeTotalDeLatas = null;
    private static Double precoTotalDasLatas = null;
    private static Integer quantidadeTotalDeGaloes = null;
    private static Double precoTotalDosGaloes = null;
    private static Integer quantidadeTotalDeGaloesParaOtimizacao = null;
    private static Integer quantidadeTotalDeLatasParaOtimizacao = null;
    private static Double precoTotalOtimizado = null;

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
            metros = Double.parseDouble(valorDigitado);
            margemDeErro = metros * 1.10;
        } catch (Exception e) {
            System.out.println("Erro ao digitar o tamanho, tente novamente!");
        }
    }

    private static void processamento() {
        quantidadeTotalDeLatas = TipoDaLata.LATAS.calcularQuantidadesNecessarias(metros);
        precoTotalDasLatas = TipoDaLata.LATAS.calcularPrecoTotal(quantidadeTotalDeLatas);

        quantidadeTotalDeGaloes = TipoDaLata.GALOES.calcularQuantidadesNecessarias(metros);
        precoTotalDosGaloes = TipoDaLata.GALOES.calcularPrecoTotal(quantidadeTotalDeGaloes);

        quantidadeTotalDeGaloesParaOtimizacao = otimizadorDeGaloes();
        quantidadeTotalDeLatasParaOtimizacao = otimizadorDeLatas();

        transformarGaloesEmLata();

        precoTotalOtimizado = otimizadorPrecoTotal();
    }

    private static void saida() {
        System.out.println("\nTAREFA 1:\n");

        System.out.printf("Quantidade de %s: %d%n", TipoDaLata.LATAS.TIPO_DO_PRODUTO, quantidadeTotalDeLatas);
        System.out.printf("Preço Total: R$ %.2f%n", precoTotalDasLatas);

        System.out.println("\nTAREFA 2:\n");

        System.out.printf("Quantidade de %s: %d%n", TipoDaLata.GALOES.TIPO_DO_PRODUTO, quantidadeTotalDeGaloes);
        System.out.printf("Preço Total: R$ %.2f%n", precoTotalDosGaloes);

        System.out.println("\nTAREFA 3:\n");

        System.out.printf("Metragem com a margem de erro: %.2f%n", margemDeErro);
        System.out.printf("Quantidade de %s: %d%n", TipoDaLata.GALOES.TIPO_DO_PRODUTO, quantidadeTotalDeGaloesParaOtimizacao);
        System.out.printf("Quantidade de %s: %d%n", TipoDaLata.LATAS.TIPO_DO_PRODUTO, quantidadeTotalDeLatasParaOtimizacao);
        System.out.printf("Preço Total: R$ %.2f%n", precoTotalOtimizado);
    }

    public static Integer otimizadorDeGaloes() {
        return TipoDaLata.GALOES.calcularQuantidadesNecessarias(margemDeErro);
    }

    public static Integer otimizadorDeLatas() {
        return quantidadeTotalDeGaloesParaOtimizacao / (int) (TipoDaLata.LATAS.TOTAL_DE_LITROS / TipoDaLata.GALOES.TOTAL_DE_LITROS);
    }

    public static Double otimizadorPrecoTotal() {
        return (quantidadeTotalDeLatasParaOtimizacao * TipoDaLata.LATAS.PRECO_DO_PRODUTO) + (quantidadeTotalDeGaloesParaOtimizacao * TipoDaLata.GALOES.PRECO_DO_PRODUTO);
    }

    public static void transformarGaloesEmLata() {
        quantidadeTotalDeGaloesParaOtimizacao -= (quantidadeTotalDeLatasParaOtimizacao * (int) (TipoDaLata.LATAS.TOTAL_DE_LITROS / TipoDaLata.GALOES.TOTAL_DE_LITROS));
    }

    enum TipoDaLata {
        LATAS("Latas", 80.00, 18.00),
        GALOES("Galoes", 25.00, 3.60);

        private final String TIPO_DO_PRODUTO;
        private final Double PRECO_DO_PRODUTO;
        private final Double TOTAL_DE_LITROS;

        TipoDaLata(final String TIPO_DO_PRODUTO, final Double PRECO_DO_PRODUTO, final Double TOTAL_DE_LITROS) {
            this.TIPO_DO_PRODUTO = TIPO_DO_PRODUTO;
            this.PRECO_DO_PRODUTO = PRECO_DO_PRODUTO;
            this.TOTAL_DE_LITROS = TOTAL_DE_LITROS;
        }

        public Integer calcularQuantidadesNecessarias(Double metros) {
            Double quantidadeNecessria = metros / (TOTAL_DE_LITROS * METROS_POR_LITRO);

            if (quantidadeNecessria - quantidadeNecessria.intValue() > 0) {
                quantidadeNecessria += 1;
            }

            return quantidadeNecessria.intValue();
        }

        public Double calcularPrecoTotal(Integer quantidadeNecessaria) {
            return quantidadeNecessaria * PRECO_DO_PRODUTO;
        }
    }
}
