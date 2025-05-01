package com.mycompany.subsequenciamaxima;

import java.util.Random;
import java.util.Scanner;

public class SubsequenciaMaxima {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.print("¿Cuántos números deseas generar? ");
        int cantidad = scanner.nextInt();

        int[] valores = new int[cantidad];

        // Generar números aleatorios entre -20 y 20
        for (int i = 0; i < cantidad; i++) {
            valores[i] = random.nextInt(41) - 20; // [0, 40] - 20 => [-20, 20]
        }

        // Mostrar los valores generados
        System.out.println("Valores generados:");
        for (int valor : valores) {
            System.out.print(valor + " ");
        }
        System.out.println();

        // Algoritmo de Kadane
        int maxSuma = Integer.MIN_VALUE;
        int sumaActual = 0;
        int inicioTemp = 0;
        int inicio = 0;
        int fin = 0;

        for (int i = 0; i < valores.length; i++) {
            sumaActual += valores[i];

            if (sumaActual > maxSuma) {
                maxSuma = sumaActual;
                inicio = inicioTemp;
                fin = i;
            }

            if (sumaActual < 0) {
                sumaActual = 0;
                inicioTemp = i + 1;
            }
        }

        // Resultados
        System.out.println("La suma máxima es: " + maxSuma);
        System.out.println("Desde la posición a" + (inicio + 1) + " hasta a" + (fin + 1));
        System.out.print("Subarreglo: ");
        for (int i = inicio; i <= fin; i++) {
            System.out.print(valores[i] + " ");
        }

        scanner.close();
    }
}
