public class Botas extends Producto {
  private int talla;
  private String modelo;
  private String marca;
  private String color;

  Botas(String id, double precio, boolean activo, int stock, int udsvendidas, int talla, String modelo, String marca, String color) {
    super(id, precio, activo, stock, udsvendidas);
    this.talla = talla;
    this.modelo = modelo;
    this.marca = marca;
    this.color = color;
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

  public String mostrar() {
    String s;

    s = "\nProducto: Botas\n" +
        "Id:" + this.id + "\n" +
        "Marca:" + this.marca + "\n" +
        "Modelo: " + this.modelo + "\n" +
        "Talla:" + this.talla + "\n" +
        "Color: " + this.color + "\n" +
        "Precio: " + this.precio + "\n";
    s = s + super.mostrar();
    return s;
  }
}