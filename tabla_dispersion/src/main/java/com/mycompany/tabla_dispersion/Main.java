/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tabla_dispersion;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int capacidad = 20;

        TablaHashClientes tablaLineal = new TablaHashLineal(capacidad);
        TablaHashClientes tablaEncadenada = new TablaHashEncadenada(capacidad);

        while (true) {
            System.out.println("\n=== MENÚ ===");
            System.out.println("1. Insertar cliente");
            System.out.println("2. Buscar cliente");
            System.out.println("3. Salir");
            System.out.print("Opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // limpiar buffer

            if (opcion == 1) {
                Cliente cliente = leerCliente(scanner);

                System.out.println("Seleccione método:");
                System.out.println("1. Reasignación lineal");
                System.out.println("2. Encadenamiento con árbol BST");
                System.out.print("Método: ");
                int metodo = scanner.nextInt();
                scanner.nextLine();

                if (metodo == 1) {
                    tablaLineal.insertar(cliente);
                    System.out.println("Insertado con lineal.");
                } else if (metodo == 2) {
                    tablaEncadenada.insertar(cliente);
                    System.out.println("Insertado con encadenamiento.");
                } else {
                    System.out.println("Método inválido.");
                }

            } else if (opcion == 2) {
                System.out.print("Ingrese nombres: ");
                String nombres = scanner.nextLine();
                System.out.print("Ingrese apellidos: ");
                String apellidos = scanner.nextLine();

                System.out.println("Seleccione método:");
                System.out.println("1. Reasignación lineal");
                System.out.println("2. Encadenamiento con árbol BST");
                System.out.print("Método: ");
                int metodo = scanner.nextInt();
                scanner.nextLine();

                Cliente resultado = null;

                if (metodo == 1) {
                    resultado = tablaLineal.buscar(nombres, apellidos);
                } else if (metodo == 2) {
                    resultado = tablaEncadenada.buscar(nombres, apellidos);
                }

                if (resultado != null) {
                    System.out.println("Cliente encontrado:");
                    System.out.println(resultado);
                } else {
                    System.out.println("Cliente no encontrado.");
                }

            } else if (opcion == 3) {
                System.out.println("Saliendo...");
                break;
            } else {
                System.out.println("Opción inválida.");
            }
        }

        scanner.close();
    }

    private static Cliente leerCliente(Scanner scanner) {
        System.out.print("Código: ");
        String codigo = scanner.nextLine();
        System.out.print("Nombres: ");
        String nombres = scanner.nextLine();
        System.out.print("Apellidos: ");
        String apellidos = scanner.nextLine();
        System.out.print("Teléfono: ");
        String telefono = scanner.nextLine();
        System.out.print("Correo: ");
        String correo = scanner.nextLine();
        System.out.print("Dirección: ");
        String direccion = scanner.nextLine();
        System.out.print("Código Postal: ");
        String codigoPostal = scanner.nextLine();

        return new Cliente(codigo, nombres, apellidos, telefono, correo, direccion, codigoPostal);
    }
}



