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
			
		this.setLayout(new GridLayout(2,3));
			
		ArticuloPanel Bprod1 = new ArticuloPanel(_ctrl, _ctrl.getI().getProductos().get(0));
		ArticuloPanel Bprod2 = new ArticuloPanel(_ctrl,  _ctrl.getI().getProductos().get(1));
		ArticuloPanel Bprod3 = new ArticuloPanel(_ctrl,  _ctrl.getI().getProductos().get(2));
		ArticuloPanel Bprod4 = new ArticuloPanel(_ctrl, _ctrl.getI().getProductos().get(3));
		ArticuloPanel Bprod5 = new ArticuloPanel(_ctrl,  _ctrl.getI().getProductos().get(4));
		ArticuloPanel Bprod6 = new ArticuloPanel(_ctrl,  _ctrl.getI().getProductos().get(5));

		this.add(Bprod1);
		this.add(Bprod2);	

		this.add(Bprod3);
		this.add(Bprod4);
		this.add(Bprod5);	

		this.add(Bprod6);
		
			
	
		
		}


		@Override
		public void onRegistroTienda(ArrayList<Producto> inventario) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onActualizaTienda(ArrayList<Producto> inventario) {
			// TODO Auto-generated method stub
			
		}

}
