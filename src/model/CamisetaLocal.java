package model;

import javax.swing.ImageIcon;


import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class CamisetaLocal extends Camiseta {
 public static final String id="CamLocal";

 public CamisetaLocal(double precio, boolean activo, int stock, int udsvendidas, int reservados, String talla, String nombre, int dorsal) {
    super(id,precio, activo, stock, udsvendidas, reservados);
    this.talla = talla;
    this.nombre = nombre;
    this.dorsal = dorsal;
    this.foto= new ImageIcon( "resources/icons/cami1.png");
  }

  public  String mostrar() {
    String s;

    s = "\nProducto: Camiseta Local\n" +
       super.mostrar();
    return s;
  }

    public  String mostrarEnCarrito() {
    String s;

    s = "\nProducto: Camiseta Local\n" +
       super.mostrarEnCarrito();
    return s;
  }
    
    
    public Element convierteXML(Document doc) {
    	     
    	Element e=super.convierteXML(doc);
    	e.setAttribute("id", "CamLocal");
    	return e;
    }

}