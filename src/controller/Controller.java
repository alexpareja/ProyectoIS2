package controller;

import model.Carrito;
import model.Inventario;
import model.InventarioObserver;
import model.Tienda;

public class Controller {

	private Inventario i;
	private Tienda t;


	private Carrito c;
	
	public Controller(Inventario inv, Carrito carr, Tienda tiend) {
		this.i=inv;
		this.c = carr;
		this.t = tiend;
	}
	
	
	public void addObserver(InventarioObserver o) {
		i.addObserver(o);
		t.addObserver(o);
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


	public Tienda getT() {
		return t;
	}
	
}
