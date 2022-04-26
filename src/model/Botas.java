package model;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class Botas extends Producto {
  private int talla;
  private String modelo;
  private String marca;
  private String color;

  public Botas(String id, double precio, boolean activo, int stock, int udsvendidas, int reservados, int talla, String modelo, String marca, String color) {
    super("Botas", precio, activo, stock, udsvendidas, reservados);
    this.talla = talla;
    this.modelo = modelo;
    this.marca = marca;
    this.color = color;
  }

  public int getTalla() {
    return talla;
  }

  public String getModelo() {
    return modelo;
  }

  public String getMarca() {
    return marca;
  }

  public String getColor() {
    return color;
  }

  public String[] mostrar() {
	String s[] = {"Marca: " + this.marca, "Modelo:" + this.modelo, "Talla: " + this.talla, "Color: " + this.color, "Precio: " + this.precio};
    return s;
  }

  public String mostrarEnInv(){
    String s = "Id:" + this.id + "\n" +
        "Marca:" + this.marca + "\n" +
        "Modelo: " + this.modelo + "\n" +
        "Talla:" + this.talla + "\n" +
        "Color: " + this.color + "\n" +
        "Unidades totales: " + this.stock + "\n" +
        "Precio: " + this.precio + "\n";
    return s;
  }

  
   public  String mostrarEnCarrito() {
    String s;

    s = "\nProducto: Botas\n" +
        "Marca:" + this.marca + "\n" +
        "Modelo: " + this.modelo + "\n" +
        "Talla:" + this.talla + "\n" +
        "Color: " + this.color + "\n" +
        "Precio: " + this.precio + "\n";
    return s;
  }
   
   public Element convierteXML(Document doc) {
		 Element e= doc.createElement("botas");
		 
		 Element mod=doc.createElement("modelo");
		 mod.setTextContent(this.modelo);
		 e.appendChild(mod);
		 
		 Element mar=doc.createElement("marca");
		 mar.setTextContent(this.marca);
		 e.appendChild(mar);
		 
		 Element col=doc.createElement("color");
		 col.setTextContent(this.color);
		 e.appendChild(col);
		 
		 Element tal=doc.createElement("talla");
		 tal.setTextContent(String.valueOf(this.talla));
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