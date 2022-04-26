package model;

import javax.swing.ImageIcon;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class CamisetaVisitante extends Camiseta {
 public static final String id="CamVisitante";

 public CamisetaVisitante(double precio, boolean activo, int stock, int udsvendidas, int reservados, String talla, String nombre, int dorsal) {
    super(id,precio, activo, stock, udsvendidas, reservados);
    this.talla = talla;
    this.nombre = nombre;
    this.dorsal = dorsal;
    this.foto= new ImageIcon( "resources/icons/camivisit.png");
  }

 public  String[] mostrar() {
	    String s[]	= super.mostrar();
	    
	    return s;
	  }

    public  String mostrarEnCarrito() {
    String s;

    s = "\nProducto: Camiseta Visitante\n" +
       super.mostrarEnCarrito();
    return s;
  }
  
    public Element convierteXML(Document doc) {
	     
    	Element e=super.convierteXML(doc);
    	e.setAttribute("id", "CamVisitante");
    	return e;
    }
}