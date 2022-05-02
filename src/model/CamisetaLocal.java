package model;

import javax.swing.ImageIcon;

public class CamisetaLocal extends Camiseta {
	
	public static final String id = "Camiseta Local";

	public CamisetaLocal(double precio, boolean activo, int stock, int udsvendidas, int reservados, String talla, String nombre, int dorsal) {
		super(id,precio, activo, stock, udsvendidas, reservados);
		this.talla = talla;
		this.nombre = nombre;
		this.dorsal = dorsal;
		this.foto= new ImageIcon( "resources/icons/camisetalocal.png");
	}

	public  String[] mostrar() {
		super.mostrar()[0] = "Camiseta Local"; 
		return super.mostrar();
	}

    public  String mostrarEnCarrito() {
    	String s;
    	s = "\nProducto: Camiseta Local\n" + super.mostrarEnCarrito();
    	return s;
    }

}