/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tabla_dispersion;

/**
 *
 * @author USUARIO
 */
public class Cliente {
    private String codigo;
    private String nombres;
    private String apellidos;
    private String telefono;
    private String correo;
    private String direccion;
    private String codigoPostal;

    public Cliente(String codigo, String nombres, String apellidos, String telefono, String correo, String direccion, String codigoPostal) {
        this.codigo = codigo;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.telefono = telefono;
        this.correo = correo;
        this.direccion = direccion;
        this.codigoPostal = codigoPostal;
    }

    // Getters
    public String getCodigo() { return codigo; }
    public String getNombres() { return nombres; }
    public String getApellidos() { return apellidos; }
    public String getTelefono() { return telefono; }
    public String getCorreo() { return correo; }
    public String getDireccion() { return direccion; }
    public String getCodigoPostal() { return codigoPostal; }

    // Para mostrar el cliente fácilmente
    @Override
    public String toString() {
        return nombres + " " + apellidos + " | Tel: " + telefono + " | Correo: " + correo;
    }
}
