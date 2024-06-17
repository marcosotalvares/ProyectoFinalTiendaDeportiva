package UI;

import Contenedor.Tienda;
import Model.*;
import Exception.IdNotFoundException;
import Exception.IdDuplicatedException;
import Exception.UserNotFoundException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.Scanner;

public class ConsolaUI {
    private Tienda tienda;
    private Scanner sc;

    public ConsolaUI(Tienda tienda) {
        this.tienda = tienda;
        this.sc = new Scanner(System.in);
    }


    public void mostrarMenuIngreso() throws IdDuplicatedException, IdNotFoundException, UserNotFoundException{
        int opc;
        System.out.println("\n--- Menú Principal ---");
        System.out.println("1. Administrador");
        System.out.println("2. Usuario");
        System.out.println("0. Salir");
        System.out.print("Seleccione una opción: ");
        opc = sc.nextInt();
        sc.nextLine();
        switch (opc){
            case 1:
               mostrarMenuProductos();
               break;
           case 2:
               ingresarORegistrarse();
               break;
           case 0:
               break;
           default:
               System.out.println("Ingrese una opcion valida: ");
               break;
       }
    }
    public void mostrarMenuProductos() throws IdDuplicatedException, IdNotFoundException, UserNotFoundException{
        int opc=0;
        do {
            System.out.println("\n--- Menú Adminstrador ---");
            System.out.println("1. Agregar Producto");
            System.out.println("2. Eliminar Producto");
            System.out.println("3. Actualizar Producto");
            System.out.println("4. Consultar Producto");
            System.out.println("5. Listar Productos");
            System.out.println("6. Filtrar Productos Por Marca");
            System.out.println("7. Listar Clientes");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            opc = sc.nextInt();
            sc.nextLine(); // Limpiar el buffer
            switch (opc){
                case 1:
                    agregarProducto();
                    break;
                case 2:
                    eliminarProducto();
                    break;
                case 3:
                    actualizarProducto();
                    break;
                case 4:
                    consultarProducto();
                    break;
                case 5:
                    listarProductos();
                    break;
                case 6:
                    filtrarProductosPorMarca();
                    break;
                case 7:
                    listarClientes();
                    break;
                case 0:
                    mostrarMenuIngreso();
                    break;
            }
        }while (opc != 0);
    }

    private void filtrarProductosPorMarca() {
        System.out.println("\n--- Lista de Productos ---");
        Map<Integer, Producto> productos = tienda.obtenerTodosLosProductos();
        Marca tipoMarca = null;
        while (tipoMarca == null) {
            System.out.println("Ingrese la marca a filtrar: (ADIDAS, NIKE, PUMA, UNDER_ARMOUR, TOPPER, REEBOK): ");
            String input = sc.nextLine().toUpperCase();
            try {
                tipoMarca = Marca.valueOf(input);
            } catch (IllegalArgumentException e) {
                System.out.println("Marca no válida. Intente de nuevo.");
            }
        }
        for (Producto producto : productos.values()) {
            if(producto.getMarca().equals(tipoMarca)){
            System.out.print("ID: " + producto.getId() + ", Modelo: " + producto.getModelo() + ", Descripcion: " + producto.getDescripcion() + ", Marca: " + producto.getMarca() +  ", Color: " + producto.getColor() +", Precio: " + producto.getPrecio() + ", Stock: " + producto.getStock());
            if(producto instanceof Indumentaria){
                System.out.println(", Talla: " + ((Indumentaria) producto).getTalla());
            } else if (producto instanceof Calzado) {
                System.out.println(", Talle: " + ((Calzado) producto).getTalle());
            }else if (producto instanceof Accesorio){
                System.out.println(", Tipo: " + ((Accesorio) producto).getTipo() + " Material: " + ((Accesorio) producto).getMaterial());
            }
        }
    }
    }

