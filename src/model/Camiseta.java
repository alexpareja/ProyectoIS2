package model;

import BBDD.DTOInventario;

public abstract class Camiseta extends Producto {

	protected String talla;
	protected String nombre;
	protected int dorsal;

	public Camiseta(String id, double precio, boolean activo, int stock, int udsvendidas, int reservados) {
		super(id, precio, activo, stock, udsvendidas, reservados);
	}
//Se pasan los datos necesarios para mostrar Camiseta en la tienda
	public String[] mostrar() {
		String s[] = { "Nombre: " + this.nombre, "Dorsales:" + this.dorsal, "Talla: " + this.talla,
				"Precio: " + this.precio };
		return s;
	}
//Se pasan los datos necesarios para mostrar Camiseta en el carrito
	public String mostrarEnCarrito() {
		String s;
		s = "Nombre: " + this.nombre + " Dorsal: " + this.dorsal + " Talla: " + this.talla;
		return s;
	}
//Se pasan los datos necesarios para mostrar Camiseta en el inventario
	public String[] mostrarEnInv() {
		String info = "Nombre: " + this.nombre + "Dorsales:" + this.dorsal + "Talla: " + this.talla;
		String s[] = { this.id, info, Integer.toString(this.stock), Double.toString(this.precio) };
		return s;
	}

	protected DTOInventario convierteDTO() {
		return new DTOInventario(id, precio, activo, stock, udsvendidas, reservados, talla, nombre, dorsal);
	}

	public String getTalla() {
		return talla;
	}

	public String getNombre() {
		return nombre;
	}

	public int getNumero() {
		return dorsal;
	}

}