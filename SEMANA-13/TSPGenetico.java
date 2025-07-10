import java.util.*;

public class TSPGenetico {
    static int NUM_CIUDADES = 5;
    static int TAM_POBLACION = 10;
    static int NUM_GENERACIONES = 1000;
    static double TASA_MUTACION = 0.1;

    static double[][] distancias;

    static class Individuo {
        List<Integer> ruta;
        double distancia;

        Individuo(List<Integer> ruta) {
            this.ruta = new ArrayList<>(ruta);
            this.distancia = calcularDistancia(this.ruta);
        }
    }

    public static void main(String[] args) {
        inicializarDistancias();
        List<Individuo> poblacion = generarPoblacionInicial();

        for (int gen = 0; gen < NUM_GENERACIONES; gen++) {
            List<Individuo> nuevaPoblacion = new ArrayList<>();

            for (int i = 0; i < TAM_POBLACION; i++) {
                Individuo padre1 = seleccion(poblacion);
                Individuo padre2 = seleccion(poblacion);
                Individuo hijo = cruzar(padre1, padre2);
                mutar(hijo);
                hijo.distancia = calcularDistancia(hijo.ruta);
                nuevaPoblacion.add(hijo);
            }

            poblacion = nuevaPoblacion;
        }

        Individuo mejor = poblacion.stream().min(Comparator.comparingDouble(i -> i.distancia)).get();
        System.out.println("Mejor ruta encontrada: " + mejor.ruta);
        System.out.println("Distancia: " + mejor.distancia);
    }

    static void inicializarDistancias() {
        distancias = new double[][] {
            {0, 2, 9, 10, 7},
            {2, 0, 6, 4, 3},
            {9, 6, 0, 8, 5},
            {10, 4, 8, 0, 6},
            {7, 3, 5, 6, 0}
        };
    }

    static List<Individuo> generarPoblacionInicial() {
        List<Individuo> poblacion = new ArrayList<>();
        List<Integer> ciudades = new ArrayList<>();
        for (int i = 0; i < NUM_CIUDADES; i++) ciudades.add(i);

        for (int i = 0; i < TAM_POBLACION; i++) {
            Collections.shuffle(ciudades);
            poblacion.add(new Individuo(ciudades));
        }
        return poblacion;
    }

    static double calcularDistancia(List<Integer> ruta) {
        double total = 0;
        for (int i = 0; i < ruta.size() - 1; i++) {
            total += distancias[ruta.get(i)][ruta.get(i+1)];
        }
        total += distancias[ruta.get(ruta.size() - 1)][ruta.get(0)];
        return total;
    }

    static Individuo seleccion(List<Individuo> poblacion) {
        // Torneo simple
        Individuo i1 = poblacion.get(new Random().nextInt(TAM_POBLACION));
        Individuo i2 = poblacion.get(new Random().nextInt(TAM_POBLACION));
        return i1.distancia < i2.distancia ? i1 : i2;
    }

    static Individuo cruzar(Individuo p1, Individuo p2) {
        Random rand = new Random();
        int punto1 = rand.nextInt(NUM_CIUDADES);
        int punto2 = rand.nextInt(NUM_CIUDADES - punto1) + punto1;

        List<Integer> hijoRuta = new ArrayList<>(Collections.nCopies(NUM_CIUDADES, -1));

        for (int i = punto1; i <= punto2; i++) {
            hijoRuta.set(i, p1.ruta.get(i));
        }

        int curIdx = (punto2 + 1) % NUM_CIUDADES;
        for (int ciudad : p2.ruta) {
            if (!hijoRuta.contains(ciudad)) {
                hijoRuta.set(curIdx, ciudad);
                curIdx = (curIdx + 1) % NUM_CIUDADES;
            }
        }
        return new Individuo(hijoRuta);
    }

    static void mutar(Individuo individuo) {
        Random rand = new Random();
        if (rand.nextDouble() < TASA_MUTACION) {
            int idx1 = rand.nextInt(NUM_CIUDADES);
            int idx2 = rand.nextInt(NUM_CIUDADES);
            Collections.swap(individuo.ruta, idx1, idx2);
        }
    }
}
