package model;

import javax.swing.ImageIcon;

public class ConjuntoVisitante extends Conjunto {
 public static final String id="Conjunto Visitante";

 public ConjuntoVisitante(double precio, boolean activo, int stock, int udsvendidas, int reservados, String talla, String nombre, int dorsal) {
    super(id,precio, activo, stock, udsvendidas, reservados);
    this.talla = talla;
    this.nombre = nombre;
    this.dorsal = dorsal;
    this.foto= new ImageIcon( "resources/icons/conjuntoVisitante.png");
  }

 public  String[] mostrar() {
	    String s[]	= super.mostrar();
	    
	    return s;
	  }

    public  String mostrarEnCarrito() {
    String s;

    s = "\nProducto: Conjunto Local\n" +
       super.mostrarEnCarrito();
    return s;
  }
    
}