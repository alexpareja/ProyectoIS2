package Viewer;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.LayoutManager;
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

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
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
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import controller.Controller;
import model.InventarioObserver;
import model.Pantalon;
import model.PantalonChandal;
import model.PantalonCorto;
import model.Producto;
import model.Usuario;


public class ControlPanel extends JPanel implements InventarioObserver {
// ...
	private Controller _ctrl;
	private JButton Busuario = new JButton();
	private JButton Bcarrito = new JButton();
	private JButton Binventario = new JButton();
	
	
	ControlPanel(Controller ctrl) {
			_ctrl = ctrl;
			initGUI();
			_ctrl.addObserver(this);
	}
	
	private void comprarDialog() {
		JDialog pago = new JDialog();
		JPanel mainPanel = new JPanel(new BorderLayout());
		JTextField _direccion = new JTextField();
		JTextField _metodoPago = new JTextField();
		
		pago.setTitle("Datos de pago");
		
		mainPanel.setLayout((LayoutManager) new BoxLayout(mainPanel, BoxLayout.Y_AXIS)); //alinea de arriba a abajo
		mainPanel.setAlignmentY(CENTER_ALIGNMENT);
		pago.setContentPane(mainPanel);
		
		JLabel helpMsg = new JLabel("Gracias por comprar con nosotros");
		helpMsg.setAlignmentX(CENTER_ALIGNMENT);
		mainPanel.add(helpMsg);
		
		mainPanel.add(Box.createRigidArea(new Dimension(0,20)));
		
		JPanel viewsPanel = new JPanel();
		viewsPanel.setAlignmentX(CENTER_ALIGNMENT);
		viewsPanel.setLayout(new BoxLayout(viewsPanel, BoxLayout.Y_AXIS)); //de arriba a abajo
		mainPanel.add(viewsPanel);
		
		mainPanel.add(Box.createRigidArea(new Dimension(0,20)));
		
		JPanel buttonsPanel = new JPanel();
		buttonsPanel.setAlignmentX(CENTER_ALIGNMENT);
		mainPanel.add(buttonsPanel);
		
		viewsPanel.add(new JLabel("Introduzca su dirección: "));
		viewsPanel.add(_direccion);
		
		viewsPanel.add(new JLabel("Introduzca el número de tarjeta: "));
		viewsPanel.add(_metodoPago);
		
		JButton cancelButton = new JButton("Cancelar");
		cancelButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//_statusCompra = 0;
				pago.setVisible(false);
				JOptionPane.showMessageDialog(null, "La operación se ha cancelado");
			}
		});
		buttonsPanel.add(cancelButton);
		
		JButton okButton = new JButton("Pagar");
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//_statusCompra = 1;
				pago.setVisible(false);
				_ctrl.comprar(_ctrl.getC());//se disminuyen los elementos
				_ctrl.getC().reset();//se vacia el carrito
				JOptionPane.showMessageDialog(null, "La compra se ha realizado con éxito");
				
			}
		});
		buttonsPanel.add(okButton);
		
		pago.setPreferredSize(new Dimension(500, 200));
		pago.pack();
		pago.setResizable(false);
		pago.setVisible(true);
	}
	
	private void initGUI() {
        
		
		
		ImageIcon iUsuario = new ImageIcon("resources/icons/user.png");
		ImageIcon iCarrito = new ImageIcon("resources/icons/carro.png");
		ImageIcon iInventario = new ImageIcon("resources/icons/inventario.png");
		
		Busuario.setIcon(iUsuario);
		Bcarrito.setIcon(iCarrito);
		Binventario.setIcon(iInventario);
	
		Busuario.setToolTipText("Identificarse como usuario");
		Bcarrito.setToolTipText("Ver tu carrito");
		Binventario.setToolTipText("Ver inventario");
		
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
				JPasswordField contra = new JPasswordField("");
				JCheckBox cbox = new JCheckBox("Mostrar contaseña");
				
				cbox.addActionListener(new ActionListener(){  
					public void actionPerformed(ActionEvent e){
						if(cbox.isSelected()) {
							contra.setEchoChar((char)0);
						}
						else {
							contra.setEchoChar('●');
						}
						
					}
					});
				
				JPanel panelDatos = new JPanel(new GridLayout(3,2));
				
				panelDatos.add(infoId);
				panelDatos.add(id);
				panelDatos.add(infoContra);
				panelDatos.add(contra);
				panelDatos.add(cbox);
				
				panelDatos.setSize(new Dimension (200,150));
				
				
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
						char[] arrayC = contra.getPassword();
						String pass = new String(arrayC); 
						_ctrl.getS().iniciaSesion(id.getText(), pass);
						_ctrl.getS().setDueno();
						
						//se llama a la funcion que inicie sesion
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
				
				String titColumna[]  = {"Producto", "Detalles", "Precio", "Cancelar"};
				
				DefaultTableModel modelo = new DefaultTableModel();
				modelo.setColumnIdentifiers(titColumna);
				
				JTable tabla = new JTable(modelo); 
				
				tabla.setShowHorizontalLines( false );
			    tabla.setRowSelectionAllowed( false );
			    tabla.setColumnSelectionAllowed( false );
				
			    tabla.setSelectionForeground( Color.white );
			    tabla.setSelectionBackground( Color.red );
			    
			    for(int j = 0; j < modelo.getRowCount(); j++) {
					modelo.removeRow(j);
					
				}
			    
			    for(int i = 0; i < _ctrl.getC().getProductos().size(); i++) {
			    	String nombre = _ctrl.getC().getProductos().get(i).getId();
			    	String detalles = "1234";
			    	double precio = Math.round((_ctrl.getC().getProductos().get(i).getPrecio())*100.0)/100.0;
			
					String fila[] = {nombre, detalles, Double.toString(precio), "Borrar"};
					modelo.addRow(fila);
					suma = suma + _ctrl.getC().getProductos().get(i).getPrecio();
					
				}
				
			    panelDatos. add(new JScrollPane(tabla, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
						JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED), BorderLayout.CENTER);
				
				
			/*	
				
				for(int i = 0; i < _ctrl.getC().getProductos().size(); i++) {
					JLabel l = new JLabel(_ctrl.getC().getProductos().get(i).mostrarEnCarrito());
					panelDatos.add(l);
					
				}
				
				
				*/
				
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
						if (_ctrl.getC().carritoVacio()) JOptionPane.showMessageDialog(null, "El carrito está vacío");
						else comprarDialog();
					}
				});
				abajo.add(aceptar);
				
				panelCarrito.add(abajo, BorderLayout.PAGE_END);
				
				carrito.add(panelCarrito);
				//carrito.setResizable(false);
				carrito.setSize(new Dimension(600, 400));
				carrito.setVisible(true);
		
			}
			});
	
		
		
		Binventario.addActionListener(new ActionListener(){  
			public void actionPerformed(ActionEvent e){ 
				
				PantallaInventario inv = new PantallaInventario(_ctrl);	
				if(!_ctrl.getS().esDueno()) {
					JOptionPane.showMessageDialog(null, "No puedes acceder al inventario. Eres cliente",
						      "Error", JOptionPane.ERROR_MESSAGE);
				}
			

		
			}
			});
		
		
		this.add(Bcarrito);	
		this.add(Busuario);
		this.add(Binventario);
		
		JPanel infoUsu = new JPanel(new GridLayout(3,2));
		
		JLabel usuario1 = new JLabel("Usuario activo:    ");
		infoUsu.add(usuario1);
		JLabel usuario2 = new JLabel(_ctrl.getS().getUsuarioActual().getUsuario());
		infoUsu.add(usuario2);
		
		JLabel rol1 = new JLabel("Rol:    ");
		infoUsu.add(rol1);
		if(_ctrl.getS().esDueno()) {
			JLabel rol2 = new JLabel("Dueno");
			infoUsu.add(rol2);
		}else {
			JLabel rol2 = new JLabel("Cliente");
			infoUsu.add(rol2);
		}
		
		
		JLabel efectivo1 = new JLabel("Dinero disponible:    ");
		infoUsu.add(efectivo1);
		JLabel efectivo2 = new JLabel("30 pavos");
		infoUsu.add(efectivo2);
		
		
		this.add(infoUsu);
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

	@Override
	public void onCambiarPrecio(ArrayList<Producto> inventario) {

	}

}
