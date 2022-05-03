package controller;

import model.Carrito;
import model.Inventario;
import model.InventarioObserver;
import model.Sesion;
import model.Tienda;
import model.UsuariosObserver;

public class Controller {

	private Inventario i;
	private Tienda t;
	private Sesion s;

	private Carrito c;
	
	public Controller(Inventario inv, Carrito carr, Tienda tiend) {
		this.i=inv;
		this.c = carr;
		this.t = tiend;
		this.s=new Sesion();
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

	public Sesion getS() {
		return s;
	}

	public void addObserverUsuario(UsuariosObserver o) {
		s.addObserver(o);
		
	}	
	
}
