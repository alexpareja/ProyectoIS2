public class ConjuntoVisitante extends Conjunto {
 public static final String id="ConVisit";

 public ConjuntoVisitante(double precio, boolean activo, int stock, int udsvendidas, String talla, String nombre, int dorsal) {
    super(id,precio, activo, stock, udsvendidas);
    this.talla = talla;
    this.nombre = nombre;
    this.dorsal = dorsal;
  }

  public  String mostrar() {
    String s;

    s = "\nProducto: Conjunto Local\n" +
       super.mostrar();
    return s;
  }

    public  String mostrarEnCarrito() {
    String s;

    s = "\nProducto: Conjunto Local\n" +
       super.mostrarEnCarrito();
    return s;
  }


}