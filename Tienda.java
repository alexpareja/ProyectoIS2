import java.util.ArrayList;

public class Tienda {
  private ArrayList<Producto> productos;
  //private Inventario inventario;
  private int cont;
  private int tamanoMax;
  private int productosPorPagina;
  private int paginaAct;
//crear tienda vacía
  public Tienda(int numProductos, int numProdPag) {
    this.cont = 0;
    productos = new ArrayList<Producto>(numProductos);
    this.tamanoMax = numProductos;
    this.productosPorPagina = numProdPag;
    this.paginaAct = 0;
  }
//crear tienda con productos ya creados
  public Tienda(ArrayList<Producto> prod, int numProductos, int numProdPag) {
    this.productos = prod;
    this.cont = prod.size();
    this.tamanoMax = numProductos;
    this.productosPorPagina = numProdPag;
    this.paginaAct = 0;
  }
//mostrar página de productos de la tienda
  public void mostrarTienda() {
    for (int i = this.paginaAct * this.productosPorPagina; i < this.paginaAct * this.productosPorPagina
        + this.productosPorPagina; i++) {
      if (i < productos.size()) {
        System.out.println(productos.get(i).mostrar());
      }
    }
  }
//desplaza página a la izquierda
  public void desplazaIzq() {

    if (this.paginaAct > 0)
      this.paginaAct--;

    System.out.print("\033[H\033[2J");// limpiar consola
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