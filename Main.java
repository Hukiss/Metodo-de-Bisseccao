import  java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double INTERVALO[] = new double[2];
        double extremoInferior, extremoSuperior, precisao;
        double teoriaDeBalzano = 1;

        System.out.print("Dígite o primeiro intervalo: ");
        extremoInferior = scanner.nextDouble();
        INTERVALO[0] = extremoInferior;
        System.out.print("Dígite o segundo intervalo: ");
        extremoSuperior = scanner.nextDouble();
        INTERVALO[1] = extremoSuperior;
        System.out.print("Dígite o valor da precisão: ");
        precisao = scanner.nextDouble();

        for (int i = 0; i < INTERVALO.length; i++)
            teoriaDeBalzano *= funcao (INTERVALO[i]);

        if (teoriaDeBalzano < 0)
            System.out.println("\nExiste pelo menos uma raíz da f(x) que satisfaça a equação.");


        int k = 0;
        double xk = 0;
        System.out.println("--------------------------------------------------------------");
        while (k < k + 1){

            xk = (INTERVALO[0] + INTERVALO[1]) / INTERVALO.length;
            System.out.printf("| k = %d,  a = %.3f  , b = %.3f   , xk = %.3f  , sinal = %s |%n", k, INTERVALO[0], INTERVALO[1], xk, Sinal( funcao(INTERVALO[0]), funcao(xk) ));

            if ( Math.abs(INTERVALO[1] - INTERVALO[0]) <= precisao )
                break;

            if ( funcao(INTERVALO[0]) * funcao(xk) < 0)
                INTERVALO[1] = xk;
            else
                INTERVALO[0] = xk;

            k++;
        }
        System.out.println("--------------------------------------------------------------");
    }

    public static double funcao ( double iteracao){
        double calculo = Math.pow(iteracao, 3) - 3 * iteracao - 5;
        return calculo;
    }

    public static double derivadaFuncao(double iteracao){
        return 0;
    }

    public static String Sinal(double x, double y){
        String sinal = "+";
        if (x * y < 0)
            sinal = "-";

        return sinal;
    }
}
