package model;

import javax.swing.ImageIcon;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

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

  public String getId() {
    return id;
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

  public void setReservados(int n){
	reservados = n;
  }
  
  public void setStock(int n){
    stock = n;
  }
  
  public ImageIcon getFoto() {
	return foto;
}

public void setPrecio(double precio) {
	  if (precio < 0) throw new IllegalArgumentException("Precio negativo");
	  this.precio = precio;
  }
  
  public abstract String[] mostrar();

  public abstract String mostrarEnInv();

  public abstract String mostrarEnCarrito();
  
  public abstract Element convierteXML(Document doc);
}