package Viewer;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

import controller.Controller;
import model.InventarioObserver;
import model.Producto;

public class ArticuloPanel extends JPanel implements InventarioObserver {

	private static final long serialVersionUID = 1L;
	private Producto _prod;
	private Controller _ctrl;
	
	public ArticuloPanel(Controller ctrl, Producto prod) {
		_prod = prod;
		initGUI();
		_ctrl = ctrl;
		_ctrl.addObserver(this);
	}

//Se inicia la interfaz mediante un BoxLayout
	private void initGUI() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
//Se cogen el precio, el nombre y la imagen 
		String precio = Double.toString(_prod.getPrecio());
		JLabel titulo = new JLabel(_prod.getId());
		JLabel precioL = new JLabel(precio + " euros");

		JLabel imagen = new JLabel(" ");
		imagen.setIcon(_prod.getFoto());
		imagen.setVisible(true);

		titulo.setAlignmentX(CENTER_ALIGNMENT);
		precioL.setAlignmentX(CENTER_ALIGNMENT);
		imagen.setAlignmentX(CENTER_ALIGNMENT);
		
//Se añaden al panel
		add(titulo);
		add(imagen);
//Se coge el resto de información necesaria para mostrar y se añade al panel
		String[] info = _prod.mostrar();
		JPanel panelInfo = new JPanel(new GridLayout(0, 2));
		for (int i = 0; i < info.length; i++) {
			JLabel a = new JLabel(info[i]);
			a.setHorizontalAlignment(JLabel.CENTER);
			panelInfo.add(a);
		}
		add(panelInfo);

		JPanel options = new JPanel();
		options.setLayout(new BoxLayout(options, BoxLayout.LINE_AXIS));
		Border raisedBorder = BorderFactory.createRaisedBevelBorder();
		
    //Se añade el boton para meter el articulo al carrito
		JButton comprar = new JButton("Anadir al carrito");
		comprar.setMinimumSize(new Dimension(150, 20));
		comprar.setMaximumSize(new Dimension(150, 20));
		comprar.setPreferredSize(new Dimension(150, 20));
		comprar.addActionListener(new ActionListener() {
			//cuando se pulsa se añade al carrito
			public void actionPerformed(ActionEvent e) {
				_ctrl.getC().anadirCarrito(_prod);
				JOptionPane.showMessageDialog(null, "Producto anadido al carrito", "Confirmacion",
						JOptionPane.INFORMATION_MESSAGE);
			}
		});
		comprar.setAlignmentX(LEFT_ALIGNMENT);
		comprar.setBorder(raisedBorder);
		comprar.setFocusable(false);
		options.add(comprar);
       //Se añade el boton para reservar
		JButton reservar = new JButton("Reservar");
		reservar.setMinimumSize(new Dimension(100, 20));
		reservar.setMaximumSize(new Dimension(100, 20));
		reservar.setPreferredSize(new Dimension(100, 20));
		reservar.addActionListener(new ActionListener() {
			//Cuando se pulsa se reserva el producto
			public void actionPerformed(ActionEvent e) {
				_ctrl.getI().reservar(_prod);
				JOptionPane.showMessageDialog(null, "Producto reservado", "Confirmacion",
						JOptionPane.INFORMATION_MESSAGE);
			}
		});
		reservar.setAlignmentX(RIGHT_ALIGNMENT);
		reservar.setBorder(raisedBorder);
		reservar.setFocusable(false);
		options.add(reservar);

		add(options);

		setMinimumSize(new Dimension(100, 200));
		setMaximumSize(new Dimension(200, 200));
		setPreferredSize(new Dimension(150, 200));
		setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black, 2), null,
				TitledBorder.LEFT, TitledBorder.TOP));

	}

	@Override
	public void onRegistroTienda(ArrayList<Producto> inventario) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onActualizaTienda(ArrayList<Producto> inventario) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onCambiarPrecio(ArrayList<Producto> inventario) {
		// TODO Auto-generated method stub

	}

}
