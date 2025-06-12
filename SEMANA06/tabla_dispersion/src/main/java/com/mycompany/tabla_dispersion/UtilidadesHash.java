/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tabla_dispersion;

/**
 *
 * @author USUARIO
 */
public class UtilidadesHash {
    public static int hash(String nombres, String apellidos, int capacidad) {
        String clave = nombres.toLowerCase() + apellidos.toLowerCase();
        int hash = 7;
        for (int i = 0; i < clave.length(); i++) {
            hash = hash * 31 + clave.charAt(i);
        }
        return Math.abs(hash) % capacidad;
    }
}

