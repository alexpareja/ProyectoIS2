package controller;

import model.Carrito;
import model.Inventario;
import model.InventarioObserver;

public class Controller {

	private Inventario i;



	private Carrito c;
	
	public Controller(Inventario inv, Carrito carr) {
		this.i=inv;
		this.c = carr;
	}
	
	
	public void addObserver(InventarioObserver o) {
		i.addObserver(o);
	}
	
	public void actualizarTienda(InventarioObserver o) {
		i.actualizarTienda();
	}


	public Carrito getC() {
		return c;
	}
	
	public Inventario getI() {
		return i;
	}
	
}
