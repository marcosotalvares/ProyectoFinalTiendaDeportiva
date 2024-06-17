package Interface;
import Exception.IdNotFoundException;
import Exception.IdDuplicatedException;

import java.util.Map;

public interface ABML <T>{
    void agregar(T item) throws IdDuplicatedException;
    void eliminar(int id) throws IdNotFoundException;
    void actualizar(T item) throws IdNotFoundException;
    T consultar(int id) throws IdNotFoundException;

    Map<Integer, T> verTodos();

    // Filtrar x tipo (Marca)
}
