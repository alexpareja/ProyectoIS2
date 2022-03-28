import java.util.ArrayList;
import java.util.Scanner;

public class Carrito {
  private ArrayList<Producto> productos;
  // Usuario
  public Carrito() {
    productos = new ArrayList<Producto>();
  }
  
//añadir producto al carrito
  void anadirCarrito(Producto p) {
    productos.add(p);
  }
  
//eliminar producto del carrito
  void eliminarCarrito(int productoCarrito) {
    if(!this.carritoVacio())
     {
        if(productoCarrito>=1 && productoCarrito<=productos.size())
        {
     productos.remove(productoCarrito-1);
          }
          else
              {
              System.out.println("Producto no valido");
              }
          
        }
          else  {
              System.out.println("No hay productos para eliminar");
              }
  }
  
  public boolean carritoVacio(){
      
  return productos.isEmpty();
  }
  void mostrarCarrito() {
    if(!productos.isEmpty())
    { 
      for(int i = 0; i < productos.size(); i++) {
        int pos=i+1;      
        System.out.println("Nº"+pos+productos.get(i).mostrarEnCarrito());
      }
    }
    else
    {
       System.out.println("Carrito vacío");
    }
  }
}