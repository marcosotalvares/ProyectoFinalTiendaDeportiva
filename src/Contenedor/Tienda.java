package Contenedor;

import Model.Cliente;
import Gestion.GestionCliente;
import Gestion.GestionProducto;
import Model.Producto;

import Exception.IdNotFoundException;
import Exception.UserNotFoundException;
import Exception.IdDuplicatedException;

import java.util.Map;

public class Tienda {
    private GestionProducto<Producto> productos = new GestionProducto<>();
    private GestionCliente<Cliente> clientes = new GestionCliente<>();

    public void agregarProducto(Producto producto) throws IdDuplicatedException{
        productos.agregar(producto);
    }

    public void eliminarProducto(int id) throws IdNotFoundException{
        productos.eliminar(id);
    }

    public void actualizarProducto(Producto producto) throws IdNotFoundException{
         productos.actualizar(producto);
    }

    public Producto consultarProducto(int id)throws IdNotFoundException{
        return productos.consultar(id);
    }

    public Map<Integer, Producto> obtenerTodosLosProductos() {
        return ((GestionProducto<Producto>) productos).verTodos();
    }

    public void agregarCliente(Cliente cliente) throws IdDuplicatedException{
        clientes.agregar(cliente);
    }

    public void eliminarCliente(int id) throws IdNotFoundException{
        clientes.eliminar(id);
    }

    public void actualizarCliente(Cliente cliente) throws IdNotFoundException{
        clientes.actualizar(cliente);
    }

    public Cliente consultarCliente(int id)throws IdNotFoundException{
        return clientes.consultar(id);
    }

    public Map<Integer, Cliente> obtenerTodosLosClientes() {
        return ((GestionCliente<Cliente>) clientes).verTodos();
    }

    public Cliente buscarClienteIngreso(String mail, String contrasena) throws UserNotFoundException {
       return clientes.buscarUsuario(mail, contrasena);
    }
}
