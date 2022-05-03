package Viewer;

import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import controller.Controller;
import model.InventarioObserver;
import model.Producto;

public class PantallaTienda extends JPanel implements InventarioObserver {
	
	private static final long serialVersionUID = 1L;
	private Controller _ctrl;
	
	PantallaTienda(Controller ctrl) {
		_ctrl = ctrl;
		initGUI();
		_ctrl.addObserver(this);
	}
	
	private void initGUI() {
		ArticuloPanel 	p1;
		List<ArticuloPanel> paneltienda =new ArrayList<ArticuloPanel>();
		
		this.setLayout(new GridLayout(2,3));
		int i = (_ctrl.getT().getPaginaAct()) * 6;
		int cont = i;
		while(i < _ctrl.getT().getProductosTienda().size()&&i<cont+6) {
			p1 = new ArticuloPanel(_ctrl,  _ctrl.getT().getProductosTienda().get(i));
			paneltienda.add(p1);
			i++;
		}
		
		for(int j = 0; j < paneltienda.size(); j++) 
			add(paneltienda.get(j));
	}


	@Override
	public void onRegistroTienda(ArrayList<Producto> inventario) {
		_ctrl.getT().actualizaTienda(inventario);
		removeAll();
		updateUI();
		initGUI();	
	}

	@Override
	public void onActualizaTienda(ArrayList<Producto> inventario) {
		removeAll();
		updateUI();
		initGUI();	
	}

}
