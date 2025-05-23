/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ada.semana.pkg2;

/**
 *
 * @author FernandoRomero
 */
public class Palabra {
    private String texto;
    private int filaInicio, columnaInicio;
    private int filaFin, columnaFin;

    public Palabra(String texto) {
        this.texto = texto.toUpperCase();
    }

    public String getTexto() {
        return texto;
    }

    public void setPosicion(int filaInicio, int columnaInicio, int filaFin, int columnaFin) {
        this.filaInicio = filaInicio;
        this.columnaInicio = columnaInicio;
        this.filaFin = filaFin;
        this.columnaFin = columnaFin;
    }

    public String getPosicion() {
        return "comienza en (" + filaInicio + "," + columnaInicio + ") y termina en (" + filaFin + "," + columnaFin + ")";
    }
}
