package BBDD;

import java.util.ArrayList;
import model.Producto;

public class DTOInventario {
	protected ArrayList<Producto> inventario;
	
	public DTOInventario(ArrayList<Producto> i) {
		this.inventario=i;
	}
	public ArrayList<Producto> getInventario(){
		return inventario;
	}
}