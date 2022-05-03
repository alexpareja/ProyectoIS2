package model;

import BBDD.DTOInventario;

public abstract class Pantalon extends Producto {

	protected String talla;
	protected int dorsal;

	public Pantalon(String id, double precio, boolean activo, int stock, int udsvendidas, int reservados, String talla,
			int dorsal) {
		super(id, precio, activo, stock, udsvendidas, reservados);
	}
	//Se pasan los datos necesarios para mostrar Pantalon en la tienda
	public String[] mostrar() {
		String s[] = { "Dorsal:" + this.dorsal, "Talla: " + this.talla, "Precio: " + this.precio };
		return s;
	}
	//Se pasan los datos necesarios para mostrar Pantalon en el Carrito
	public String mostrarEnCarrito() {
		String s;
		s = "Dorsal:" + this.dorsal + "\n" + " Talla: " + this.talla + "\n";	
		return s;
	}
	//Se pasan los datos necesarios para mostrar Pantalon en el inventario
	public String[] mostrarEnInv() {
		String info = "Dorsal:" + this.dorsal + " Talla: " + this.talla;
		String s[] = { this.id, info, Integer.toString(this.stock), Double.toString(this.precio) };
		return s;
	}

	protected DTOInventario convierteDTO() {
		return new DTOInventario(id, precio, activo, stock, udsvendidas, reservados, talla, dorsal);
	}

	public String getTalla() {
		return talla;
	}

	public int getDorsal() {
		return dorsal;
	}

}