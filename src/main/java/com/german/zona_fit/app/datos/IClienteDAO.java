package com.german.zona_fit.app.datos;

import com.german.zona_fit.app.dominio.Cliente;

import java.util.List;

public interface IClienteDAO {

    List<Cliente> listarClientes();
    boolean buscarClientePorId(Cliente cliente);
    boolean agregarCliente(Cliente cliente);
    boolean modificarCliente(Cliente cliente);
    boolean eliminarCliente(Cliente cliente);

}