    public void listarProductos() {
        System.out.println("\n--- Lista de Productos ---");
        Map<Integer, Producto> productos = tienda.obtenerTodosLosProductos();
        for (Producto producto : productos.values()) {
            System.out.print("ID: " + producto.getId() + ", Modelo: " + producto.getModelo() + ", Descripcion: " + producto.getDescripcion() + ", Marca: " + producto.getMarca() +  ", Color: " + producto.getColor() +", Precio: " + producto.getPrecio() + ", Stock: " + producto.getStock());
            if(producto instanceof Indumentaria){
                System.out.println(", Talla: " + ((Indumentaria) producto).getTalla());
            } else if (producto instanceof Calzado) {
                System.out.println(", Talle: " + ((Calzado) producto).getTalle());
            }else if (producto instanceof Accesorio){
                System.out.println(", Tipo: " + ((Accesorio) producto).getTipo() + " Material: " + ((Accesorio) producto).getMaterial());
            }
        }
    }


    private void consultarProducto() throws IdNotFoundException{
        System.out.println("\n--- Consultar Producto ---");
        System.out.print("Ingrese el ID del producto: ");
        int id = sc.nextInt();
        sc.nextLine();
        Producto producto = tienda.consultarProducto(id);
            System.out.println("ID: " + producto.getId());
            System.out.println("Modelo: " + producto.getModelo());
            System.out.println("Marca: " + producto.getMarca());
            System.out.println("Color: " + producto.getColor());
            System.out.println("Descripcion: " + producto.getDescripcion());
            System.out.println("Precio: " + producto.getPrecio());
            System.out.println("Stock: " + producto.getStock());
        }


    private void actualizarProducto() throws IdNotFoundException{
        System.out.println("\n--- Actualizar Producto ---");
        System.out.print("Ingrese el ID del producto a actualizar: ");
        int id = sc.nextInt();
        sc.nextLine();
        Producto producto = tienda.consultarProducto(id);

        System.out.println("\n--- Actualizar Producto ---");
        System.out.println("1. Actualizar ID");
        System.out.println("2. Actualizar modelo");
        System.out.println("3. Actualizar descripcion");
        System.out.println("4. Actualizar marca");
        System.out.println("5. Actualizar color");
        System.out.println("6. Actualizar precio");
        System.out.println("7. Actualizar stock");
        if (producto instanceof Indumentaria){
            System.out.println("8. Actualizar talla");
        } else if (producto instanceof Calzado) {
            System.out.println("8. Actualizar talle");
        } else if (producto instanceof Accesorio) {
            System.out.println("8. Actualizar material");
        }
        System.out.println("0. Salir");
        System.out.print("Seleccione una opción: ");
        int opc = sc.nextInt();
        sc.nextLine();
        switch (opc){
            case 1:
                System.out.println("Ingrese el nuevo id: ");
                int newId = sc.nextInt();
                producto.setIdProducto(newId);
                sc.nextLine();
                break;
            case 2:
                System.out.println("Ingrese el nuevo modelo: ");
                String modelo = sc.nextLine();
                producto.setModelo(modelo);
                break;
            case 3:
                System.out.println("Ingrese la nueva descripcion: ");
                String descripcion = sc.nextLine();
                producto.setDescripcion(descripcion);
                break;
            case 4:
                Marca tipoMarca = null;
                while (tipoMarca == null) {
                    System.out.println("Ingrese la nueva marca: (ADIDAS, NIKE, PUMA, UNDER_ARMOUR, TOPPER, REEBOK): ");
                    String input = sc.nextLine().toUpperCase();
                    try {
                        tipoMarca = Marca.valueOf(input);
                    } catch (IllegalArgumentException e) {
                        System.out.println("Marca no válida. Intente de nuevo.");
                    }
                }
                producto.setMarca(tipoMarca);
                break;
            case 5:
                Color tipoColor = null;
                while (tipoColor == null) {
                    System.out.println("Ingrese el color: (BLANCO, NEGRO, GRIS, ROJO, AZUL, AMARILLO, VERDE, NARANJA): ");
                    String input = sc.nextLine().toUpperCase();
                    try {
                        tipoColor = Color.valueOf(input);
                    } catch (IllegalArgumentException e) {
                        System.out.println("Color no válida. Intente de nuevo.");
                    }
                }
                producto.setColor(tipoColor);
                break;
            case 6:
                System.out.println("Ingrese el nuevo precio: ");
                double precio = sc.nextDouble();
                producto.setPrecio(precio);
                sc.nextLine();
                break;
            case 7:
                System.out.println("Ingrese el nuevo stock: ");
                int stock = sc.nextInt();
                producto.setStock(stock);
                sc.nextLine();
                break;
            case 8:
                if (producto instanceof Indumentaria){
                    System.out.println("Ingrese la nueva talla: ");
                    String talla = sc.nextLine();
                    ((Indumentaria) producto).setTalla(talla);
                } else if (producto instanceof Calzado) {
                    System.out.println("Ingrese el nuevo talle: ");
                    int talle = sc.nextInt();
                    ((Calzado) producto).setTalle(talle);
                    sc.nextLine();
                } else if (producto instanceof Accesorio) {
                    System.out.println("Ingrese el nuevo material: ");
                    String material = sc.nextLine();
                    ((Accesorio) producto).setMaterial(material);
                }
                break;
            case 0:
                break;
            default:
                System.out.println("Opcion invalida, ingrese una correcta.");
                break;
        }
        tienda.actualizarProducto(producto);
        System.out.println("Producto actualizado exitosamente.");
    }

