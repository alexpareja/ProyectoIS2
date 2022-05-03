package model;

import javax.swing.ImageIcon;

import BBDD.DTOInventario;

public abstract class Producto {
	protected String id;
	protected ImageIcon foto;
	protected double precio;
	protected boolean activo;
	protected int stock;
	protected int udsvendidas;
	protected int reservados;

	public Producto(String id, double precio, boolean activo, int stock, int udsvendidas, int reservados) {
		this.id = id;
		this.precio = precio;
		this.activo = activo;
		this.stock = stock;
		this.udsvendidas = udsvendidas;
		this.reservados = reservados;
	}

	public void disminuirStock() {
		stock--;
	}

	public String getId() {
		return id;
	}

	public int getUdvendidas() {
		return this.udsvendidas;
	}

	public boolean getActivo() {
		return activo;
	}

	public double getPrecio() {
		return precio;
	}

	public int getStock() {
		return stock;
	}

	public int getReservados() {
		return reservados;
	}

	public ImageIcon getFoto() {
		return foto;
	}

	public void setReservados(int n) {
		reservados = n;
	}

	public void setStock(int n) {
		stock = n;
	}
//cambiar precio producto
	public void setPrecio(double precio) {
		if (precio < 0)
			throw new IllegalArgumentException("Precio negativo");
		this.precio = precio;
	}

	public abstract String[] mostrar();

	public abstract String[] mostrarEnInv();

	public abstract String mostrarEnCarrito();

	protected abstract DTOInventario convierteDTO();

}