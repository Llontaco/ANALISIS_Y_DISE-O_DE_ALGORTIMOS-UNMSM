/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tabla_dispersion;

public class ArbolBinarioBusqueda {
    private NodoBST raiz;

    public void insertar(Cliente cliente) {
        raiz = insertarRec(raiz, cliente);
    }

    private NodoBST insertarRec(NodoBST nodo, Cliente cliente) {
        if (nodo == null) return new NodoBST(cliente);
        String claveNueva = cliente.getNombres() + cliente.getApellidos();
        String claveNodo = nodo.cliente.getNombres() + nodo.cliente.getApellidos();
        if (claveNueva.compareToIgnoreCase(claveNodo) < 0) {
            nodo.izquierdo = insertarRec(nodo.izquierdo, cliente);
        } else {
            nodo.derecho = insertarRec(nodo.derecho, cliente);
        }
        return nodo;
    }

    public Cliente buscar(String nombres, String apellidos) {
        return buscarRec(raiz, nombres, apellidos);
    }

    private Cliente buscarRec(NodoBST nodo, String nombres, String apellidos) {
        if (nodo == null) return null;
        String claveBuscada = nombres + apellidos;
        String claveNodo = nodo.cliente.getNombres() + nodo.cliente.getApellidos();
        int cmp = claveBuscada.compareToIgnoreCase(claveNodo);
        if (cmp == 0) return nodo.cliente;
        return cmp < 0
            ? buscarRec(nodo.izquierdo, nombres, apellidos)
            : buscarRec(nodo.derecho, nombres, apellidos);
    }
}

