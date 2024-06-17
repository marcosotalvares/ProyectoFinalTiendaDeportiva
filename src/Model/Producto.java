package Model;

public abstract class Producto {
   // private static int contador = 0;
    private int idProducto;
    private Marca marca;
    private String modelo;
    private String descripcion;
    private Color color;
    private int stock;
    private double precio;
/// Constructores


    public Producto() {
    }

    public Producto(int idProducto, Marca marca, String modelo, String descripcion, Color color, int stock, double precio) {
        this.idProducto = idProducto;
        this.marca = marca;
        this.modelo = modelo;
        this.descripcion = descripcion;
        this.color = color;
        this.stock = stock;
        this.precio = precio;
    }

    /// Getters & Setters

    public int getId() {
        return idProducto;
    }

    //public void setIdProducto(){
       // contador++;
        //this.idProducto = contador;
    //}
    public void setIdProducto(int idProducto){
        this.idProducto = idProducto;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
       this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    /// hash, toString & equals

    /// Metodos
    ///  public abstract double calcularPrecio();
    ///public abstract void agregarAlCarrito();
    ///public abstract void verDetalles();
    ///public abstract void actualizarStock();
}

