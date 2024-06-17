package Model;

import java.time.LocalDate;

public class Cliente extends Persona{
    private int idCliente;
    private String mail;
    private String contrasena;
    private String telefono;
    private String direccion;
    // Constructores
    public Cliente(){}

    public Cliente(int idCliente, String nombre, String apellido, String dni, LocalDate fechaNacimiento, String genero, String mail, String contrasena, String telefono, String direccion) {
        super(nombre, apellido, dni, fechaNacimiento, genero);
        this.idCliente = idCliente;
        this.mail = mail;
        this.contrasena = contrasena;
        this.telefono = telefono;
        this.direccion = direccion;
    }
    // Metodos

    // Getters & Setters

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    // toString
}
