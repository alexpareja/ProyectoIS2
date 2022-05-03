package launcher;

import Viewer.MainWindow;
import controller.Controller;
import model.Carrito;
import model.Inventario;
import model.Tienda;

public class Main {

	public static void main(String[] args) {
		Inventario inventario = new Inventario();
		inventario.cargar(); // Cargamos los productos de la BBDD

		Carrito carrito = new Carrito();
		Tienda tienda = Tienda.crearTienda(6, inventario);
//Creamos el inventario, el carrito y la tienda para crear nuestro controller
		Controller ctrl = new Controller(inventario, carrito, tienda);
//esta sera nuestra ventana principal del programa
		MainWindow ventana = new MainWindow(ctrl);

		inventario.guardar(); // hacer el guardado cuando se salga de la app
	}

}