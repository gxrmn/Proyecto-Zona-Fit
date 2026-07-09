package com.german.zona_fit.app.presentacion;

import com.german.zona_fit.app.datos.ClienteDAO;
import com.german.zona_fit.app.datos.IClienteDAO;
import com.german.zona_fit.app.dominio.Cliente;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ZonaFitApp {
    Scanner consola = new Scanner(System.in);

    public static void main(String[] args) {
        ZonaFitApp menu = new ZonaFitApp();
        menu.Menu();
    }

    public void Menu(){
        ZonaFitApp obj = new ZonaFitApp();
        boolean bandera = false;
        int opcion = 0;

        while(!bandera){
            try {
                System.out.print("""
                        --- SISTEMA DE GESTION DE USUARIOS DEL GIMNASIO ---
                        1.- Listar Clientes
                        2.- Buscar un Cliente
                        3.- Agregar Cliente
                        4.- Modificar Cliente
                        5.- Eliminar Cliente
                        6.- Salir
                        
                        Ingresa la opcion deseada: """);
                opcion = Integer.parseInt(consola.nextLine());
                switch (opcion) {
                    case 1:
                        obj.listarClientes();
                        System.out.println();
                        break;
                    case 2:
                        obj.buscarCliente();
                        System.out.println();
                        break;
                    case 3:
                        obj.agregarCliente();
                        System.out.println();
                        break;
                    case 4:
                        obj.modificarCliente();
                        System.out.println();
                        break;
                    case 5:
                        obj.eliminarCliente();
                        System.out.println();
                        break;
                    case 6:
                        System.out.println("\nCerrando el Sistema...");
                        bandera = true;
                        break;
                    default:
                        System.out.println("Opcion no encontrada");
                        break;
                }
            } catch (Exception e) {
                System.out.println("Error al elegir una opcion: " + e.getMessage());
            }
        }
    }

    private void listarClientes(){
        IClienteDAO clienteDAO = new ClienteDAO();
        List<Cliente> clientes = new ArrayList<>();
        clientes = clienteDAO.listarClientes();
        if(clientes.isEmpty()){
            System.out.println("No existen Clientes en la base de datos!");
        }
        else {
            System.out.println("--- Lista de Clientes ---");
            clientes.forEach(System.out::println);
        }
    }

    private void buscarCliente(){
        IClienteDAO clienteDAO = new ClienteDAO();
        System.out.print("Ingresa el id del Cliente que desea buscar: ");
        int id = Integer.parseInt(consola.nextLine());
        Cliente clienteBuscar = new Cliente(id);
        boolean encontrado = clienteDAO.buscarClientePorId(clienteBuscar);
        if(encontrado){
            System.out.println("Cliente encontrado en la base de datos: " + clienteBuscar);
        }
        else{
            System.out.println("Cliente con ese ID no encontrado en la base de datos!");
        }
    }

    private void agregarCliente(){
        IClienteDAO clienteDAO = new ClienteDAO();
        System.out.print("Ingresa el nombre del Cliente: ");
        String nombre = consola.nextLine();
        System.out.print("Ingresa el apellido del Cliente: ");
        String apellido = consola.nextLine();
        System.out.print("Ingresa la memebresia del Cliente: ");
        int membresia = Integer.parseInt(consola.nextLine());
        Cliente cliente = new Cliente(nombre, apellido, membresia);
        boolean agregado = clienteDAO.agregarCliente(cliente);
        if(agregado){
            System.out.println("Cliente agregado en la base de datos: " + cliente);
        }
        else{
            System.out.println("No se pudo agregar el Cliente en la base de datos!");
        }
    }

    private void modificarCliente(){
        IClienteDAO clienteDAO = new ClienteDAO();
        System.out.print("Ingresa el ID del cliente a modificar:");
        int id = Integer.parseInt(consola.nextLine());
        System.out.print("Ingresa el nombre del Cliente: ");
        String nombre = consola.nextLine();
        System.out.print("Ingresa el apellido del Cliente: ");
        String apellido = consola.nextLine();
        System.out.print("Ingresa la memebresia del Cliente: ");
        int membresia = Integer.parseInt(consola.nextLine());
        Cliente cliente = new Cliente(id, nombre, apellido, membresia);
        boolean modificado = clienteDAO.modificarCliente(cliente);
        if(modificado){
            System.out.println("Los datos del Cliente han sido modificados en la base de datos: " + cliente);
        }
        else{
            System.out.println("No se pudo modificar el Cliente en la base de datos!");
        }
    }

    private void eliminarCliente(){
        IClienteDAO clienteDAO = new ClienteDAO();
        System.out.print("Ingresa el ID del cliente a modificar:");
        int id = Integer.parseInt(consola.nextLine());
        Cliente cliente = new Cliente(id);
        boolean eliminado = clienteDAO.eliminarCliente(cliente);
        if(eliminado){
            System.out.println("Cliente eliminado en la base de datos: " + cliente);
        }
        else{
            System.out.println("No se pudo eliminar el Cliente en la base de datos!");
        }
    }
}
