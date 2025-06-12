/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tabla_dispersion;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FormularioClientes extends JFrame {
    private JTextField txtCodigo, txtNombres, txtApellidos, txtTelefono, txtCorreo, txtDireccion, txtCodigoPostal;
    private JButton btnInsertar, btnBuscar;
    private JComboBox<String> comboMetodo;
    private JTextArea areaResultado;

    private TablaHashClientes tablaLineal;
    private TablaHashClientes tablaEncadenada;

    public FormularioClientes() {
        super("Gestión de Clientes - Tabla Hash");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 600);
        setLayout(new BorderLayout());

        tablaLineal = new TablaHashLineal(30);
        tablaEncadenada = new TablaHashEncadenada(30);

        JPanel panelFormulario = new JPanel(new GridLayout(9, 2, 5, 5));

        txtCodigo = new JTextField();
        txtNombres = new JTextField();
        txtApellidos = new JTextField();
        txtTelefono = new JTextField();
        txtCorreo = new JTextField();
        txtDireccion = new JTextField();
        txtCodigoPostal = new JTextField();
        comboMetodo = new JComboBox<>(new String[]{"Reasignación lineal", "Encadenamiento (BST)"});

        panelFormulario.add(new JLabel("Código:"));
        panelFormulario.add(txtCodigo);
        panelFormulario.add(new JLabel("Nombres:"));
        panelFormulario.add(txtNombres);
        panelFormulario.add(new JLabel("Apellidos:"));
        panelFormulario.add(txtApellidos);
        panelFormulario.add(new JLabel("Teléfono:"));
        panelFormulario.add(txtTelefono);
        panelFormulario.add(new JLabel("Correo:"));
        panelFormulario.add(txtCorreo);
        panelFormulario.add(new JLabel("Dirección:"));
        panelFormulario.add(txtDireccion);
        panelFormulario.add(new JLabel("Código Postal:"));
        panelFormulario.add(txtCodigoPostal);
        panelFormulario.add(new JLabel("Método Hash:"));
        panelFormulario.add(comboMetodo);

        btnInsertar = new JButton("Insertar");
        btnBuscar = new JButton("Buscar");
        JPanel panelBotones = new JPanel();
        panelBotones.add(btnInsertar);
        panelBotones.add(btnBuscar);

        areaResultado = new JTextArea(6, 50);
        areaResultado.setEditable(false);
        JScrollPane scroll = new JScrollPane(areaResultado);

        add(panelFormulario, BorderLayout.NORTH);
        add(panelBotones, BorderLayout.CENTER);
        add(scroll, BorderLayout.SOUTH);

        btnInsertar.addActionListener(e -> insertarCliente());
        btnBuscar.addActionListener(e -> buscarCliente());

        setVisible(true);
    }

    private void insertarCliente() {
        Cliente cliente = new Cliente(
            txtCodigo.getText(),
            txtNombres.getText(),
            txtApellidos.getText(),
            txtTelefono.getText(),
            txtCorreo.getText(),
            txtDireccion.getText(),
            txtCodigoPostal.getText()
        );

        int metodo = comboMetodo.getSelectedIndex();
        if (metodo == 0) {
            tablaLineal.insertar(cliente);
            areaResultado.setText("Cliente insertado con Reasignación lineal.");
        } else {
            tablaEncadenada.insertar(cliente);
            areaResultado.setText("Cliente insertado con Encadenamiento (BST).");
        }

        limpiarCampos();
    }

    private void buscarCliente() {
        String nombres = txtNombres.getText();
        String apellidos = txtApellidos.getText();
        int metodo = comboMetodo.getSelectedIndex();

        Cliente cliente = (metodo == 0)
            ? tablaLineal.buscar(nombres, apellidos)
            : tablaEncadenada.buscar(nombres, apellidos);

        if (cliente != null) {
            areaResultado.setText("Cliente encontrado:\n" + cliente);
        } else {
            areaResultado.setText("Cliente no encontrado.");
        }
    }

    private void limpiarCampos() {
        txtCodigo.setText("");
        txtNombres.setText("");
        txtApellidos.setText("");
        txtTelefono.setText("");
        txtCorreo.setText("");
        txtDireccion.setText("");
        txtCodigoPostal.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(FormularioClientes::new);
    }
}

