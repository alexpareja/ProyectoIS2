package model;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class PantalonCorto extends Pantalon {
  public static final String id="PantCorto";

  public PantalonCorto(double precio, boolean activo, int stock, int udsvendidas, int reservados, String talla, int dorsal){
    super(id, precio, activo, stock, udsvendidas, reservados, talla, dorsal);
    
    if (talla == "" || talla == null) throw new IllegalArgumentException("[ERROR] Pantalon: talla no puede ser vacio");
    else 
      this.talla = talla;
    
    if (dorsal < 0) throw new IllegalArgumentException("[ERROR] Pantalon: dorsal no puede ser negativo");
    else 
      this.dorsal = dorsal;
  }

  public  String[] mostrar() {
	    String s[]	= super.mostrar();
	    
	    return s;
	  }

  public  String mostrarEnCarrito() {
    String s;
  
    s = "\nProducto: Pantalon Corto\n" +
       super.mostrarEnCarrito();
      
    return s;
  }
  
  public Element convierteXML(Document doc) {
	     
  	Element e=super.convierteXML(doc);
  	e.setAttribute("id", "PantCorto");
  	return e;
  }
}
