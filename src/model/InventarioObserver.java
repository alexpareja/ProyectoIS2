package model;

import java.util.ArrayList;

public interface InventarioObserver {

	void onRegistroTienda(ArrayList<Producto> list);

	void onActualizaTienda(ArrayList<Producto> productosTienda);

	void onCambiarPrecio(ArrayList<Producto> inventario);

}
