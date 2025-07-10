public class SumaParalela {

    public static long sumar(int[] numeros, int numHilos) throws InterruptedException {
        WorkerThread[] hilos = new WorkerThread[numHilos];
        int longitud = numeros.length;
        int bloque = longitud / numHilos;

        for (int i = 0; i < numHilos; i++) {
            int inicio = i * bloque;
            int fin = (i == numHilos - 1) ? longitud : inicio + bloque;
            hilos[i] = new WorkerThread(numeros, inicio, fin);
            hilos[i].start();
        }

        long sumaTotal = 0;
        for (WorkerThread hilo : hilos) {
            hilo.join();
            sumaTotal += hilo.getResultado();
        }

        return sumaTotal;
    }
}

