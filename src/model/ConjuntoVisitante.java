package model;

import javax.swing.ImageIcon;

public class ConjuntoVisitante extends Conjunto {
	
	public static final String id = "ConVisit";

	public ConjuntoVisitante(double precio, boolean activo, int stock, int udsvendidas, int reservados, String talla, String nombre, int dorsal) {
		super(id,precio, activo, stock, udsvendidas, reservados);
		this.talla = talla;
		this.nombre = nombre;
		this.dorsal = dorsal;
		this.foto= new ImageIcon( "resources/icons/conjuntoVisitante.png");
	}

	public  String[] mostrar() {
	    return super.mostrar();
	}

    public  String mostrarEnCarrito() {
    	String s;
    	s = "\nProducto: Conjunto Local\n" + super.mostrarEnCarrito();
    	return s;
    }
    
}