    private void eliminarProducto() throws IdNotFoundException{
        System.out.println("\n--- Eliminar Producto ---");
        System.out.print("Ingrese el ID del producto a eliminar: ");
        int id = sc.nextInt();
        sc.nextLine();
        tienda.eliminarProducto(id);
        System.out.println("Producto eliminado exitosamente.");
    }

    private void agregarProducto() throws IdDuplicatedException {
        System.out.println("\n--- Agregar Producto ---");
        System.out.println("1. Calzado");
        System.out.println("2. Indumentaria");
        System.out.println("3. Accesorio");
        System.out.print("Seleccione el tipo de producto: ");
        int tipo = sc.nextInt();
        sc.nextLine(); // Limpiar el buffer

        System.out.print("Ingrese ID: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("Ingrese modelo: ");
        String modelo = sc.nextLine();
        System.out.print("Ingrese descripcion: ");
        String descripcion = sc.nextLine();
        System.out.print("Ingrese precio: ");
        double precio = sc.nextDouble();
        System.out.print("Ingrese stock: ");
        int stock = sc.nextInt();
        sc.nextLine();
        Marca tipoMarca = null;
        while (tipoMarca == null) {
            System.out.println("Ingrese la marca: (ADIDAS, NIKE, PUMA, UNDER_ARMOUR, TOPPER, REEBOK): ");
            String input = sc.nextLine().toUpperCase();
            try {
                tipoMarca = Marca.valueOf(input);
            } catch (IllegalArgumentException e) {
                System.out.println("Marca no válida. Intente de nuevo.");
            }
        }
        Color tipoColor = null;
        while (tipoColor == null) {
            System.out.println("Ingrese el color: (BLANCO, NEGRO, GRIS, ROJO, AZUL, AMARILLO, VERDE, NARANJA): ");
            String input = sc.nextLine().toUpperCase();
            try {
                tipoColor = Color.valueOf(input);
            } catch (IllegalArgumentException e) {
                System.out.println("Color no válida. Intente de nuevo.");
            }
        }
        Producto producto = null;
        switch (tipo) {
            case 1:
                System.out.print("Ingrese talla: ");
                int tallaCalzado = sc.nextInt();
                sc.nextLine();
                producto = new Calzado(id, tipoMarca, modelo, descripcion, tipoColor, stock, precio, tallaCalzado);
                break;
            case 2:
                System.out.print("Ingrese talla: ");
                String tallaIndumentaria = sc.nextLine();
                producto = new Indumentaria(id, tipoMarca, modelo, descripcion, tipoColor, stock, precio, tallaIndumentaria);
                break;
            case 3:
                System.out.print("Ingrese tipo: ");
                String tipoAccesorio = sc.nextLine();
                System.out.print("Ingrese material: ");
                String materialAccesorio = sc.nextLine();
                producto = new Accesorio(id, tipoMarca,modelo, descripcion, tipoColor, stock, precio, tipoAccesorio, materialAccesorio);
                break;
            default:
                System.out.println("Tipo de producto no válido.");
                return;
        }
        tienda.agregarProducto(producto);
        System.out.println("Producto agregado exitosamente.");
    }


    public void mostrarMenuClientes() throws IdDuplicatedException, IdNotFoundException, UserNotFoundException{
        int opc = 0;
        do {
            System.out.println("\n--- Menú Usuario ---");
            System.out.println("1. Editar Mi Cuenta");
            System.out.println("2. Ver Mi Cuenta");
            System.out.println("3. Eliminar Mi Cuenta");
            System.out.println("4. Comprar");
            System.out.println("4. Ver Mis Compras");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            opc = sc.nextInt();
            sc.nextLine(); // Limpiar el buffer
            switch (opc){
                case 1:
                    editarCliente();
                    break;
                case 2:
                    consultarCliente();
                    break;
                case 3:
                    eliminarCliente();
                    break;
                    /// COMPRAR
                    /// 5.VER MIS COMPRAS
                case 0:
                    mostrarMenuIngreso();
                    break;
            }
        }while (opc != 0);
    }

    private void ingresarORegistrarse() throws IdDuplicatedException, IdNotFoundException, UserNotFoundException{
        int opc;
        System.out.println();
        System.out.println("\n--- Menú Usuario ---");
        System.out.println("1. Ingresar");
        System.out.println("2. Registrarse");
        System.out.println("0. Salir");
        System.out.print("Seleccione una opción: ");
        opc = sc.nextInt();
        sc.nextLine();
        switch (opc){
            case 1:
                try{
                    ingresarCliente();
                }catch (UserNotFoundException e){
                    System.out.println(e.getMessage());
                }
                break;
            case 2:
                try {
                    agregarCliente();
                }catch (IdDuplicatedException e){
                    System.out.println(e.getMessage());
                }
                mostrarMenuClientes();
                break;
            case 0:
                mostrarMenuIngreso();
                break;
            default:
                System.out.println("Opcion invalida, ingrese una correcta: ");
                break;
        }
    }

    public void ingresarCliente() throws UserNotFoundException, IdDuplicatedException, IdNotFoundException{
        System.out.println("\n--- Ingreso de Usuario ---");
        System.out.println("Ingrese su mail: ");
        String mail = sc.nextLine();
        System.out.println("Ingrese su contrasena: ");
        String contrasena = sc.nextLine();
        try {
            buscarClienteIngreso(mail, contrasena);
        } catch (Exception.UserNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private void buscarClienteIngreso(String mail, String contrasena) throws UserNotFoundException {
        tienda.buscarClienteIngreso(mail, contrasena);
    }

    public void listarClientes() {
        System.out.println("\n--- Lista de Clientes ---");
        Map<Integer, Cliente> clientes = tienda.obtenerTodosLosClientes();
        for (Cliente cliente : clientes.values()) {
            System.out.println("ID: " + cliente.getIdCliente() + ", Nombre: " + cliente.getNombre() + ", Apellido: " + cliente.getApellido() + ", Genero: " + cliente.getGenero() +  ", Fecha de nacimiento: " + cliente.getFechaNacimiento() + ", Mail: " + cliente.getMail() + ", Contrasena: " + cliente.getContrasena() + ", Telefono: " + cliente.getTelefono() + ", Direccion: " + cliente.getDireccion());
        }
    }
    private void consultarCliente() throws IdNotFoundException{
        System.out.println("\n--- Consultar Cliente ---");
        System.out.print("Ingrese el ID del cliente: ");
        int id = sc.nextInt();
        sc.nextLine();
        Cliente cliente = tienda.consultarCliente(id);
        System.out.println("ID: " + cliente.getIdCliente());
        System.out.println("Nombre: " + cliente.getNombre());
        System.out.println("Apellido: " + cliente.getApellido());
        System.out.println("Genero: " + cliente.getGenero());
        System.out.println("Fecha de nacimiento: " + cliente.getFechaNacimiento());
        System.out.println("Mail: " + cliente.getMail());
        System.out.println("Contrasena: " + cliente.getContrasena());
        System.out.println("Telefono: " + cliente.getTelefono());
        System.out.println("Direccion: " + cliente.getDireccion());
    }

    private void editarCliente() throws IdNotFoundException{
        System.out.println("\n--- Actualizar Cliente ---");
        System.out.print("Ingrese el ID del cliente a actualizar: ");
        int id = sc.nextInt();
        sc.nextLine();
        Cliente cliente = tienda.consultarCliente(id);

        System.out.println("\n--- Editar Perfil ---");
        System.out.println("1. Editar nombre");
        System.out.println("2. Editar apellido");
        System.out.println("3. Editar genero");
        System.out.println("4. Editar fecha de nacimiento");
        System.out.println("5. Editar mail");
        System.out.println("6. Editar contrasena");
        System.out.println("7. Editar telefono");
        System.out.println("8. Editar direccion");
        System.out.println("0. Salir");
        System.out.print("Seleccione una opción: ");
        int opc = sc.nextInt();
        switch (opc){
            case 1:
                System.out.println("Ingrese el nuevo nombre: ");
                String nombre = sc.nextLine();
                cliente.setNombre(nombre);
                break;
            case 2:
                System.out.println("Ingrese el nuevo apellido: ");
                String apellido = sc.nextLine();
                cliente.setApellido(apellido);
                break;
            case 3:
                System.out.println("Ingrese el nuevo genero: ");
                String genero = sc.nextLine();
                cliente.setGenero(genero);
                break;
            case 4:
                System.out.print("Ingrese la nueva fecha de nacimiento(dd/mm/yyyy): ");
                String fechaStr = sc.nextLine();
                LocalDate fechaNacimiento = LocalDate.parse(fechaStr, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                cliente.setFechaNacimiento(fechaNacimiento);
                break;
            case 5:
                System.out.println("Ingrese el nuevo mail: ");
                String mail = sc.nextLine();
                cliente.setMail(mail);
                break;
            case 6:
                System.out.println("Ingrese la nueva contrasena: ");
                String contrasena = sc.nextLine();
                cliente.setContrasena(contrasena);
                break;
            case 7:
                System.out.println("Ingrese el nuevo telefono: ");
                String telefono = sc.nextLine();
                cliente.setTelefono(telefono);
                break;
            case 8:
                System.out.println("Ingrese la nueva direccion: ");
                String direccion = sc.nextLine();
                cliente.setDireccion(direccion);
                break;
            case 0:
                break;
            default:
                System.out.println("Opcion invalida, ingrese una correcta.");
                break;
        }
        System.out.println("Cliente actualizado exitosamente.");
    }

    private void eliminarCliente() throws IdNotFoundException{
        System.out.println("\n--- Eliminar Cliente ---");
        System.out.print("Ingrese el ID del cliente a eliminar: ");
        int id = sc.nextInt();
        sc.nextLine();
        tienda.eliminarCliente(id);
        System.out.println("Cliente eliminado exitosamente.");
    }

    private void agregarCliente() throws IdDuplicatedException {
        System.out.println("\n--- Agregar Cliente ---");
        System.out.print("Ingrese ID: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("Ingrese nombre: ");
        String nombre = sc.nextLine();
        System.out.print("Ingrese apellido: ");
        String apellido = sc.nextLine();
        System.out.print("Ingrese dni: ");
        String dni = sc.nextLine();

        System.out.print("Ingrese fecha de nacimiento(dd/mm/yyyy): ");
        String fechaStr = sc.nextLine();
        LocalDate fechaNacimiento = LocalDate.parse(fechaStr, DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        System.out.print("Ingrese genero: ");
        String genero = sc.nextLine();
        System.out.print("Ingrese mail: ");
        String mail = sc.nextLine();
        System.out.print("Ingrese contrasena: ");
        String contrasena = sc.nextLine();
        System.out.print("Ingrese telefono: ");
        String telefono = sc.nextLine();
        System.out.print("Ingrese direccion: ");
        String direccion = sc.nextLine();
        Cliente cliente = new Cliente(id, nombre, apellido, dni, fechaNacimiento, genero, mail, contrasena, telefono, direccion);
        tienda.agregarCliente(cliente);
        System.out.println("Cliente agregado exitosamente.");
    }

}
