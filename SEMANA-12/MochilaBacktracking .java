import java.util.Scanner;

public class MochilaBacktracking {
    static int n;               // Número de objetos
    static int W;               // Capacidad máxima
    static int[] pesos;         // Pesos de los objetos
    static int[] valores;       // Valores de los objetos

    static int mejorValor = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Datos de ejemplo
        System.out.print("Ingrese número de objetos: ");
        n = sc.nextInt();

        pesos = new int[n];
        valores = new int[n];

        System.out.print("Ingrese capacidad máxima de la mochila: ");
        W = sc.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.print("Peso del objeto " + (i+1) + ": ");
            pesos[i] = sc.nextInt();
            System.out.print("Valor del objeto " + (i+1) + ": ");
            valores[i] = sc.nextInt();
        }

        backtrack(0, 0, 0);

        System.out.println("El valor máximo que se puede obtener es: " + mejorValor);
    }

    static void backtrack(int i, int pesoActual, int valorActual) {
        if (i == n) {
            if (pesoActual <= W && valorActual > mejorValor) {
                mejorValor = valorActual;
            }
            return;
        }

        // Opción 1: Incluir objeto i
        if (pesoActual + pesos[i] <= W) {
            backtrack(i + 1, pesoActual + pesos[i], valorActual + valores[i]);
        }

        // Opción 2: NO incluir objeto i
        backtrack(i + 1, pesoActual, valorActual);
    }
}
