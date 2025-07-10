import java.util.ArrayList;
import java.util.List;

public class GrafoBacktracking {
    
    static class Nodo {
        String nombre;
        List<Arco> arcos = new ArrayList<>();
        
        Nodo(String nombre) {
            this.nombre = nombre;
        }
    }
    
    static class Arco {
        Nodo destino;
        int peso;
        
        Arco(Nodo destino, int peso) {
            this.destino = destino;
            this.peso = peso;
        }
    }
    
    static Nodo v0, v1_1, v1_2, v1_3, v2_1, v2_2, v2_3, v3;
    static int minDistancia = Integer.MAX_VALUE;
    static List<String> mejorRuta = new ArrayList<>();
    
    public static void main(String[] args) {
        crearGrafo();
        List<String> rutaActual = new ArrayList<>();
        rutaActual.add(v0.nombre);
        backtrack(v0, 0, rutaActual);
        
        System.out.println("Ruta más corta: " + mejorRuta);
        System.out.println("Distancia mínima: " + minDistancia);
    }
    
    static void crearGrafo() {
        v0 = new Nodo("v0");
        v1_1 = new Nodo("v1.1");
        v1_2 = new Nodo("v1.2");
        v1_3 = new Nodo("v1.3");
        v2_1 = new Nodo("v2.1");
        v2_2 = new Nodo("v2.2");
        v2_3 = new Nodo("v2.3");
        v3 = new Nodo("v3");
        
        v0.arcos.add(new Arco(v1_1, 1));
        v0.arcos.add(new Arco(v1_2, 3));
        v0.arcos.add(new Arco(v1_3, 2));
        
        v1_1.arcos.add(new Arco(v2_1, 5));
        v1_1.arcos.add(new Arco(v2_2, 3));
        
        v1_2.arcos.add(new Arco(v2_1, 2));
        v1_2.arcos.add(new Arco(v2_2, 4));
        
        v1_3.arcos.add(new Arco(v2_2, 2));
        v1_3.arcos.add(new Arco(v2_3, 7));
        
        v2_1.arcos.add(new Arco(v3, 4));
        v2_2.arcos.add(new Arco(v3, 1));
        v2_3.arcos.add(new Arco(v3, 1));
    }
    
    static void backtrack(Nodo actual, int distanciaAcumulada, List<String> rutaActual) {
        if (actual == v3) {
            if (distanciaAcumulada < minDistancia) {
                minDistancia = distanciaAcumulada;
                mejorRuta = new ArrayList<>(rutaActual);
            }
            return;
        }
        
        for (Arco arco : actual.arcos) {
            rutaActual.add(arco.destino.nombre);
            backtrack(arco.destino, distanciaAcumulada + arco.peso, rutaActual);
            rutaActual.remove(rutaActual.size() - 1);
        }
    }
}
