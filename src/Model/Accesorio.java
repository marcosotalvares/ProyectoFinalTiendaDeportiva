package Model;

public class Accesorio extends Producto{
    private String tipo;
    private String material;

    /// Constructores
    public Accesorio(){}

    public Accesorio(int idProducto, Marca marca, String modelo, String descripcion, Color color, int stock, double precio, String tipo, String material) {
        super(idProducto, marca, modelo, descripcion, color, stock, precio);
        this.tipo = tipo;
        this.material = material;
    }

    /// Getters & Setters

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    /// hash, toString & equals
    /// Metodos
}
