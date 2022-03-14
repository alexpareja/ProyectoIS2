import java.util.ArrayList;

public class Inventario{
  protected ArrayList<Producto> inventario;
  
  Inventario(){
    this.inventario = new ArrayList<Producto>();
  }

  public void eliminar(Producto prod, ArrayList<Producto> productos){
    
    inventario.remove(inventario.indexOf(prod));
    productos.remove(productos.indexOf(prod));
  }

  public void reabastecer(Producto prod, int n){
    inventario.get(inventario.indexOf(prod)).setStock(n);
  }

  public void add(Producto prod){
    inventario.add(prod);
  }

  public void add(ArrayList<Producto> prod){
    for (Producto p: prod) inventario.add(p);
  }

  public void mostrarInventario(){
	  System.out.println("Artículos en el inventario: "))
    for(int i = 0; i < inventario.size(); i++){
      System.out.println(inventario.get(i).mostrarEnInv());
    }
  }
}