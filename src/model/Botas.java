package model;

import javax.swing.ImageIcon;

import BBDD.DTOInventario;

public class Botas extends Producto {

	private int talla;
	private String modelo;
	private String marca;
	private String color;
	
	public Botas(double precio, boolean activo, int stock, int udsvendidas, int reservados, int talla, String modelo,
			String marca, String color) {
		super("Botas", precio, activo, stock, udsvendidas, reservados);
		this.talla = talla;
		this.modelo = modelo;
		this.marca = marca;
		this.color = color;
		this.foto = new ImageIcon("resources/icons/botas.png");
	}
//Se pasan los datos necesarios para mostrar Botas en la tienda
	public String[] mostrar() {
		String s[] = { "Marca: " + this.marca, "Modelo:" + this.modelo, "Talla: " + this.talla, "Color: " + this.color,
				"Precio: " + this.precio };
		return s;
	}
//Se pasan los datos necesarios para mostrar Botas en el inventario
	public String[] mostrarEnInv() {
		String info = "Marca:" + this.marca + "Modelo: " + this.modelo + "Talla:" + this.talla + "Color: " + this.color;
		String s[] = { this.id, info, Integer.toString(this.stock), Double.toString(this.precio) };
		return s;
	}
//Se pasan los datos necesarios para mostrar Botas en el carrito
	public String mostrarEnCarrito() {
		String s;
		s = "Marca: " + this.marca + " " + " Modelo: " + this.modelo + " " + " Talla:" + this.talla + " " + " Color: "
				+ this.color;
		return s;
	}

	@Override
	protected DTOInventario convierteDTO() {
		return new DTOInventario(id, precio, activo, stock, udsvendidas, reservados, talla, modelo, marca, color);
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

}