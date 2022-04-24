package model;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class ConjuntoVisitante extends Conjunto {
 public static final String id="ConVisit";

 public ConjuntoVisitante(double precio, boolean activo, int stock, int udsvendidas, int reservados, String talla, String nombre, int dorsal) {
    super(id,precio, activo, stock, udsvendidas, reservados);
    this.talla = talla;
    this.nombre = nombre;
    this.dorsal = dorsal;
  }

  public  String mostrar() {
    String s;

    s = "\nProducto: Conjunto Local\n" +
       super.mostrar();
    return s;
  }

    public  String mostrarEnCarrito() {
    String s;

    s = "\nProducto: Conjunto Local\n" +
       super.mostrarEnCarrito();
    return s;
  }
    
    public Element convierteXML(Document doc) {
	     
    	Element e=super.convierteXML(doc);
    	e.setAttribute("id", "ConVisitante");
    	return e;
    }

}