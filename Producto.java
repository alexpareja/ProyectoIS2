
public class Producto {
  protected int id;
  protected double precio;
  protected boolean activo;
  protected int stock;
  protected int udsvendidas;

  Producto(int id, double precio, boolean activo, int stock, int udsvendidas) {
    this.id = id;
    this.precio = precio;
    this.activo = activo;
    this.stock = stock;
    this.udsvendidas = udsvendidas;
  }

  public int getId() {
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

  public String mostrar() {
    String s;
      s = "Unidades en inventario: " + stock;
      if(!activo)
      s = s  +"\n" + "No esta a la venta";
    
    return s;
  }

  public String mostrarEnInv() {
    String s =  this.mostrar()+ "\nUnidades vendidas: " + udsvendidas;
    
       
    return s;
  }
}