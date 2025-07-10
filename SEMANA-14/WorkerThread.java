public class WorkerThread extends Thread {
    private int[] numeros;
    private int inicio, fin;
    private long resultado;

    public WorkerThread(int[] numeros, int inicio, int fin) {
        this.numeros = numeros;
        this.inicio = inicio;
        this.fin = fin;
    }

    @Override
    public void run() {
        resultado = 0;
        for (int i = inicio; i < fin; i++) {
            resultado += numeros[i];
        }
    }

    public long getResultado() {
        return resultado;
    }
}
