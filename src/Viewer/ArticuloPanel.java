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
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import controller.Controller;
import model.InventarioObserver;
import model.Producto;

public class ArticuloPanel extends JPanel implements InventarioObserver{
	
	private Producto _prod;
	private Controller _ctrl;

	
	
	ArticuloPanel(Controller ctrl, Producto prod) {
		_prod = prod;
		initGUI();
		_ctrl = ctrl;
		_ctrl.addObserver(this);

}
	
	private void initGUI() {

		this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));

		String precio = Double.toString(_prod.getPrecio());
		JLabel titulo = new JLabel(_prod.getId());
		JLabel precioL = new JLabel(precio + " euros");
		
	
		JLabel imagen = new JLabel(" ");
		imagen.setIcon(_prod.getFoto());
		imagen.setVisible(true);
		
		titulo.setAlignmentX(CENTER_ALIGNMENT);
		precioL.setAlignmentX(CENTER_ALIGNMENT);
		imagen.setAlignmentX(CENTER_ALIGNMENT);
		
		this.add(titulo);
		this.add(imagen);
		
		JComboBox<String> tll = new JComboBox<String>();
		String[] tallas= {"XS" ,"S", "M", "L", "XL"}; //Hacer tallas disponibles en cada articulo
		for(int i = 0; i < tallas.length; i++) {
			tll.addItem(tallas[i]);
		}
		
		JComboBox<String> nombr = new JComboBox<String>();
		String[] nombres= {"Alaba" ,"Marcelo", "CR7", "Benzema", "Ansu Fati"}; //Hacer nombres disponibles en cada articulo
		for(int i = 0; i < nombres.length; i++) {
			nombr.addItem(nombres[i]);
		}
		
		JPanel opt = new JPanel(new GridLayout(1, 2));
		
		opt.add(tll);
		opt.add(nombr);
		
		this.add(opt);
		this.add(precioL);
		
	
		
		JButton comprar = new JButton("Anadir a carrito");
		
		comprar.setMinimumSize(new Dimension(150,20));
		comprar.setMaximumSize(new Dimension(150,20));
		comprar.setPreferredSize(new Dimension(150,20));
		
		comprar.addActionListener(new ActionListener(){  
			public void actionPerformed(ActionEvent e){		
				
				_ctrl.getC().anadirCarrito(_prod);
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
