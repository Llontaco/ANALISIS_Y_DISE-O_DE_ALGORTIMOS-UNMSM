/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ada.semana.pkg2;

/**
 *
 * @author Usuario
 */
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Tablero tablero = new Tablero();
        Set<String> palabrasDisponibles = new HashSet<>(Arrays.asList("ESTO", "PATO", "ESE", "ESTE"));
        Set<String> palabrasEncontradas = new HashSet<>();

        System.out.println("Bienvenido a la sopa de letras");
        System.out.println("A continuación se muestra el tablero:\n");
        tablero.mostrarTablero();
        System.out.println("\nPuede buscar entre las siguientes palabras: esto, pato, ese, este");

        while (true) {
            if (palabrasEncontradas.size() == palabrasDisponibles.size()) {
                System.out.println("¡Gracias por usar el programa! Encontraste las 4 palabras.");
                break;
            }

            System.out.print("\nIntroduce la palabra que deseas hallar: ");
            String entrada = sc.nextLine().trim().toUpperCase();

            if (!palabrasDisponibles.contains(entrada)) {
                System.out.println("Esa palabra no está en la sopa de letras. Recuerda que las únicas palabras disponibles son: esto, pato, ese, este");
                continue;
            }

            if (palabrasEncontradas.contains(entrada)) {
                System.out.println("Ya encontraste esa palabra anteriormente.");
                continue;
            }

            Palabra palabra = new Palabra(entrada);
            boolean encontrada = BuscadorPalabras.buscarPalabra(tablero, palabra);

            if (encontrada) {
                System.out.println("La palabra " + entrada.toLowerCase() + " " + palabra.getPosicion() + ".");
                palabrasEncontradas.add(entrada);
            } else {
                System.out.println("No se encontró la palabra en el tablero.");
            }

            System.out.print("\n¿Quieres buscar otra palabra? (si/no): ");
            String respuesta = sc.nextLine().trim().toLowerCase();
            if (!respuesta.equals("si")) {
                System.out.println("Gracias por usar el programa.");
                break;
            }
        }
    }
}

