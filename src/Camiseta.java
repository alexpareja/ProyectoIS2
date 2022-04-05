
//hola


public abstract class Camiseta extends Producto {
  protected String talla;
  protected String nombre;
  protected int dorsal;
 
  public Camiseta(String id, double precio, boolean activo, int stock, int udsvendidas) {
    super(id,precio, activo, stock, udsvendidas);
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

    s = "Id:" + this.id + "\n" +
        "Nombre: " + this.nombre + "\n" +
        "Dorsales:" + this.dorsal + "\n" +
        "Talla: " + this.talla + "\n" +
        "Precio: " + this.precio + "\n";
    return s;
  }

  public String mostrarEnCarrito() {
    String s;

    s = "Nombre: " + this.nombre + "\n" +
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
}