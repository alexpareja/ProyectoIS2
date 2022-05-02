package model;

import BBDD.DTOInventario;

public abstract class Camiseta extends Producto {
	
	protected String talla;
	protected String nombre;
	protected int dorsal;
 
	public Camiseta(String id, double precio, boolean activo, int stock, int udsvendidas, int reservados) {
		super(id,precio, activo, stock, udsvendidas, reservados);
	}

	public String[] mostrar() {
		String s[] = {"Nombre: " + this.nombre, "Dorsales:" + this.dorsal, "Talla: " + this.talla, "Precio: " + this.precio};
		return s;
	}

	public String mostrarEnCarrito() {
		String s;
		s = "Nombre:	 " + this.nombre + 
				"Dorsales:		" + this.dorsal + 
				"Talla: 	" + this.talla + 
				"Precio:	 " + this.precio;
		return s;
	}

	public String[] mostrarEnInv() {
		String info = "Camiseta" + "Nombre: " + this.nombre  +
				"Dorsales:" + this.dorsal +
				"Talla: " + this.talla;
		String s[] = {this.id,
				info,
				Integer.toString(this.stock),
				Double.toString(this.precio) };
		return s;
	}	
  
	protected DTOInventario convierteDTO() {
		return new DTOInventario(id,precio,activo,stock,udsvendidas,reservados,talla,nombre,dorsal);
	}
  
	public String getTalla() {return talla;}
	public String getNombre() {return nombre;}
	public int getNumero() {return dorsal;}
	
}