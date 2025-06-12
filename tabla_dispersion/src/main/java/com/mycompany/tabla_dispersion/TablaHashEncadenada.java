/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tabla_dispersion;

public class TablaHashEncadenada implements TablaHashClientes {
    private ArbolBinarioBusqueda[] tabla;
    private int capacidad;

    public TablaHashEncadenada(int capacidad) {
        this.capacidad = capacidad;
        this.tabla = new ArbolBinarioBusqueda[capacidad];
        for (int i = 0; i < capacidad; i++) {
            tabla[i] = new ArbolBinarioBusqueda();
        }
    }

    @Override
    public void insertar(Cliente cliente) {
        int indice = UtilidadesHash.hash(cliente.getNombres(), cliente.getApellidos(), capacidad);
        tabla[indice].insertar(cliente);
    }

    @Override
    public Cliente buscar(String nombres, String apellidos) {
        int indice = UtilidadesHash.hash(nombres, apellidos, capacidad);
        return tabla[indice].buscar(nombres, apellidos);
    }
}

