package BBDD;



public interface IDAOInventario {

	public void guardarInventario(DTOInventario i);
	public DTOInventario cargarInventario();
}
