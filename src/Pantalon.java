public abstract class Pantalon extends Producto {
  protected String talla;
  protected int dorsal;

  public Pantalon(String id, double precio, boolean activo, int stock, int udsvendidas, String talla, int dorsal){
    super(id, precio, activo, stock, udsvendidas);
  }

  public String getTalla() {
    return talla;
  }
  
  public int getDorsal() {
    return dorsal;
  }

  public String mostrar() {
    String s;

    s = "Id:" + this.id + "\n" +
        "Dorsales:" + this.dorsal + "\n" +
        "Talla: " + this.talla + "\n" +
        "Precio: " + this.precio + "\n";
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
}