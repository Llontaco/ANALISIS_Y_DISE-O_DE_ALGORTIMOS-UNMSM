/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ada.semana.pkg2;

/**
 *
 * @author FernandoRomero
 */
public class BuscadorPalabras {
    private static final int[][] DIRECCIONES = {
        {0, 1}, {1, 0}, {1, 1}, {-1, 0}, {0, -1}, {-1, -1}, {1, -1}, {-1, 1}
    };

    public static boolean buscarPalabra(Tablero tablero, Palabra palabra) {
        char[][] matriz = tablero.getMatriz();
        int filas = tablero.getFilas();
        int columnas = tablero.getColumnas();
        String texto = palabra.getTexto();

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                for (int[] dir : DIRECCIONES) {
                    int x = i, y = j;
                    int k;

                    for (k = 0; k < texto.length(); k++) {
                        if (x < 0 || y < 0 || x >= filas || y >= columnas || matriz[x][y] != texto.charAt(k)) {
                            break;
                        }
                        x += dir[0];
                        y += dir[1];
                    }

                    if (k == texto.length()) {
                        palabra.setPosicion(i + 1, j + 1, x - dir[0] + 1, y - dir[1] + 1);
                        return true;
                    }
                }
            }
        }
        return false;
    }
}

