import java.util.ArrayList;

public class Inventario{
  protected ArrayList<Producto> inventario;
  protected ArrayList<InventarioObserver> observers;
  
  Inventario(){
    this.inventario = new ArrayList<Producto>();
    this.observers = new ArrayList<InventarioObserver>();
  }

  public void eliminar(Producto prod, ArrayList<Producto> productos){
    inventario.remove(inventario.indexOf(prod));
    productos.remove(productos.indexOf(prod));
  }

  public void reabastecer(Producto prod, int n){
    inventario.get(inventario.indexOf(prod)).setStock(prod.getStock()+n);
  }

  public void add(Producto prod){
    if (!inventario.contains(prod))inventario.add(prod);
  }
  
  public void add(ArrayList<Producto> prod){
    for (Producto p: prod) 
      if (!inventario.contains(p))
        inventario.add(p);
  }
  
  public  ArrayList<Producto> getProductos(){
	  ArrayList<Producto> a=new ArrayList<Producto>();
	    for(int i=0;i<inventario.size();i++) {
	    	if(inventario.get(i).getActivo()) {
	    		a.add(inventario.get(i));
	    	}
	    }
	    return a;
}
  

  public void mostrarInventario(){
    for(int i = 0; i < inventario.size(); i++)
      System.out.println(inventario.get(i).mostrarEnInv());
  }
  
 
  
  public int getNumProductos() {
	  return inventario.size();
  }
  
  
  
  public void reservar(Producto prod) {
	  if(!inventario.contains(prod))throw new IllegalArgumentException("No existe este producto en el inventario");
	  if(prod.getStock()==0)throw new IllegalArgumentException("No quedan unidades de este producto");
	  prod.setStock(prod.getStock()-1);
	  prod.setReservados(prod.getReservados()+1);
  }

  public void addObserver(InventarioObserver o) {
	  if(!this.observers.contains(o)) {
			this.observers.add(o);	
			this.observers.get(this.observers.indexOf(o)).onRegistroTienda(this.getProductos());
		}
  }

  public void actualizarTienda() {
	  for(int i = 0; i < this.observers.size(); i++) {
			this.observers.get(i).onActualizaTienda(this.getProductos());
		}
  }

}