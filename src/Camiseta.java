public class Camiseta extends Producto {
  private String talla;
  private String nombre;
  private int dorsal;

  Camiseta(String id, double precio, boolean activo, int stock, int udsvendidas, String talla, String nombre, int dorsal) {
    super(id,precio, activo, stock, udsvendidas);
    this.talla = talla;
    this.nombre = nombre;
    this.dorsal = dorsal;
  }

  public String getTalla() {
    return talla;
  }

  public String getNombre() {
    return nombre;
  }

  public int getNumero() {
    return dorsal;
  }

  public String mostrar() {
    String s;

    s = "\nProducto: Camiseta\n" +
        "Id:" + this.id + "\n" +
        "Nombre: " + this.nombre + "\n" +
        "Dorsales:" + this.dorsal + "\n" +
        "Talla: " + this.talla + "\n" +
        "Precio: " + this.precio + "\n";
    s = s + super.mostrar();
    return s;
  }
}