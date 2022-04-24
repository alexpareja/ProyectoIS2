package model;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public abstract class Pantalon extends Producto {
  protected String talla;
  protected int dorsal;

  public Pantalon(String id, double precio, boolean activo, int stock, int udsvendidas, int reservados, String talla, int dorsal){
    super(id, precio, activo, stock, udsvendidas, reservados);
  }

  public String getTalla() {
    return talla;
  }
  
  public int getDorsal() {
    return dorsal;
  }

  public String mostrar() {
    String s;

    s = "Id:" + this.id + "\n" +
        "Dorsales:" + this.dorsal + "\n" +
        "Talla: " + this.talla + "\n" +
        "Precio: " + this.precio + "\n";
    return s;
  }

  
  public  String mostrarEnCarrito() {
    String s;
      s = "Dorsales:" + this.dorsal + "\n" +
          "Talla: " + this.talla + "\n" +
          "Precio: " + this.precio + "\n";
    return s;
  }

    public String mostrarEnInv(){
    String s = "Id:" + this.id + "\n" +
        "Dorsales:" + this.dorsal + "\n" +
        "Talla: " + this.talla + "\n" +
        "Unidades totales: " + this.stock + "\n" +
        "Precio: " + this.precio + "\n";
    return s;
  }
    
    public Element convierteXML(Document doc) {
   	 Element e= doc.createElement("pantalon");
   	 
   	 Element dor=doc.createElement("dorsal");
   	 dor.setTextContent(String.valueOf(this.dorsal));
   	 e.appendChild(dor);
   	 
   	 Element tal=doc.createElement("talla");
   	 tal.setTextContent(this.talla);
   	 e.appendChild(tal);
   	 
   	 Element prec=doc.createElement("precio");
   	 prec.setTextContent(String.valueOf(this.precio));
   	 e.appendChild(prec);
   	 
   	 Element pub=doc.createElement("publicado");
   	 String act;
   	 if(activo) {act="1";}
   	 else {act="0";}
   	 pub.setTextContent(act);
   	 e.appendChild(pub);
   	 
   	 Element sto=doc.createElement("stock");
   	 sto.setTextContent(String.valueOf(this.stock));
   	 e.appendChild(sto);
   	 
   	 Element udsVen=doc.createElement("udsVendidas");
   	 udsVen.setTextContent(String.valueOf(this.udsvendidas));
   	 e.appendChild(udsVen);
   	 
   	 Element udsRes=doc.createElement("udsReservadas");
   	 udsRes.setTextContent(String.valueOf(this.reservados));
   	 e.appendChild(udsRes);
   	 
   	  return e;
     }
}