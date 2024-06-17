package Gestion;

import Interface.ABML;
import Model.Marca;
import Model.Producto;
import Exception.IdNotFoundException;
import Exception.IdDuplicatedException;

import javax.naming.InsufficientResourcesException;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class GestionProducto <T extends Producto> implements ABML<T> {

    private Map<Integer, T> productos = new TreeMap<>();
    @Override
    public void agregar(T item) throws IdDuplicatedException{
        if(productos.containsKey(item.getId())){
            throw new IdDuplicatedException("El ID ya se encuentra en la tienda.");
        }
        productos.put(item.getId(), item);
    }

    @Override
    public void eliminar(int id) throws IdNotFoundException{
        if(!productos.containsKey(id)){
            throw new IdNotFoundException("El ID no se encuentra en la tienda.");
        }
        productos.remove(id);
    }

    @Override
    public void actualizar(T item) throws IdNotFoundException{
        if(!productos.containsKey(item.getId())){
            throw new IdNotFoundException("El ID no se encuentra en la tienda.");
        }
        productos.put(item.getId(), item);
    }

    @Override
    public T consultar(int id) throws IdNotFoundException{
        if (!productos.containsKey(id)){
            throw new IdNotFoundException("El ID no se encuentra en la tienda.");
        }
        return productos.get(id);
    }

    @Override
    public Map<Integer, T> verTodos() {
        return productos;
    }
}
