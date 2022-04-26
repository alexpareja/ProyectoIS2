package BBDD;

import java.util.ArrayList;

public interface IDAOInventario {

	public void guardarInventario(ArrayList<DTOInventario> i);
	public ArrayList<DTOInventario> cargarInventario();
}
