package model;
import java.util.ArrayList;
import java.util.List;

public interface InventarioObserver {

	void onRegistroTienda(ArrayList<Producto> list);
	void onActualizaTienda(ArrayList<Producto> productosTienda);

}
