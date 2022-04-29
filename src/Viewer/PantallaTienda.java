package Viewer;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

import controller.Controller;
import model.InventarioObserver;
import model.Producto;

public class PantallaTienda extends JPanel implements InventarioObserver {
	// ...
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
		int cont =i;
		while(i < _ctrl.getT().getProductosTienda().size()&&i<cont+6) {
		   p1 = new ArticuloPanel(_ctrl,  _ctrl.getT().getProductosTienda().get(i));
			paneltienda.add(p1);
			i++;}
		
			
		
		
		
		for(int j = 0; j < paneltienda.size(); j++) {
			
			this.add(paneltienda.get(j));

		}
		 
		
		
		}


		@Override
		public void onRegistroTienda(ArrayList<Producto> inventario) {
			
			
		}

		@Override
		public void onActualizaTienda(ArrayList<Producto> inventario) {
			this.removeAll();
			this.updateUI();
			initGUI();	
		}

		@Override
		public void onCambiarPrecio(ArrayList<Producto> inventario) {
			// TODO Auto-generated method stub
			
		}

}
