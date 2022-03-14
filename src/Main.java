import java.util.ArrayList;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Inventario inventario = new Inventario();
    Producto p1 = new Camiseta(1, 59.99, true, 10, 2, "XL", "Mbappe", 7);
    Producto p2 = new Camiseta(1, 39.99, false, 200, 3, "L", "Benzema", 9);
    Producto p3 = new Camiseta(1, 99.99, true, 0, 4, "M", "Griezmann", 8);
    Producto p4 = new Camiseta(1, 399.99, true, 11, 5, "L", "Eraso", 17);
    Producto p5 = new Camiseta(1, 149.99, true, 16, 6, "S", "Carrasco", 21);
    Producto p6 = new Camiseta(1, 69.99, true, 21, 7, "XS", "Pedri", 16);
    Producto p7 = new Camiseta(1, 29.99, true, 12, 8, "XXS", "Gavi", 30);
    Producto p8 = new Camiseta(1, 19.99, true, 17, 9, "XL", "Pau Torres", 4);
    Producto p9 = new Botas(2, 54.99, true, 8, 1, 42, "Predator", "Adidas", "Blanco");
    Producto p10 = new Botas(2, 54.99, true, 8, 2, 43, "Predator", "Adidas", "Blanco");
    Producto p11 = new Botas(2, 54.99, true, 8, 3, 44, "Predator", "Adidas", "Blanco");

    ArrayList<Producto> productos = new ArrayList<Producto>();
    productos.add(p1);
    productos.add(p2);
    productos.add(p3);
    productos.add(p4);
    productos.add(p5);
    productos.add(p6);
    productos.add(p7);
    productos.add(p8);
    productos.add(p9);

    inventario.add(productos);
    inventario.add(p10);
    inventario.add(p11);

    inventario.eliminar(p1, productos);
    inventario.reabastecer(p2, 3);

    Tienda tienda = new Tienda(productos, 100, 1);

    tienda.mostrarTienda();
    char desp = 'T';
    Scanner lectura = new Scanner(System.in);

    while (desp != 'S') {
      System.out.println("I para pagina anterior, D para siguiente pagina\nN para ver inventario\nS para salir");

      String d = lectura.next();
      desp = d.charAt(0);
      if (desp == 'I') {
        tienda.desplazaIzq();
      } else if (desp == 'D') {
        tienda.desplazaDer();
      } else if (desp == 'N') {
        inventario.mostrarInventario();
      }
    }

  }
}