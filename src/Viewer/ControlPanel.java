package Viewer;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JToolTip;
import javax.swing.SpinnerNumberModel;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

import controller.Controller;
import model.InventarioObserver;
import model.Producto;

public class ControlPanel extends JPanel implements InventarioObserver {
// ...
	private Controller _ctrl;
	private JButton Busuario = new JButton();
	private JButton Bcarrito = new JButton();
	
	ControlPanel(Controller ctrl) {
			_ctrl = ctrl;
			initGUI();
			_ctrl.addObserver(this);
	}
	
	private void initGUI() {
		
		ImageIcon iUsuario = new ImageIcon("resources/icons/user.png");
		ImageIcon iCarrito = new ImageIcon("resources/icons/carro.png");
		
		Busuario.setIcon(iUsuario);
		Bcarrito.setIcon(iCarrito);
	
		Busuario.setToolTipText("Identificarse como usuario");
		Bcarrito.setToolTipText("Ver tu carrito");
		
		//1)
		Busuario.addActionListener(new ActionListener(){  
			public void actionPerformed(ActionEvent e){ 
			
				JDialog usuario = new JDialog();
				JPanel panelUsuario = new JPanel();
				panelUsuario.setLayout(new BorderLayout());
				
				JLabel info = new JLabel("Identificate como usuario", SwingConstants.CENTER);
				
				
				JLabel infoId = new JLabel("User: ");
				JLabel infoContra = new JLabel("Password: ");
				
				JTextField id = new JTextField("");
				JTextField contra = new JPasswordField("");
				
				JPanel panelDatos = new JPanel(new GridLayout(2,2));
				
				panelDatos.add(infoId);
				panelDatos.add(id);
				panelDatos.add(infoContra);
				panelDatos.add(contra);
				
				
				panelUsuario.add(panelDatos, BorderLayout.CENTER);

				panelUsuario.add(info, BorderLayout.PAGE_START);
				
				JPanel abajo = new JPanel();
				abajo.setLayout(new BorderLayout());
				
				JButton cancel = new JButton("Salir");
				
				cancel.addActionListener(new ActionListener(){  
					public void actionPerformed(ActionEvent e){
						usuario.setVisible(false);
					}
					});
				abajo.add(cancel, BorderLayout.WEST);
				
				JButton aceptar = new JButton("Aceptar");
				
				aceptar.addActionListener(new ActionListener(){  
					public void actionPerformed(ActionEvent e){		
						usuario.setVisible(false);
					}
					});
				abajo.add(aceptar, BorderLayout.EAST);
				panelUsuario.add(abajo, BorderLayout.PAGE_END);
				
				usuario.add(panelUsuario);
				usuario.setResizable(false);
				usuario.setSize(new Dimension(300, 150));
				usuario.setVisible(true);
				
			}
			});
		
		
		//2
		Bcarrito.addActionListener(new ActionListener(){  
			public void actionPerformed(ActionEvent e){ 
				JDialog carrito = new JDialog();
				JPanel panelCarrito = new JPanel();
				panelCarrito.setLayout(new BorderLayout());
				
				JLabel info = new JLabel("Este es su carrito: ", SwingConstants.CENTER);
				panelCarrito.add(info, BorderLayout.PAGE_START);
				
				JPanel panelDatos = new JPanel(); 
				
				BoxLayout datos= new BoxLayout(panelDatos, BoxLayout.PAGE_AXIS);
				panelDatos.setLayout(datos);
				
				JScrollPane panelScrollDatos = new JScrollPane(panelDatos, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
						JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
				
				double suma = 0;
				
				for(int i = 0; i < _ctrl.getC().getProductos().size(); i++) {
					JLabel l = new JLabel(_ctrl.getC().getProductos().get(i).mostrarEnCarrito());
					panelDatos.add(l);
					suma = suma + _ctrl.getC().getProductos().get(i).getPrecio();
				}
				
				
				
				
				panelCarrito.add(panelScrollDatos, BorderLayout.CENTER);

				
				
				JPanel abajo = new JPanel();
				abajo.setLayout(new GridLayout(2,2));
				
				JLabel total = new JLabel("Total: ");
				JLabel numtotal = new JLabel(String.valueOf(suma));
				
				abajo.add(total);
				abajo.add(numtotal);
				
				JButton cancel = new JButton("Salir");
				
				cancel.addActionListener(new ActionListener(){  
					public void actionPerformed(ActionEvent e){
						carrito.setVisible(false);
					}
					});
				
				abajo.add(cancel);
				
				JButton aceptar = new JButton("Comprar");
				
				aceptar.addActionListener(new ActionListener(){  
					public void actionPerformed(ActionEvent e){		
						carrito.setVisible(false);
					}
					});
				abajo.add(aceptar);
				
				panelCarrito.add(abajo, BorderLayout.PAGE_END);
				
				carrito.add(panelCarrito);
				//carrito.setResizable(false);
				carrito.setSize(new Dimension(300, 150));
				carrito.setVisible(true);
		
			}
			});
		
		
		
		
		
	
       
		this.add(Busuario);
		this.add(Bcarrito);
	}

	/*private void run_sim(int n) {
		if (n > 0) {
			try {
				//_ctrl.run(1);
			} catch (Exception e) {
				// TODO show the error in a dialog box
				// TODO enable all buttons
				Busuario.setEnabled(true);
				return;
			}
			SwingUtilities.invokeLater( new Runnable() {
				@Override
				public void run() {
					run_sim(n-1);
				}
			});
		} else {
			Busuario.setEnabled(true);
		}
	}*/

	@Override
	public void onRegistroTienda(ArrayList<Producto> inventario) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onActualizaTienda(ArrayList<Producto> inventario) {
		// TODO Auto-generated method stub
		
	}



}
