
public class Controller {

	private Inventario i;
	
	public Controller(Inventario inv) {
		this.i=inv;
	}
	
	
	public void addObserver(InventarioObserver o) {
		i.addObserver(o);
	}
	
	public void actualizarTienda(InventarioObserver o) {
		i.actualizarTienda();
	}
	
}
