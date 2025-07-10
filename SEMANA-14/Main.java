import java.util.Random;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        int N = 1_000_000; // Cambia N si quieres
        int numHilos = 4;

        int[] numeros = new int[N];
        Random rand = new Random();

        for (int i = 0; i < N; i++) {
            numeros[i] = rand.nextInt(10);
        }

        // Secuencial
        long inicioSecuencial = System.currentTimeMillis();
        long sumaSecuencial = SumaSecuencial.sumar(numeros);
        long finSecuencial = System.currentTimeMillis();

        System.out.println("Suma Secuencial: " + sumaSecuencial);
        System.out.println("Tiempo Secuencial: " + (finSecuencial - inicioSecuencial) + " ms");

        // Paralela
        long inicioParalelo = System.currentTimeMillis();
        long sumaParalela = SumaParalela.sumar(numeros, numHilos);
        long finParalelo = System.currentTimeMillis();

        System.out.println("Suma Paralela: " + sumaParalela);
        System.out.println("Tiempo Paralelo: " + (finParalelo - inicioParalelo) + " ms");
    }
}
