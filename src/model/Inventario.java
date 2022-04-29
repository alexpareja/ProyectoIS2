package model;
import java.util.ArrayList;

import BBDD.DAOXMLInventario;
import BBDD.DTOInventario;

public class Inventario{
  protected ArrayList<Producto> inventario;
  protected ArrayList<InventarioObserver> observers;
  protected DAOXMLInventario dao;
  
  public Inventario(){
    this.inventario = new ArrayList<Producto>();
    this.observers = new ArrayList<InventarioObserver>();
  }

  public void eliminar(Producto prod, ArrayList<Producto> productos){
    inventario.remove(inventario.indexOf(prod));
    productos.remove(productos.indexOf(prod));
  }

  public void reabastecer(Producto prod, int n){
    if(inventario.indexOf(prod) != -1){
      inventario.get(inventario.indexOf(prod)).setStock(prod.getStock()+n);
    }
  }

  public Producto buscarProducto(String id){
    int n = 0;
    Producto p = null;
    while(p == null && n < inventario.size()){
      if(id.equals(inventario.get(n).getId())){
        p = inventario.get(n);
      }
      else{
        n++;
      }
    }
    return p;
  }
  
  public Producto buscarProductoPosicion(int pos){
	    return inventario.get(pos);
	  }

  public void add(Producto prod){
    if (!inventario.contains(prod))inventario.add(prod);
    this.guardar();
  }
  
  public void add(ArrayList<Producto> prod){
    for (Producto p: prod) 
      if (!inventario.contains(p))
        inventario.add(p);
    
    this.guardar();
  }
  
  public void setPrecio(int i, double price){
	    
	    this.buscarProductoPosicion(i).setPrecio(price);
	    
	    for(int j = 0; j < observers.size(); j++) {
			observers.get(j).onActualizaTienda(inventario);
		}
	    
	   this.guardar();
	    
	  }
  
  public ArrayList<Producto> getProductos(){
	  ArrayList<Producto> a=new ArrayList<Producto>();
	    for(int i=0;i<inventario.size();i++) {
	    	if(inventario.get(i).getActivo()) {
	    		a.add(inventario.get(i));
	    	}
	    }
	    return a;
}
  
  public ArrayList<Producto> getInventario(){
	    return inventario;
}

  public void mostrarInventario(){
    for(int i = 0; i < inventario.size(); i++)
      System.out.println(inventario.get(i).mostrarEnInv());
  }
  
 
  
  public int getNumProductos() {
	  return inventario.size();
  }
  
  public void cargar() {
	 this.dao=new DAOXMLInventario();
	 ArrayList<DTOInventario> a =dao.cargarInventario();
	 for(int i=0;i<a.size();i++) {
		 
		 switch(a.get(i).getId()) {
		 
		 case "CamLocal":
		 inventario.add(new CamisetaLocal(a.get(i).getPrecio(),a.get(i).isActivo(),a.get(i).getStock(),
		 a.get(i).getUdsvendidas(),a.get(i).getReservados(),a.get(i).getTalla(),a.get(i).getNombre(),a.get(i).getDorsal()));
		 
		 break;
		 
		 case "CamVisitante":
			 inventario.add(new CamisetaVisitante(a.get(i).getPrecio(),a.get(i).isActivo(),a.get(i).getStock(),
			 a.get(i).getUdsvendidas(),a.get(i).getReservados(),a.get(i).getTalla(),a.get(i).getNombre(),a.get(i).getDorsal()));
		 
		 break;
		 
		 case "ConVisitante":
			 inventario.add(new ConjuntoVisitante(a.get(i).getPrecio(),a.get(i).isActivo(),a.get(i).getStock(),
			 a.get(i).getUdsvendidas(),a.get(i).getReservados(),a.get(i).getTalla(),a.get(i).getNombre(),a.get(i).getDorsal()));
		 
		 break;
		 
		 case "ConLocal":
			 inventario.add(new ConjuntoLocal(a.get(i).getPrecio(),a.get(i).isActivo(),a.get(i).getStock(),
			 a.get(i).getUdsvendidas(),a.get(i).getReservados(),a.get(i).getTalla(),a.get(i).getNombre(),a.get(i).getDorsal()));
		 
		 break;
		 
		 case "PantChandal":
			 inventario.add(new PantalonChandal(a.get(i).getPrecio(),a.get(i).isActivo(),a.get(i).getStock(),
			 a.get(i).getUdsvendidas(),a.get(i).getReservados(),a.get(i).getTalla(),a.get(i).getDorsal()));
		 
		 break;
		 
		 case "PantCorto":
			 inventario.add(new PantalonCorto(a.get(i).getPrecio(),a.get(i).isActivo(),a.get(i).getStock(),
			 a.get(i).getUdsvendidas(),a.get(i).getReservados(),a.get(i).getTalla(),a.get(i).getDorsal()));
		 
		 break;
		 
		 case "Guantes":
			 inventario.add(new Guantes(a.get(i).getPrecio(),a.get(i).isActivo(),a.get(i).getStock(),
			 a.get(i).getUdsvendidas(),a.get(i).getReservados(),a.get(i).getTalla(),a.get(i).getModelo(),
			 a.get(i).getMarca(),a.get(i).getColor(),a.get(i).getAdherencia()));
		 
		 break;
		 
		 case "Botas":
			 inventario.add(new Botas(a.get(i).getPrecio(),a.get(i).isActivo(),a.get(i).getStock(),
			 a.get(i).getUdsvendidas(),a.get(i).getReservados(),a.get(i).getTallaZ(),a.get(i).getModelo(),
			 a.get(i).getMarca(),a.get(i).getColor()));
		 
		 break;
		 }
		 
	 } 
	 
	 for(int i = 0; i < this.observers.size(); i++) {
			this.observers.get(i).onActualizaTienda(this.getProductos());
		}
  }
  
  public void guardar() {
	  this.dao=new DAOXMLInventario();
	  ArrayList<DTOInventario> a=this.crearDTOs();
	  dao.guardarInventario(a);
		 
	  }
  
  private ArrayList<DTOInventario> crearDTOs() {
	 ArrayList<DTOInventario> a=new ArrayList<DTOInventario>();
	 
	 for(int i=0;i<inventario.size();i++) {
		 a.add(inventario.get(i).convierteDTO());
	 } 
	 return a;
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

  
  public boolean comprar(Carrito carrito) {
	  for(Producto p: carrito.getProductos()) {
		  if (inventario.contains(p))
			  inventario.get(inventario.indexOf(p)).disminuirStock();
	  }
	  return true;
  }
  

}