package model;
import java.util.ArrayList;

import controller.Controller;

public class Tienda implements InventarioObserver {
 
  //private Inventario inventario;
  private int productosPorPagina;
  private int paginaAct;
  private static Tienda tienda; //Singleton
  protected ArrayList<Producto> productosTienda;
 

//crear tienda con productos ya creados
  private Tienda(int numProdPag, Inventario i, Controller ctrl) {
	//inventario=i;
    this.productosPorPagina = numProdPag;
    this.paginaAct = 0;
    ctrl.addObserver(this);
    //this.productosTienda=inventario.getProductos();
    
    
  }
//creador Singleton
  public static Tienda crearTienda(int numProdPag, Inventario i,Controller ctrl){
    if(tienda==null){
      tienda=new Tienda(numProdPag,i,ctrl);
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
   
  
    this.mostrarTienda();
    
    /*  for(int j = 0; j < this.listaObserver.size(); j++) {
	this.listaObserver.get(j).onDesplazaDer();
	}*/
  }
  
//desplaza página a la derecha
  public void desplazaDer() {

    if ((this.paginaAct + 1) * this.productosPorPagina < productosTienda.size())
      this.paginaAct++;
  
    this.mostrarTienda();
    //notifica a los observadores que se desplaza
  /*  for(int j = 0; j < this.listaObserver.size(); j++) {
		this.listaObserver.get(j).onDesplazaDer();
	}*/
  }
  
  
@Override
public void onRegistroTienda(ArrayList<Producto> inventario) {
	this.productosTienda=inventario;
	this.mostrarTienda();	
}//notifica de creaci�n de tienda

@Override
public void onActualizaTienda(ArrayList<Producto> inventario) {
	this.productosTienda=inventario;
}//notifica de actualizacion de tienda
  
  
}