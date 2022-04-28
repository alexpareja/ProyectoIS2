package controller;

import model.Carrito;
import model.Inventario;
import model.InventarioObserver;
import model.Sesion;
import model.Tienda;

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
	
	public boolean iniciarSesion(String n, String p) {
		
		return s.iniciaSesion(n, p);
	}
	
	public void registrarse(String n, String p,String correo) {
		
		this.s.registrarse(n, p,correo);
	}
	
	public void registrarseVendedor(String n, String p,String correo) {
		
		this.s.registrarseVendedor(n, p, correo);
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
	
	
	
}
