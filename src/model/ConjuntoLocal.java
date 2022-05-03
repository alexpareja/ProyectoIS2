package model;

import javax.swing.ImageIcon;

public class ConjuntoLocal extends Conjunto {

	public static final String id = "ConLocal";

	public ConjuntoLocal(double precio, boolean activo, int stock, int udsvendidas, int reservados, String talla,
			String nombre, int dorsal) {
		super(id, precio, activo, stock, udsvendidas, reservados);
		this.talla = talla;
		this.nombre = nombre;
		this.dorsal = dorsal;
		this.foto = new ImageIcon("resources/icons/conjuntoLocal.png");
	}

}