package model;
import java.util.ArrayList;
import java.util.List;


public class Tienda {
 
  //private Inventario inventario;
  private int productosPorPagina;
  private int paginaAct;
  private static Tienda tienda; //Singleton
  protected ArrayList<Producto> productosTienda;
  private List<InventarioObserver> io;
  
 

//crear tienda con productos ya creados
  private Tienda(int numProdPag, Inventario i) {
	//inventario=i;
    this.productosPorPagina = numProdPag;
    this.paginaAct = 0;
    this.productosTienda=i.getProductos();
    this.io = new ArrayList<InventarioObserver>();
    
  }
//creador Singleton
  public static Tienda crearTienda(int numProdPag, Inventario i){
    if(tienda==null){
      tienda=new Tienda(numProdPag,i);
    }
    else{
      System.out.print("Tienda ya creada");
    }

    return tienda;
  }
  
  //actualiza los cambios realizados en el inventario
  public void actualizaTienda(ArrayList<Producto> inventario) {
	  this.productosTienda=inventario;
	  
  }
  
  
//mostrar página de productos de la tienda
  public void mostrarTienda() {
	  for (int i = this.paginaAct * this.productosPorPagina; i < this.paginaAct * this.productosPorPagina
		        + this.productosPorPagina; i++) {
		      if (i < productosTienda.size()) {
		      int pos = i + 1;
		      System.out.println("N"+pos+productosTienda.get(i).mostrar());
		      }
		    }
	  
	  /*  for(int j = 0; j < this.listaObserver.size(); j++) {
		this.listaObserver.get(j).onDesplazaDer();
	}*/
  }
  
//desplaza página a la izquierda
  public void desplazaIzq() {

    if (this.paginaAct > 0)
      this.paginaAct--;
   
    for(int j = 0; j < io.size(); j++) {
		io.get(j).onActualizaTienda(productosTienda);
	}
    this.mostrarTienda();
    
    /*  for(int j = 0; j < this.listaObserver.size(); j++) {
	this.listaObserver.get(j).onDesplazaDer();
	}*/
  }
  
//desplaza página a la derecha
  public void desplazaDer() {

    if ((this.paginaAct + 1) * this.productosPorPagina < productosTienda.size())
      this.paginaAct++;
    
    for(int j = 0; j < io.size(); j++) {
		io.get(j).onActualizaTienda(productosTienda);
	}
  
    this.mostrarTienda();
    //notifica a los observadores que se desplaza
  /*  for(int j = 0; j < this.listaObserver.size(); j++) {
		this.listaObserver.get(j).onDesplazaDer();
	}*/
  }
  
  public void addObserver(InventarioObserver o) {
	  if(!this.io.contains(o)) {
			this.io.add(o);	
			this.io.get(this.io.indexOf(o)).onRegistroTienda(this.getProductosTienda());
		}
  }
  
public int getPaginaAct() {
	return paginaAct;
}


public ArrayList<Producto> getProductosTienda() {
	return productosTienda;
}
 
}