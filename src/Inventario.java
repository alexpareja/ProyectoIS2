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
    if (!inventario.contains(prod))inventario.add(prod);
  }
  
  public void add(ArrayList<Producto> prod){
    for (Producto p: prod) 
      if (!inventario.contains(p))
        inventario.add(p);
  }

  public void mostrarInventario(){
    for(int i = 0; i < inventario.size(); i++)
      System.out.println(inventario.get(i).mostrarEnInv());
  }
  
  public void reservar(Producto prod) {
	  if(!inventario.contains(prod))throw new IllegalArgumentException("No existe este producto en el inventario");
	  if(prod.getStock()==0)throw new IllegalArgumentException("No quedan unidades de este producto");
	  prod.setStock(-1);
	  prod.setReservados(1);
  }
}