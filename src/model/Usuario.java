package model;

public class Usuario {

	private String usuario;
	private String contrasena;
	private boolean dueno;
	private String correo;
	private Carrito carrito;

	public Usuario(String usuario, String contrasena, boolean d, String correo) {
		this.usuario = usuario;
		this.contrasena = contrasena;
		this.dueno = d;
		this.correo = correo;
		if (d)
			carrito = new Carrito();
	}

	public boolean esDueno() {
		return dueno;
	}

	public void anadirCarrito(Producto p) {
		this.carrito.anadirCarrito(p);
	}

	public void eliminarCarrito(int productoCarrito) {
		this.carrito.eliminarCarrito(productoCarrito);
	}

	public boolean carritoVacio() {
		return this.carrito.carritoVacio();
	}

	public String getCorreo() {
		return correo;
	}

	public String getUsuario() {
		return usuario;
	}

	public String getContrasena() {
		return contrasena;
	}

}
