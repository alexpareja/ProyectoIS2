public class CamisetaVisitante extends Camiseta {
 public static final String id="CamVisitante";

 public CamisetaVisitante(double precio, boolean activo, int stock, int udsvendidas, int reservados, String talla, String nombre, int dorsal) {
    super(id,precio, activo, stock, udsvendidas, reservados);
    this.talla = talla;
    this.nombre = nombre;
    this.dorsal = dorsal;
  }

  public  String mostrar() {
    String s;

    s = "\nProducto: Camiseta Visitante\n" +
       super.mostrar();
    return s;
  }

    public  String mostrarEnCarrito() {
    String s;

    s = "\nProducto: Camiseta Visitante\n" +
       super.mostrarEnCarrito();
    return s;
  }
  
}