package Viewer;

import java.awt.BorderLayout;
import java.awt.CheckboxGroup;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import controller.Controller;
import model.Carrito;
import model.Compra;
import model.InventarioObserver;
import model.Producto;
import model.Usuario;
import model.UsuariosObserver;



public class ControlPanel extends JPanel implements InventarioObserver, UsuariosObserver {
	private static final long serialVersionUID = 1L;
	private Controller _ctrl;
	private JButton Busuario = new JButton();
	private JButton Bcarrito = new JButton();
	private JButton Binventario = new JButton();
	JLabel usuario2;
	JLabel rol2;
	Usuario user;
	
	
	ControlPanel(Controller ctrl) {
			_ctrl = ctrl;
			initGUI();
			_ctrl.addObserver(this);
			_ctrl.addObserverUsuario(this);
	}
	
	
	//HU Añadir método de pago
	private void anadirMetodoPago(String nombre, String direccion) {
		JDialog pago = new JDialog();
		JPanel mainPanel = new JPanel(new BorderLayout());
		pago.setTitle("Datos del pago");
		
		mainPanel.setAlignmentX(CENTER_ALIGNMENT);
		mainPanel.setLayout((LayoutManager) new BoxLayout(mainPanel, BoxLayout.Y_AXIS)); //alinea de arriba a abajo
		pago.setContentPane(mainPanel);
		
		JLabel msg = new JLabel("Elija uno de los métodos de pago");
		msg.setAlignmentX(CENTER_ALIGNMENT);
		mainPanel.add(msg);
		mainPanel.add(Box.createRigidArea(new Dimension(0,10)));
		
		JPanel buttonsPagoPanel = new JPanel();
		buttonsPagoPanel.setAlignmentY(CENTER_ALIGNMENT);
		buttonsPagoPanel.setLayout((LayoutManager) new BoxLayout(buttonsPagoPanel, BoxLayout.X_AXIS)); //alinea de arriba a abajo
		mainPanel.add(buttonsPagoPanel);
		
		ButtonGroup s = new ButtonGroup();
		JRadioButton tarjeta = new JRadioButton("Tarjeta");
		JRadioButton paypal = new JRadioButton("Paypal");
		JRadioButton efectivo = new JRadioButton("Efectivo");
		s.add(tarjeta);
		s.add(paypal);
		s.add(efectivo);
		s.clearSelection();
		
		buttonsPagoPanel.add(tarjeta);
		buttonsPagoPanel.add(paypal);
		buttonsPagoPanel.add(efectivo);
		JLabel help = new JLabel("*Si elige en efectivo no se podrán realizar devoluciones  ");
		
		JTextField _titular = new JTextField();
		JTextField _cuenta = new JTextField();
		
		mainPanel.add(Box.createRigidArea(new Dimension(0,10)));
		JLabel titular = new JLabel("Titular de la cuenta                      ");
		titular.setAlignmentX(CENTER_ALIGNMENT);
		mainPanel.add(titular);
		mainPanel.add(_titular);
		
		mainPanel.add(Box.createRigidArea(new Dimension(0,10)));
		
		JLabel cuenta = new JLabel("Número de cuenta                       ");
		cuenta.setAlignmentX(CENTER_ALIGNMENT);
		mainPanel.add(cuenta);
		mainPanel.add(_cuenta);
		
		mainPanel.add(Box.createRigidArea(new Dimension(0,30)));
		mainPanel.add(help);
		mainPanel.add(Box.createRigidArea(new Dimension(0,30)));
		
		JPanel buttonsPanel = new JPanel();
		buttonsPanel.setAlignmentX(CENTER_ALIGNMENT);
		mainPanel.add(buttonsPanel);
		
		JButton cancelButton = new JButton("Cancelar");
		cancelButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				pago.setVisible(false);
				JOptionPane.showMessageDialog(null, "La operación se ha cancelado");
			}
		});
		buttonsPanel.add(cancelButton);
		
		JButton okButton = new JButton("Pagar");
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (efectivo.isSelected()) {
					pago.setVisible(false);
					_ctrl.getI().getCompras().add(new Compra("efectivo",_ctrl.getC().getProductos().size(), _ctrl.getI().getCompras().size(), nombre, direccion));
					_ctrl.comprar(_ctrl.getC());//se disminuyen los elementos
					_ctrl.getC().reset();//se vacia el carrito
					JOptionPane.showMessageDialog(null, "La compra se ha realizado con éxito");
				}
				else if (paypal.isSelected()) {
					if (!_cuenta.getText().equals("") && !_titular.getText().equals("")) {
						pago.setVisible(false);
						_ctrl.getI().getCompras().add(new Compra("paypal", _ctrl.getC().getProductos().size(), _ctrl.getI().getCompras().size(), nombre, direccion));
						_ctrl.comprar(_ctrl.getC());//se disminuyen los elementos
						_ctrl.getC().reset();//se vacia el carrito
						JOptionPane.showMessageDialog(null, "La compra se ha realizado con éxito");
					}
					else {
						JOptionPane.showMessageDialog(null, "Rellene todos los campos");
					}
				}
				else if (tarjeta.isSelected()) {
					if (!_cuenta.getText().equals("") && !_titular.getText().equals("")) {
						pago.setVisible(false);
						_ctrl.getI().getCompras().add(new Compra("tarjeta",_ctrl.getC().getProductos().size(), _ctrl.getI().getCompras().size(), nombre, direccion));
						_ctrl.comprar(_ctrl.getC());//se disminuyen los elementos
						_ctrl.getC().reset();//se vacia el carrito
						JOptionPane.showMessageDialog(null, "La compra se ha realizado con éxito");
					}
					else {
						JOptionPane.showMessageDialog(null, "Rellene todos los campos");
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "Elija una de las opciones");
				}
			}
		});
		buttonsPanel.add(okButton);
		
		
		pago.setPreferredSize(new Dimension(500, 300));
		pago.pack();
		pago.setResizable(false);
		pago.setVisible(true);
	}
	
	
	//HU Comprar
	private void comprarDialog() {
		JDialog pago = new JDialog();
		JPanel mainPanel = new JPanel(new BorderLayout());
		JTextField _nombre = new JTextField();
		JTextField _direccion = new JTextField();
		
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
		
		
		viewsPanel.add(new JLabel("Introduzca su nombre: "));
		if (usuario2.getText() == "invitado") {
			viewsPanel.add(_nombre);
		}
		else viewsPanel.add(usuario2);
		
		
		viewsPanel.add(new JLabel("Introduzca su dirección: "));
		viewsPanel.add(_direccion);
		
		JButton cancelButton = new JButton("Cancelar");
		cancelButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				pago.setVisible(false);
				JOptionPane.showMessageDialog(null, "La operación se ha cancelado");
			}
		});
		buttonsPanel.add(cancelButton);
		
		JButton sigButton = new JButton("Siguiente");
		sigButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (usuario2.getText().equals("invitado") && !_nombre.getText().equals("") && !_direccion.getText().equals("")) {
					pago.setVisible(false);
					anadirMetodoPago(_nombre.getText(), _direccion.getText());
				}
				else if (!usuario2.getText().equals("invitado") && !_direccion.getText().equals("")){
					pago.setVisible(false);
					anadirMetodoPago(usuario2.getText(), _direccion.getText());
				}
				else 
					JOptionPane.showMessageDialog(null, "Rellene todos los campos");
			}
		});
		buttonsPanel.add(sigButton);
		
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
				JCheckBox cbox = new JCheckBox("Mostrar contasena");
				contra.setEchoChar('*');
				cbox.addActionListener(new ActionListener(){  
					public void actionPerformed(ActionEvent e){
						if(cbox.isSelected()) {
							contra.setEchoChar((char)0);
						}
						else {
							contra.setEchoChar('*');
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
						if(!_ctrl.iniciarSesion(id.getText(), pass))
						{
							JOptionPane.showMessageDialog(null, "Usuario no encontrado",
								      "Error", JOptionPane.ERROR_MESSAGE);
						}
						
				
					}
					});
				abajo.add(aceptar, BorderLayout.EAST);
				
				JButton registrarse = new JButton("Registrate");
				
				registrarse.addActionListener(new ActionListener(){  
					public void actionPerformed(ActionEvent e){		
						usuario.setVisible(false);
						
						JDialog usuarioNuevo = new JDialog();
						JPanel panelUsuario2 = new JPanel();
						panelUsuario2.setLayout(new BorderLayout());
						
						JLabel info2 = new JLabel("Identificate como usuario", SwingConstants.CENTER);
						
						
						JLabel infoId2 = new JLabel("User: ");
						JLabel infoContra2= new JLabel("Password: ");
						JLabel infoCorreo= new JLabel("Mail: ");
						
						JTextField id2 = new JTextField("");
						JTextField corr = new JTextField("");
						JPasswordField contra2 = new JPasswordField("");
						JCheckBox cbox2 = new JCheckBox("Mostrar contasena");
						contra2.setEchoChar('*');
						cbox2.addActionListener(new ActionListener(){  
							public void actionPerformed(ActionEvent e){
								if(cbox2.isSelected()) {
									contra2.setEchoChar((char)0);
								}
								else {
									contra2.setEchoChar('*');
								}
								
							}
							
							});
						
						
						JPanel panelDatos2 = new JPanel(new GridLayout(4,2));
						
						panelDatos2.add(infoId2);
						panelDatos2.add(id2);
						panelDatos2.add(infoCorreo);
						panelDatos2.add(corr);
						panelDatos2.add(infoContra2);
						panelDatos2.add(contra2);
						panelDatos2.add(cbox2);
						
						
						panelDatos2.setSize(new Dimension (200,150));
						
						
						panelUsuario2.add(panelDatos2, BorderLayout.CENTER);

						panelUsuario2.add(info2, BorderLayout.PAGE_START);
						
						JPanel abajo2 = new JPanel();
						abajo2.setLayout(new BorderLayout());
						
						JButton cancel2 = new JButton("Salir");
						
						cancel2.addActionListener(new ActionListener(){  
							public void actionPerformed(ActionEvent e){
								usuarioNuevo.setVisible(false);
							}
							});
						abajo2.add(cancel2, BorderLayout.WEST);
						
						JButton aceptarC = new JButton("Registra cliente");
						
						aceptarC.addActionListener(new ActionListener(){  
							public void actionPerformed(ActionEvent e){		
								usuarioNuevo.setVisible(false);
								char[] arrayC = contra2.getPassword();
								String pass = new String(arrayC); 
								
								
								_ctrl.registrarse(id2.getText(), pass,corr.getText());
								
						
							}
							});
						JButton aceptarV = new JButton("Registra vendedor");
						
						aceptarV.addActionListener(new ActionListener(){  
							public void actionPerformed(ActionEvent e){		
								usuarioNuevo.setVisible(false);
								char[] arrayC = contra2.getPassword();
								String pass = new String(arrayC); 
								
								_ctrl.registrarseVendedor(id2.getText(), pass,corr.getText());
							}
							});
						
						
						abajo2.add(aceptarC, BorderLayout.EAST);
						abajo2.add(aceptarV,BorderLayout.CENTER);
						panelUsuario2.add(abajo2, BorderLayout.PAGE_END);
						usuarioNuevo.add(panelUsuario2);
						usuarioNuevo.setResizable(false);
						usuarioNuevo.setSize(new Dimension(350, 250));
						usuarioNuevo.setVisible(true);
				
					}
					});
				abajo.add(registrarse,BorderLayout.CENTER);
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
				
				if(!user.esDueno()) {
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
		usuario2 = new JLabel(_ctrl.getS().getUsuarioActual().getUsuario());
		infoUsu.add(usuario2);
		
		JLabel rol1 = new JLabel("Rol:    ");
		infoUsu.add(rol1);
		if(_ctrl.getS().esDueno()) {
			 rol2 = new JLabel("Vendedor");
			infoUsu.add(rol2);
		}else {
			 rol2 = new JLabel("Cliente");
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

	@Override
	public void iniciaSesion(Usuario userActual) {
		
		usuario2.setText(userActual.getUsuario());
		if(userActual.esDueno())rol2.setText("Vendedor");
		else rol2.setText("Cliente");
		this.user=userActual;
		 
	}

}
