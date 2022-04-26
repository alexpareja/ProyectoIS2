package model;

import BBDD.DTOInventario;

public class Guantes extends Producto {
  private String talla;
  private String modelo;
  private String marca;
  private String color;
  private int adherencia;
 
  public Guantes(double precio, boolean activo, int stock, int udsvendidas, int reservados, String talla, String modelo, String marca, String color, int adherencia) {
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

  public String[] mostrar() {
		String s[] = { "Talla: " + this.talla, "Modelo: " + this.modelo, "Marca: " + this.marca,
				"Color: " + this.color, "Adherencia: " + this.adherencia, "Precio: " + this.precio};

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
  protected DTOInventario convierteDTO() {
		return new DTOInventario(id,precio,activo,stock,udsvendidas,reservados,talla,modelo,marca,color,adherencia);
	}
}
