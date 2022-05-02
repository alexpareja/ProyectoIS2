package model;
import java.util.ArrayList;

public interface InventarioObserver {

	void onRegistroTienda(ArrayList<Producto> inventario);
	void onActualizaTienda(ArrayList<Producto> inventario);
	void onCambiarPrecio(ArrayList<Producto> inventario);

}
