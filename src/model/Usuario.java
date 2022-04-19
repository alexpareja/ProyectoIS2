package model;

public class Usuario {
    private String usuario;
    private String contrasena;
    private String nombre;
    private boolean dueno;
    private String correo;
    private Carrito carrito;

    public Usuario(String usuario, String contrasena, String nombre, boolean dueno, String correo, Carrito carrito){
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.nombre = nombre;
        this.dueno = dueno;
        this.correo = correo;
        this.carrito = carrito;
    }
    
    public void anadirCarrito (Producto p){
        this.carrito.anadirCarrito(p);
    }

    public void eliminarCarrito(int productoCarrito){
        this.carrito.eliminarCarrito(productoCarrito);
    }

    public boolean carritoVacio(){
        return this.carrito.carritoVacio();
    }

    public void mostrarCarrito(){
        this.carrito.mostrarCarrito();
    }
}
