public class Busqueda {

    // Metodo de busqueda secuencial
    public static int busquedaSecuencial(int[] arreglo, int clave) {
        for (int i = 0; i < arreglo.length; i++) {
            if (arreglo[i] == clave) {
                return i;
            }
        }
        return -1;
    }

    // Metodo de busqueda binaria (requiere arreglo ordenado)
    public static int busquedaBinaria(int[] arreglo, int clave) {
        int izquierda = 0, derecha = arreglo.length - 1;
        while (izquierda <= derecha) {
            int medio = (izquierda + derecha) / 2;
            if (arreglo[medio] == clave)
                return medio;
            if (arreglo[medio] < clave)
                izquierda = medio + 1;
            else
                derecha = medio - 1;
        }
        return -1;
    }

    // Nodo del arbol binario
    static class Nodo {
        int valor;
        Nodo izquierdo, derecho;

        Nodo(int valor) {
            this.valor = valor;
            izquierdo = derecho = null;
        }
    }

    // Insertar en arbol binario de busqueda
    public static Nodo insertar(Nodo raiz, int valor) {
        if (raiz == null) return new Nodo(valor);
        if (valor < raiz.valor)
            raiz.izquierdo = insertar(raiz.izquierdo, valor);
        else
            raiz.derecho = insertar(raiz.derecho, valor);
        return raiz;
    }

    // Buscar en arbol binario de busqueda
    public static boolean buscarArbol(Nodo raiz, int clave) {
        if (raiz == null) return false;
        if (raiz.valor == clave) return true;
        if (clave < raiz.valor)
            return buscarArbol(raiz.izquierdo, clave);
        else
            return buscarArbol(raiz.derecho, clave);
    }

    public static void main(String[] args) {
        int[] datos = {50, 42, 25, 85, 35, 48, 96, 77, 44};

        System.out.println("\nBusqueda Secuencial:");
        System.out.println("Buscar 48: Posicion " + busquedaSecuencial(datos, 48));

        java.util.Arrays.sort(datos); // ordenar para busqueda binaria
        System.out.println("\nBusqueda Binaria:");
        System.out.println("Buscar 48: Posicion " + busquedaBinaria(datos, 48));

        System.out.println("\nBusqueda en Arbol Binario:");
        Nodo raiz = null;
        for (int dato : datos) {
            raiz = insertar(raiz, dato);
        }
        System.out.println("Buscar 48: Encontrado? " + buscarArbol(raiz, 48));
    }
}
