package Viewer;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import controller.Controller;
import model.InventarioObserver;
import model.Producto;

public class ArticuloPanel extends JPanel implements InventarioObserver{
	
	private Producto _prod;
	private Controller _ctrl;
	
	private ImageIcon foto;
	
	
	ArticuloPanel(Controller ctrl, Producto prod) {
		this.setSize(200, 200);
		_prod = prod;
		initGUI();
		_ctrl = ctrl;
		_ctrl.addObserver(this);
		foto = _prod.getFoto();
}
	
	private void initGUI() {

		//this.setToolTipText("Comprar");
		this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));

		String precio = Double.toString(_prod.getPrecio());
		JLabel titulo = new JLabel(_prod.getId());
		JPanel imagen = new JPanel();
		JLabel precioL = new JLabel(precio);
		
		titulo.setAlignmentX(CENTER_ALIGNMENT);
		precioL.setAlignmentX(CENTER_ALIGNMENT);
		this.add(titulo);
		this.add(precioL);
		
		JButton comprar = new JButton("Anadir a carrito");
		
		comprar.setMinimumSize(new Dimension(150,20));
		comprar.setMaximumSize(new Dimension(150,20));
		comprar.setPreferredSize(new Dimension(150,20));
		
		comprar.addActionListener(new ActionListener(){  
			public void actionPerformed(ActionEvent e){		
				//anadir a carrito (observer)
			}
			});
		comprar.setAlignmentX(CENTER_ALIGNMENT);
		this.add(comprar);
		
		
		this.setMinimumSize(new Dimension(100,200));
		this.setMaximumSize(new Dimension(200,200));
		this.setPreferredSize(new Dimension(150,200));
		this.setBorder(BorderFactory.createTitledBorder(
				BorderFactory.createLineBorder(Color.black, 2),null ,TitledBorder.LEFT, TitledBorder.TOP));
	
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
