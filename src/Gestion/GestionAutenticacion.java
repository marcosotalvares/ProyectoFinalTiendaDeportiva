package Gestion;

import Model.Cliente;

import Exception.IdNotFoundException;
import Exception.UserNotFoundException;
import Exception.IdDuplicatedException;
public class GestionAutenticacion {
    private static final String ADMIN_CONTRASENA = "admin123";
    private GestionCliente<Cliente> gestionCliente;

    public GestionAutenticacion(GestionCliente<Cliente> gestionCliente) {
        this.gestionCliente = gestionCliente;
    }

    public boolean autenticarAdmin(String password) {
        return ADMIN_CONTRASENA.equals(password);
    }

    public boolean registrarUsuario(Cliente cliente) throws IdDuplicatedException {
        if (gestionCliente.existeUsuario(cliente.getMail())) {
            return false; // El usuario ya existe
        }
        gestionCliente.agregar(cliente);
        return true;
    }

    public Cliente autenticarUsuario(String email, String contrasena) throws UserNotFoundException {
        return gestionCliente.buscarUsuario(email, contrasena);
    }
}
