package model;

public class Compra {
	private String pago;
	private Carrito carrito;
	private String id;
	private String cliente;
	private String direccion;
	
	public Compra(String pago, Carrito carrito, int id, String cliente, String direccion) {
		this.pago = pago;
		this.carrito = carrito;
		this.id = "Compra" + id;
		this.cliente = cliente;
		this.direccion = direccion;
	}
	
	public String getPago() {return pago;}
	public Carrito getCarrito() {return carrito;}
	public String getId() {return id;}
	public String getCliente() {return cliente;}
	public String getDireccion() {return direccion;}

}
