package Gestion;

import Interface.ABML;
import Model.Cliente;
import Model.Producto;
import Exception.IdNotFoundException;
import Exception.IdDuplicatedException;
import Exception.UserNotFoundException;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
public class GestionCliente <T extends Cliente> implements ABML<T> {
    private Map<Integer, T> clientes = new TreeMap();


    @Override
    public void agregar(T item) throws IdDuplicatedException{
        if(clientes.containsKey(item.getIdCliente())){
            throw new IdDuplicatedException("El ID ya se encuentra en el sistema.");
        }
        clientes.put(item.getIdCliente(), item);
    }

    @Override
    public void eliminar(int id) throws IdNotFoundException{
        if(!clientes.containsKey(id)){
            throw new IdNotFoundException("El ID no se encuentra en el sistema.");
        }
        clientes.remove(id);
    }

    @Override
    public void actualizar(T item) throws IdNotFoundException{
        if(!clientes.containsKey(item.getIdCliente())){
            throw new IdNotFoundException("El ID no se encuentra en el sistema.");
        }
        clientes.put(item.getIdCliente(), item);
    }

    @Override
    public T consultar(int id) throws IdNotFoundException{
        if (!clientes.containsKey(id)){
            throw new IdNotFoundException("El ID no se encuentra en el sistema.");
        }
        return clientes.get(id);
    }

    @Override
    public Map<Integer, T> verTodos() {
        return clientes;
    }

    public Cliente buscarUsuario(String email, String contrasena) throws UserNotFoundException {
        for (Cliente cliente : clientes.values()) {
            if (cliente.getMail().equals(email) && cliente.getContrasena().equals(contrasena)) {
                return cliente;
            }
        }
        throw new UserNotFoundException("Usuario o contraseña incorrectos");
    }

    public boolean existeUsuario(String email) {
        for (Cliente cliente : clientes.values()) {
            if (cliente.getMail().equals(email)) {
                return true;
            }
        }
        return false;
    }

}
