package Model;

public class Calzado extends Producto{
    private int talle;
    /// Constructores
    public Calzado() {
    }

    public Calzado(int idProducto, Marca marca, String modelo, String descripcion, Color color, int stock, double precio, int talle) {
        super(idProducto, marca, modelo, descripcion, color, stock, precio);
        this.talle = talle;
    }

    /// Getters & Setters

    public int getTalle() {
        return talle;
    }

    public void setTalle(int talle) {
        this.talle = talle;
    }
    /// hash, toString & equals
    /// Metodos
}
