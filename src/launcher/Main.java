package launcher;
import java.util.ArrayList;
import java.util.Scanner;

import Viewer.MainWindow;
import controller.Controller;
import model.Botas;
import model.CamisetaLocal;
import model.CamisetaVisitante;
import model.Carrito;
import model.Guantes;
import model.Inventario;
import model.PantalonChandal;
import model.PantalonCorto;
import model.Producto;
import model.Tienda;

public class Main {

  public static void main(String[] args) {
    Inventario inventario = new Inventario();
    inventario.cargar();
    
    Carrito carrito = new Carrito();
    Tienda tienda =Tienda.crearTienda(6,inventario);
    
    Controller ctrl=new Controller(inventario, carrito, tienda);
  
    MainWindow ventana = new MainWindow(ctrl);
    
    tienda.mostrarTienda();

    inventario.guardar(); //hacer el guardado cuando se salga de la app
 }
 
}