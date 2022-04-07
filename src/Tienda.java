import java.util.ArrayList;

public class Tienda {
  private ArrayList<Producto> productos;
  //private Inventario inventario;
  private int productosPorPagina;
  private int paginaAct;
  private static Tienda tienda; //Singleton

//crear tienda con productos ya creados
  private Tienda(ArrayList<Producto> prod, int numProdPag) {
    this.productos = prod;
    this.productosPorPagina = numProdPag;
    this.paginaAct = 0;
  }
//creador Singleton
  public static Tienda crearTienda(ArrayList<Producto> prod, int numProdPag){
    if(tienda==null){
      tienda=new Tienda(prod,numProdPag);
    }
    else{
      System.out.print("Tienda ya creada");
    }

    return tienda;
  }
  
//mostrar página de productos de la tienda
  public void mostrarTienda() {
    for (int i = this.paginaAct * this.productosPorPagina; i < this.paginaAct * this.productosPorPagina
        + this.productosPorPagina; i++) {
      if (i < productos.size()) {
      int pos = i + 1;
      System.out.println("Nº"+pos+productos.get(i).mostrar());
      }
    }
  }
//desplaza página a la izquierda
  public void desplazaIzq() {

    if (this.paginaAct > 0)
      this.paginaAct--;

    //System.out.print("\033[H\033[2J");// limpiar consola
    System.out.flush();
    this.mostrarTienda();
  }
//desplaza página a la derecha
  public void desplazaDer() {

    if ((this.paginaAct + 1) * this.productosPorPagina < productos.size())
      this.paginaAct++;
    //System.out.print("\033[H\033[2J");
    System.out.flush();
    this.mostrarTienda();
  }
}