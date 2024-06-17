package Model;

public class Indumentaria extends Producto{
    private String talla;

    /// Constructores
    public Indumentaria(){}

    public Indumentaria(int idProducto, Marca marca, String modelo, String descripcion, Color color, int stock, double precio, String talla) {
        super(idProducto, marca, modelo, descripcion, color, stock, precio);
        this.talla = talla;
    }

    /// Getters & Setters

    public String getTalla() {
        return talla;
    }

    public void setTalla(String talla) {
        this.talla = talla;
    }

    /// hash, toString & equals
    /// Metodos

}
