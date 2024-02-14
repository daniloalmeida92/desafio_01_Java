import java.util.Locale;
import java.util.Scanner;
import java.util.SortedMap;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        double rendaMensal;
        double rendaAnualSalario;
        double rendaPrestacaoServico;
        double rendaAnualGanhoCapital;
        double impostoBrutototal;
        double gastosMedicos = 0;
        double gastosEducacao = 0;
        double impostoSalario;
        double impostoServicos = 0;
        double impostoCapital = 0;
        double maxDedutivel = 0;
        double gastosDedutiveis;
        double impostoDevido;

        System.out.println("***********************CALCULO DE IMPOSTOS***********************");

        System.out.println("Digite sua renda anual: ");
        rendaAnualSalario = sc.nextDouble();
        System.out.println("Digite sua renda com prestação de serviço: ");
        rendaPrestacaoServico = sc.nextDouble();
        System.out.println("Digite sua renda com ganho de capital: ");
        rendaAnualGanhoCapital = sc.nextDouble();
        System.out.println("Digite seus gastos médicos: ");
        gastosMedicos = sc.nextDouble();
        System.out.println("Digite seus Gastos educacionais: ");
        gastosEducacao = sc.nextDouble();

        System.out.println("""
                ***********************RELATÓRIO DE IMPOSTO DE RENDA***********************
                """);

        System.out.println("""
                ***********************CONSOLIDADO DE RENDA***********************     
                """);

        rendaMensal = rendaAnualSalario / 12;
        if (rendaMensal < 3000.0) {
            impostoSalario = 0.00;
            System.out.printf("Imposto sobre salário: %.2f%n" , impostoSalario);
        } else if (rendaMensal > 3000.0 && rendaMensal < 5000.0) {
            impostoSalario = rendaAnualSalario * 0.10;
            System.out.printf("Imposto sobre salário: %.2f%n", impostoSalario);
        } else {
            impostoSalario = rendaAnualSalario * 0.20;
            System.out.printf("Imposto sobre salário: %.2f%n" , impostoSalario);
        }

        if (rendaPrestacaoServico > 0.00) {
            impostoServicos = rendaPrestacaoServico * 0.15;
            System.out.printf("Imposto sobre serviços: %.2f%n" , impostoServicos);
        } else {
            impostoServicos = rendaPrestacaoServico;
            System.out.printf("Imposto sobre serviços: %.2f%n" , impostoServicos);
        }

        if (rendaAnualGanhoCapital > 0.00) {
            impostoCapital = rendaAnualGanhoCapital * 0.20;
            System.out.printf("Imposto sobre ganho de capital: %.2f%n" , impostoCapital);
        } else {
            impostoCapital = rendaAnualGanhoCapital;
            System.out.printf("Imposto sobre serviços: %.2f%n" , impostoServicos);
        }

        impostoBrutototal = impostoSalario + impostoServicos + impostoCapital;

        System.out.println("""
                ***********************DEDUÇÕES***********************    
                """);

        gastosDedutiveis = gastosEducacao + gastosMedicos;

        if (gastosDedutiveis > impostoBrutototal) {
            maxDedutivel = impostoBrutototal * 0.3;
            System.out.printf("Máximo dedutível: %.2f%n" , maxDedutivel);
            System.out.printf("Gastos dedutíveis: %.2f%n" , gastosDedutiveis);
        } else {
            maxDedutivel = impostoBrutototal * 0.3;;
            System.out.printf("Máximo dedutivel: %.2f%n" , maxDedutivel);
            System.out.printf("Gastos dedutiveis: %.2f%n" , gastosDedutiveis);
        }

        System.out.println("""
               ***********************RESUMO***********************     
                """);


        System.out.printf("Imposto bruto total: %.2f%n" , impostoBrutototal);

        if (gastosDedutiveis > impostoSalario){
            impostoDevido = impostoBrutototal - maxDedutivel;
            System.out.printf("Abatimento: %.2f%n" , maxDedutivel);
        } else {
            impostoDevido = impostoBrutototal - gastosDedutiveis;
            System.out.printf("Abatimento: %.2f%n" , gastosDedutiveis);
        }

        System.out.printf("Imposto devido: %.2f%n" , impostoDevido);
    }
}