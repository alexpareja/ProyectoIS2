public abstract class Producto {
  protected String id;
  protected double precio;
  protected boolean activo;
  protected int stock;
  protected int udsvendidas;

 public Producto(String id, double precio, boolean activo, int stock, int udsvendidas) {
    this.id = id;
    this.precio = precio;
    this.activo = activo;
    this.stock = stock;
    this.udsvendidas = udsvendidas;
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

  public void setStock(int n){
    this.stock = stock + n;
  }
  
  public void setPrecio(double precio) {
	  if (precio < 0) throw new IllegalArgumentException("Precio negativo");
	  this.precio = precio;
  }

  public abstract String mostrar();

  public abstract String mostrarEnInv();

  public abstract String mostrarEnCarrito();
}