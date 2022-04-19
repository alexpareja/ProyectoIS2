package model;

public class Usuario {
    private String usuario;
    private String contraseña;
    private String nombre;
    private boolean dueño;
    private String correo;
    private Carrito carrito;

    public Usuario(String usuario, String contraseña, String nombre, boolean dueño, String correo, Carrito carrito){
        this.usuario = usuario;
        this.contraseña = contraseña;
        this.nombre = nombre;
        this.dueño = dueño;
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
