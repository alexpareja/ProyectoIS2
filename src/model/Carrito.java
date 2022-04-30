package model;
import java.util.ArrayList;

public class Carrito {
  private ArrayList<Producto> productos;
  // Usuario
  public Carrito() {
    productos = new ArrayList<Producto>();
  }
  
  //al comprar se limpia el carrito
  public void reset() {
	  productos = new ArrayList<Producto>();
  }
  
//anadir producto al carrito
  public void anadirCarrito(Producto p) {
    productos.add(p);
  }
  
//eliminar producto del carrito
  public void eliminarCarrito(int productoCarrito) {
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
  
  public ArrayList<Producto> getProductos() {
	return productos;
}

public boolean carritoVacio(){
      
  return productos.isEmpty();
  }
  
  public void mostrarCarrito() {
    if(!productos.isEmpty())
    { 
      for(int i = 0; i < productos.size(); i++) {
        int pos=i+1;      
        System.out.println("N�"+pos+productos.get(i).mostrarEnCarrito());
      }
    }
    else
    {
       System.out.println("Carrito vacio");
    }
  }
}