
public class Guantes extends Producto {

  private String talla;
  private String modelo;
  private String marca;
  private String color;
  private int adherencia;
 
  Guantes(String id, double precio, boolean activo, int stock, int udsvendidas, String talla, String modelo, String marca, String color, int adherencia) {
    super("guantes", precio, activo, stock, udsvendidas);
    this.talla = talla;
	this.modelo = modelo;
  	this.marca = marca;
  	this.color = color;
  	this.adherencia = adherencia;
  }

  public String mostrar() {
    String s;
    s = "\nProducto: Guantes\n" +
        "Id:" + this.id + "\n" +
        "Talla: " + this.talla + "\n" +
        "Precio: " + this.precio + "\n" +
        "Modelo: " + this.modelo + "\n" +
        "Marca: " + this.marca + "\n" +
        "Color: " + this.color + "\n" +
        "Adherencia: " + this.adherencia + "\n";
    s += super.mostrar();
    return s;
  }

  public String getTalla() {
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

  public int getAdherencia() {
	return adherencia;
  }
}