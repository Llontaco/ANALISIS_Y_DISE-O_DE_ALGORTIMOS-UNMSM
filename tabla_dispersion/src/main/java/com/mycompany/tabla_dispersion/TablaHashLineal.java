/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tabla_dispersion;

public class TablaHashLineal implements TablaHashClientes {
    private Cliente[] tabla;
    private int capacidad;
    private int tamaño;

    public TablaHashLineal(int capacidad) {
        this.capacidad = capacidad;
        this.tabla = new Cliente[capacidad];
        this.tamaño = 0;
    }

    @Override
    public void insertar(Cliente cliente) {
        if (tamaño >= capacidad) {
            System.out.println("Tabla llena, no se puede insertar.");
            return;
        }

        int indice = UtilidadesHash.hash(cliente.getNombres(), cliente.getApellidos(), capacidad);

        while (tabla[indice] != null) {
            // Colisión, buscar siguiente posición
            indice = (indice + 1) % capacidad;
        }

        tabla[indice] = cliente;
        tamaño++;
    }

    @Override
    public Cliente buscar(String nombres, String apellidos) {
        int indice = UtilidadesHash.hash(nombres, apellidos, capacidad);
        int intentos = 0;

        while (tabla[indice] != null && intentos < capacidad) {
            Cliente c = tabla[indice];
            if (c.getNombres().equalsIgnoreCase(nombres) && c.getApellidos().equalsIgnoreCase(apellidos)) {
                return c;
            }
            indice = (indice + 1) % capacidad;
            intentos++;
        }

        return null; // No encontrado
    }
}

