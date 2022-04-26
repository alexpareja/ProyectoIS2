package model;

import BBDD.DTOInventario;

public abstract class Pantalon extends Producto {
  protected String talla;
  protected int dorsal;

  public Pantalon(String id, double precio, boolean activo, int stock, int udsvendidas, int reservados, String talla, int dorsal){
    super(id, precio, activo, stock, udsvendidas, reservados);
  }

  public String getTalla() {
    return talla;
  }
  
  public int getDorsal() {
    return dorsal;
  }

  public String[] mostrar() {
	String s[] = { "Dorsal:" + this.dorsal, "Talla: " + this.talla, "Precio: " + this.precio};
    return s;
  }

  
  public  String mostrarEnCarrito() {
    String s;
      s = "Dorsales:" + this.dorsal + "\n" +
          "Talla: " + this.talla + "\n" +
          "Precio: " + this.precio + "\n";
    return s;
  }

    public String mostrarEnInv(){
    String s = "Id:" + this.id + "\n" +
        "Dorsales:" + this.dorsal + "\n" +
        "Talla: " + this.talla + "\n" +
        "Unidades totales: " + this.stock + "\n" +
        "Precio: " + this.precio + "\n";
    return s;
  }
    
    protected DTOInventario convierteDTO() {
		return new DTOInventario(id,precio,activo,stock,udsvendidas,reservados,talla,dorsal);
	}
}