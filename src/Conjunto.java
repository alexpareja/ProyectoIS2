public abstract class Conjunto extends Producto {
  private String talla;
  private String nombre;
  private int dorsal;
  

  Conjunto(String id, double precio, boolean activo, int stock, int udsvendidas, String talla, String nombre, int dorsal) {
    super("Conjunto", precio, activo, stock, udsvendidas);
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

    s = "\nProducto: Conjunto\n" +
        "Id:" + this.id + "\n" +
        "Nombre: " + this.nombre + "\n" +
        "Dorsales:" + this.dorsal + "\n" +
        "Talla: " + this.talla + "\n" +
        "Precio: " + this.precio + "\n";
    return s;
  }

  public String mostrarEnInv(){
    String s = "Id:" + this.id + "\n" +
        "Nombre: " + this.nombre + "\n" +
        "Dorsales:" + this.dorsal + "\n" +
        "Talla: " + this.talla + "\n" +
        "Unidades totales: " + this.stock + "\n" +
        "Precio: " + this.precio + "\n";
    return s;
  }

  public String mostrarEnCarrito() {
    String s;
    s = "\nProducto: Conjunto\n" +
        "Nombre: " + this.nombre + "\n" +
        "Dorsales:" + this.dorsal + "\n" +
        "Talla: " + this.talla + "\n" +
        "Precio: " + this.precio + "\n";
    return s;
  }
}