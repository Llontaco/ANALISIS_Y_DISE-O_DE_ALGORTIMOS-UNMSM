/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ada.semana.pkg2;

/**
 *
 * @author Usuario
 */
public class Tablero {
    private char[][] matriz = {
        {'E', 'S', 'T', 'O'},
        {'S', 'T', 'T', 'M'},
        {'E', 'A', 'S', 'A'},
        {'P', 'R', 'N', 'E'}
    };

    public void mostrarTablero() {
        System.out.println("    1 2 3 4");
        for (int i = 0; i < matriz.length; i++) {
            System.out.print((i + 1) + " | ");
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
    }

    public char[][] getMatriz() {
        return matriz;
    }

    public int getFilas() {
        return matriz.length;
    }

    public int getColumnas() {
        return matriz[0].length;
    }
}
