package Viewer;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

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
			ArticuloPanel 	p1, p2, p3, p4, p5, p6;
			
		this.setLayout(new GridLayout(2,3));
		int i = (_ctrl.getT().getPaginaAct()) * 6;
		if(i < _ctrl.getT().getProductosTienda().size() - 6) {
		 	p1 = new ArticuloPanel(_ctrl,  _ctrl.getT().getProductosTienda().get(i));
			p2 = new ArticuloPanel(_ctrl,  _ctrl.getT().getProductosTienda().get(i+1)); 
			p3 = new ArticuloPanel(_ctrl,  _ctrl.getT().getProductosTienda().get(i+2));
		    p4 = new ArticuloPanel(_ctrl,  _ctrl.getT().getProductosTienda().get(i+3)); 
			p5 = new ArticuloPanel(_ctrl,  _ctrl.getT().getProductosTienda().get(i+4));
			p6 = new ArticuloPanel(_ctrl,  _ctrl.getT().getProductosTienda().get(i+5));
		}
		else {
			p1 = new ArticuloPanel(_ctrl,  _ctrl.getT().getProductosTienda().get(0));
			p2 = new ArticuloPanel(_ctrl,  _ctrl.getT().getProductosTienda().get(0)); 
			p3 = new ArticuloPanel(_ctrl,  _ctrl.getT().getProductosTienda().get(0));
		    p4 = new ArticuloPanel(_ctrl,  _ctrl.getT().getProductosTienda().get(0)); 
			p5 = new ArticuloPanel(_ctrl,  _ctrl.getT().getProductosTienda().get(0));
			p6 = new ArticuloPanel(_ctrl,  _ctrl.getT().getProductosTienda().get(0));
		}
		ArticuloPanel[] paneles = {p1,p2,p3,p4,p5,p6};	
		
		
				
		for(int j = 0; j < paneles.length; j++) {
			
			this.add(paneles[j]);
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
