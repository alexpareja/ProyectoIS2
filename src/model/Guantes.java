package model;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class Guantes extends Producto {
  private String talla;
  private String modelo;
  private String marca;
  private String color;
  private int adherencia;
 
  public Guantes(String id, double precio, boolean activo, int stock, int udsvendidas, int reservados, String talla, String modelo, String marca, String color, int adherencia) {
    super("Guantes", precio, activo, stock, udsvendidas, reservados);
    this.talla = talla;
	this.modelo = modelo;
  	this.marca = marca;
  	this.color = color;
  	this.adherencia = adherencia;
  }

  public String getTalla() {
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

  public int getAdherencia() {
	return adherencia;
  }

  public String mostrar() {
	    String s;
	    s = "\nProducto: Guantes\n" +
	        "Id:" + this.id + "\n" +
	        "Talla: " + this.talla + "\n" +
	        "Precio: " + this.precio + "\n" +
	        "Modelo: " + this.modelo + "\n" +
	        "Marca: " + this.marca + "\n" +
	        "Color: " + this.color + "\n" +
	        "Adherencia: " + this.adherencia + "\n";
	    return s;
	  }
  
  @Override
  public String mostrarEnInv() {
	String s = "Id:" + this.id + "\n" +
	        "Marca: " + this.marca + "\n" +
	        "Modelo: " + this.modelo + "\n" +
	        "Talla: " + this.talla + "\n" +
	        "Color: " + this.color + "\n" +
	        "Adherencia: " + this.adherencia + "\n" +
	        "Unidades totales: " + this.stock + "\n" +
	        "Precio: " + this.precio + "\n";
	return s;
  }

  @Override
  public String mostrarEnCarrito() {
	String s = "\nProducto: Guantes\n" +
			"Marca: " + this.marca + "\n" +
	        "Modelo: " + this.modelo + "\n" +
	        "Talla: " + this.talla + "\n" +
	        "Color: " + this.color + "\n" +
	        "Adherencia: " + this.adherencia + "\n" +
	        "Precio: " + this.precio + "\n";
	return s;
  }
  
  public Element convierteXML(Document doc) {
		 Element e= doc.createElement("guantes");
		 
		 Element mod=doc.createElement("modelo");
		 mod.setTextContent(this.modelo);
		 e.appendChild(mod);
		 
		 Element mar=doc.createElement("marca");
		 mar.setTextContent(this.marca);
		 e.appendChild(mar);
		 
		 Element col=doc.createElement("color");
		 col.setTextContent(this.color);
		 e.appendChild(col);
		 
		 Element ad=doc.createElement("adherencia");
		 ad.setTextContent(String.valueOf(this.adherencia));
		 e.appendChild(ad);
		 
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
