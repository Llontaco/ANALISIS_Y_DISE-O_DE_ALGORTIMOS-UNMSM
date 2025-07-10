import java.util.*;

public class AlgoritmoVorazClientes {

    static class Cliente {
        String id;
        int tiempo;

        public Cliente(String id, int tiempo) {
            this.id = id;
            this.tiempo = tiempo;
        }
    }

    public static void main(String[] args) {
        // Datos de entrada
        List<Cliente> clientes = new ArrayList<>();
        clientes.add(new Cliente("C1", 8));
        clientes.add(new Cliente("C2", 4));
        clientes.add(new Cliente("C3", 6));

        // Ordenar clientes por tiempo de atención ascendente (algoritmo voraz)
        clientes.sort(Comparator.comparingInt(c -> c.tiempo));

        System.out.println("Orden óptimo de atención:");
        int tiempoAcumulado = 0;
        int sumaTiempoEspera = 0;
        for (int i = 0; i < clientes.size(); i++) {
            Cliente c = clientes.get(i);
            tiempoAcumulado += c.tiempo;
            sumaTiempoEspera += tiempoAcumulado;
            System.out.print(c.id + (i < clientes.size() - 1 ? " -> " : "\n"));
        }

        double tiempoMedio = (double) sumaTiempoEspera / clientes.size();
        System.out.printf("\nTiempo medio de atención: %.2f\n", tiempoMedio);
    }
}
