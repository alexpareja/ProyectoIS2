import java.util.ArrayList;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Inventario inventario = new Inventario();
    Producto p1 = new CamisetaLocal( 59.99, true, 10, 2, 0, "XL", "Mbappe", 7);
    Producto p2 = new CamisetaLocal( 39.99, false, 200, 3, 0, "L", "Benzema", 9);
    Producto p3 = new CamisetaLocal( 99.99, true, 0, 4, 1, "M", "Griezmann", 8);
    Producto p4 = new CamisetaLocal( 399.99, true, 11, 5, 0, "L", "Eraso", 17);
    Producto p5 = new CamisetaVisitante( 149.99, true, 16, 6, 2, "S", "Carrasco", 21);
    Producto p6 = new CamisetaVisitante( 69.99, true, 21, 7, 0, "XS", "Pedri", 16);
    Producto p7 = new CamisetaVisitante( 29.99, true, 12, 8, 3, "XXS", "Gavi", 30);
    Producto p8 = new CamisetaVisitante( 19.99, true, 17, 9, 1, "XL", "Pau Torres", 4);
    Producto p9 = new Botas( "Botas", 54.99, true, 8, 1, 42, 0, "Predator", "Adidas", "Blanco");
    Producto p10 = new Botas( "Botas", 54.99, true, 8, 2, 43, 2, "Predator", "Adidas", "Negro");
    Producto p11 = new Botas( "Botas", 54.99, true, 8, 3, 44, 0, "Predator", "Adidas", "Azul");
    Producto p12 = new PantalonChandal( 69.99, true, 10, 2, 0, "XL", 7);
    Producto p13 = new PantalonChandal( 49.99, false, 200, 3, 1, "L", 9);
    Producto p14 = new PantalonChandal( 129.99, true, 0, 4, 0, "M", 8);
    Producto p15 = new PantalonChandal( 429.99, true, 11, 5, 0, "L", 17);
    Producto p16 = new PantalonCorto( 179.99, true, 16, 6, 1, "S", 21);
    Producto p17 = new PantalonCorto( 99.99, true, 21, 7, 2, "XS", 16);
    Producto p18 = new PantalonCorto( 59.99, true, 12, 8, 0, "XXS", 30);
    Producto p19 = new PantalonCorto( 49.99, true, 17, 9, 0, "XL", 4);
    Producto p20 = new Guantes( "Guantes", 49.99, true, 10, 3, 0, "M", "Tiro Pro", "Adidas", "Blanco", 8);
    Producto p21 = new Guantes( "Guantes", 69.99, true, 3, 1, 1, "M", "Tiro Pro", "Adidas", "Negro", 10);
    Producto p22 = new Guantes( "Guantes", 9.99, true, 13, 8, 0, "XS", "Six", "Walter", "Verde", 2);
    Producto p23 = new Guantes( "Guantes", 24.99, true, 21, 11, 0, "S", "Skull", "Ho Soccer", "Negro", 5);

    Carrito carrito = new Carrito();
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
    inventario.add(p12);
    inventario.add(p13);
    inventario.add(p14);
    inventario.add(p15);
    inventario.add(p16);
    inventario.add(p17);
    inventario.add(p18);
    inventario.add(p19);
    inventario.add(p20);
    inventario.add(p21);
    inventario.add(p22);
    inventario.add(p23);
    

    inventario.eliminar(p1, productos);
    inventario.reabastecer(p2, 3);

    Tienda tienda =Tienda.crearTienda(3,inventario);

    tienda.mostrarTienda();
    char desp = 'T';
    Scanner lectura = new Scanner(System.in);
    String comandos="I para pagina anterior\n"+
      "D para siguiente pagina\n"+
      "N para ver inventario\n"+
      "T para ver tienda\n"+
      "A para anadir al carrito\n"+
      "E para eliminar del carrito\n"+
      "C para ver carrito\n"+
      "S para salir";
    
    while (desp != 'S') {
      System.out.println(comandos);

      String d = lectura.next();
      desp = d.charAt(0);
      if (desp == 'I' || desp == 'i') {
        tienda.desplazaIzq();
      } else if (desp == 'D' || desp == 'd') {
        tienda.desplazaDer();
      } else if (desp == 'N' || desp == 'n') {
        inventario.mostrarInventario();
      }
       else if (desp == 'T' || desp == 't') {
        tienda.mostrarTienda();
      }
      else if (desp == 'A' || desp == 'a') {
        System.out.println("Introduzca el producto a anadir");
        int productoCarrito = lectura.nextInt();
        if(productoCarrito>=1 && productoCarrito<=productos.size())
        {
          carrito.anadirCarrito(productos.get(productoCarrito-1));
        }
        else {
          System.out.println("Producto no valido");
        } 
   
      }
      else if (desp == 'C' || desp == 'c') {
        carrito.mostrarCarrito();
      }
      else if (desp == 'E' || desp == 'e') {
        System.out.println("Introduzca el producto a eliminar");
        int productoCarrito = lectura.nextInt();
        carrito.eliminarCarrito(productoCarrito);
        
      }
    }
    lectura.close();
 }
}