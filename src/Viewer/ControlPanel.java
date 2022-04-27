package Viewer;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
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

import javax.swing.BorderFactory;
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
	
	private void initGUI() {
        
		JComboBox<String> tll = new JComboBox<String>();
		String[] tallas= {"XS" ,"S", "M", "L", "XL"}; //Hacer tallas disponibles en cada articulo
		for(int i = 0; i < tallas.length; i++) {
			tll.addItem(tallas[i]);
		}
		
		JComboBox<String> publ = new JComboBox<String>();
		String[] publi= {"SI" ,"NO"}; //Hacer tallas disponibles en cada articulo
		for(int i = 0; i < publi.length; i++) {
			publ.addItem(publi[i]);
		}
		
		JComboBox<String> pant = new JComboBox<String>();
		String[] pop= {"PantChandal" ,"PantCorto"}; //Hacer tallas disponibles en cada articulo
		for(int i = 0; i < pop.length; i++) {
			pant.addItem(pop[i]);
		}
		
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
	
		
		//2
		Binventario.addActionListener(new ActionListener(){  
			public void actionPerformed(ActionEvent e){ 
				JDialog inventario = new JDialog();
				JPanel panelInventario = new JPanel();
				panelInventario.setLayout(new BorderLayout());
				
				JLabel infoi = new JLabel("Inventario: ", SwingConstants.CENTER);
				panelInventario.add(infoi, BorderLayout.PAGE_START);
				
				JPanel panelDatosInventario = new JPanel(); 
				
				BoxLayout datosInventario= new BoxLayout(panelDatosInventario, BoxLayout.PAGE_AXIS);
				panelDatosInventario.setLayout(datosInventario);
				
				JScrollPane panelScrollDatos = new JScrollPane(panelDatosInventario, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
						JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
				
				
				
				String titColumnaInv[]  = {"Id", "Detalles","Stock","Precio"};
				//String titColumnaCompras[]  = {"Id", "Unidades Vendidas"};
				
				
				DefaultTableModel modeloInv = new DefaultTableModel();
				modeloInv.setColumnIdentifiers(titColumnaInv);
				//DefaultTableModel modeloCompras = new DefaultTableModel();
				//modeloInv.setColumnIdentifiers(titColumnaCompras);
				
				JTable tablaInv = new JTable(modeloInv);
				//JTable tablaCompras = new JTable(modeloCompras); 
				
				tablaInv.setShowHorizontalLines( false );
			    tablaInv.setRowSelectionAllowed( false );
			    tablaInv.setColumnSelectionAllowed( false );
			    
//			    tablaCompras.setShowHorizontalLines( false );
//			    tablaCompras.setRowSelectionAllowed( false );
//			    tablaCompras.setColumnSelectionAllowed( false );
				
			    tablaInv.setSelectionForeground( Color.white );
			    tablaInv.setSelectionBackground( Color.red );
//			    
//			    tablaCompras.setSelectionForeground( Color.white );
//			    tablaCompras.setSelectionBackground( Color.red );
			    
			    for(int j = 0; j < modeloInv.getRowCount(); j++) {
					modeloInv.removeRow(j);
					
				}
			    
//			    for(int j = 0; j < modeloInv.getRowCount(); j++) {
//					modeloCompras.removeRow(j);
//					
//				}
			    
			  
			    
			    for(int i = 0; i < _ctrl.getI().getProductos().size(); i++) {
			    	String IdInv = _ctrl.getI().getProductos().get(i).mostrarEnInv()[0];
			    	String DetallesInv = _ctrl.getI().getProductos().get(i).mostrarEnInv()[1];
			    	String Precioinv = _ctrl.getI().getProductos().get(i).mostrarEnInv()[2];
			    	String Stockinv = _ctrl.getI().getProductos().get(i).mostrarEnInv()[3];
			    	String fila[] = {IdInv, DetallesInv, Precioinv, Stockinv};
					modeloInv.addRow(fila);
			    }
			    
			   
			    
			 
			    
				
			    panelDatosInventario.add(new JScrollPane(tablaInv, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
						JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED), BorderLayout.CENTER);
				
				
				
				panelInventario.add(panelScrollDatos, BorderLayout.CENTER);

			
				JPanel barraInv = new JPanel();
				barraInv.setLayout(new GridLayout(1, 3));
	
				
				JButton cancel = new JButton("Salir");
				
				cancel.addActionListener(new ActionListener(){  
					public void actionPerformed(ActionEvent e){
						inventario.setVisible(false);
					}
					});
				
				barraInv.add(cancel);
				
				JButton Bcompras = new JButton("Resumen Compras");
				
				Bcompras.addActionListener(new ActionListener(){  
					public void actionPerformed(ActionEvent e){		
						JDialog compras = new JDialog();
						compras.setVisible(true);
						JPanel panelcompras= new JPanel();
						//panelcompras.add(tablaCompras);
						compras.add(panelcompras);
					}
					});
				
				barraInv.add(Bcompras);
				
               JButton BAbastecer = new JButton("Abastecer");
				
				BAbastecer.addActionListener(new ActionListener(){  
					public void actionPerformed(ActionEvent e){		
						JDialog abastecer = new JDialog();
						abastecer.setVisible(true);
						abastecer.setSize(new Dimension(600, 400));
						JPanel panelabastecer= new JPanel();
						
						panelabastecer.setLayout(new GridLayout(6,1));
						
						JLabel info = new JLabel("Abastecer inventario. Seleccione el producto", SwingConstants.CENTER);
						
						JButton bcami = new JButton ("Camiseta");
						JButton bpant = new JButton ("Patalon");
						JButton bconj = new JButton ("Conjunto");
						JButton bbotas = new JButton ("Botas");
						JButton bguantes = new JButton ("Guantes");
						
						panelabastecer.add(info);
						
						bcami.addActionListener(new ActionListener(){  
							public void actionPerformed(ActionEvent e){
								info.setVisible(false);
								JDialog camiseta = new JDialog();
								JPanel pcami = new JPanel();
								pcami.setLayout(new BorderLayout());
								
								JLabel c1 = new JLabel("Id: ");
								JLabel c2 = new JLabel("Nombre: ");
								JLabel c3 = new JLabel("Dorsal: ");
								JLabel c4 = new JLabel("Talla: ");
								JLabel c5 = new JLabel("Precio: ");
								JLabel c6 = new JLabel("Publicado: ");
								JLabel c7 = new JLabel("Stock: ");
								
								JTextField cp1 = new JTextField("");
								JTextField cp2 = new JTextField("");
								JTextField cp3 = new JTextField("");
								JTextField cp4 = new JTextField("");
								JTextField cp5 = new JTextField("");
								
								JPanel pdc = new JPanel(new GridLayout(7,1));
								
								pdc.add(c1);
								pdc.add(cp1);
								pdc.add(c2);
								pdc.add(cp2);
								pdc.add(c3);
								pdc.add(cp3);
								pdc.add(c4);
								pdc.add(tll);
								pdc.add(c5);
								pdc.add(cp4);
								pdc.add(c6);
								pdc.add(publ);
								pdc.add(c7);
								pdc.add(cp5);
								
								
								
								pcami.add(pdc, BorderLayout.CENTER);

								pcami.add(info, BorderLayout.PAGE_START);
								
								JPanel cab = new JPanel();
								cab.setLayout(new BorderLayout());
								
								JButton cancel = new JButton("Salir");
								
								cancel.addActionListener(new ActionListener(){  
									public void actionPerformed(ActionEvent e){
										camiseta.setVisible(false);
									}
									});
								cab.add(cancel, BorderLayout.WEST);
								
								JButton caa = new JButton("Aceptar");
								
								caa.addActionListener(new ActionListener(){  
									public void actionPerformed(ActionEvent e){		
										camiseta.setVisible(false);
										//se llama a la funcion que inicie sesion
									}
									});
								cab.add(caa, BorderLayout.EAST);
								pcami.add(cab, BorderLayout.PAGE_END);
								
								camiseta.add(pcami);
								camiseta.setResizable(false);
								camiseta.setSize(new Dimension(600, 300));
								camiseta.setVisible(true);
								
								
							}
							});
						
						panelabastecer.add(bcami);
						
						bpant.addActionListener(new ActionListener(){  
							public void actionPerformed(ActionEvent e){
								info.setVisible(false);
								JDialog pantalones = new JDialog();
								JPanel ppant = new JPanel();
								ppant.setLayout(new BorderLayout());
								
								JLabel c1 = new JLabel("Id: ");
								JLabel c3 = new JLabel("Dorsal: ");
								JLabel c4 = new JLabel("Talla: ");
								JLabel c5 = new JLabel("Precio: ");
								JLabel c6 = new JLabel("Publicado: ");
								JLabel c7 = new JLabel("Stock: ");
								
							
								JTextField cp3 = new JTextField("");
								JTextField cp4 = new JTextField("");
								JTextField cp5 = new JTextField("");
								
								JPanel pdc = new JPanel(new GridLayout(7,1));
								
								pdc.add(c1);
								pdc.add(pant);
								pdc.add(c3);
								pdc.add(cp3);
								pdc.add(c4);
								pdc.add(tll);
								pdc.add(c5);
								pdc.add(cp4);
								pdc.add(c6);
								pdc.add(publ);
								pdc.add(c7);
								pdc.add(cp5);
								
								
								
								ppant.add(pdc, BorderLayout.CENTER);

								ppant.add(info, BorderLayout.PAGE_START);
								
								JPanel cab = new JPanel();
								cab.setLayout(new BorderLayout());
								
								JButton cancel = new JButton("Salir");
								
								cancel.addActionListener(new ActionListener(){  
									public void actionPerformed(ActionEvent e){
										pantalones.setVisible(false);
									}
									});
								cab.add(cancel, BorderLayout.WEST);
								
								JButton caa = new JButton("Aceptar");
								
								caa.addActionListener(new ActionListener(){  
									public void actionPerformed(ActionEvent e){
										boolean publicado;
										if(publ.getAccessibleContext().toString().equals("SI")) {
											publicado=true;
										} else {
											publicado=false;
										} 
										Producto a;
										
										if(publ.getAccessibleContext().toString().equals("PantCorto")) {
											 a = new PantalonCorto( 
													Double.parseDouble(cp4.getText()),
													publicado, 
													Integer.parseInt(cp5.getText()),
															0, 0, 
													tll.getSelectedItem().toString(),
													Integer.parseInt(cp3.getText().toString()));
										} else {
											a = new PantalonChandal( 
													Double.parseDouble(cp4.getText()),
													publicado, 
													Integer.parseInt(cp5.getText()),
															0, 0, 
													tll.getSelectedItem().toString(),
													Integer.parseInt(cp3.getText().toString()));
										} 
										 _ctrl.getI().add(a);
							
										//_ctrl.getI().add();
										//se llama a la funcion que inicie sesion
									}
									});
								cab.add(caa, BorderLayout.EAST);
								ppant.add(cab, BorderLayout.PAGE_END);
								
								pantalones.add(ppant);
								pantalones.setResizable(false);
								pantalones.setSize(new Dimension(600, 300));
								pantalones.setVisible(true);
								
								
							}
							});
						
						panelabastecer.add(bpant);
						
						
						panelabastecer.add(bconj);
						panelabastecer.add(bbotas);
						panelabastecer.add(bguantes);
						
						
						
						
						//panelcompras.add(tablaCompras);
						abastecer.add(panelabastecer);
					}
					});
				
				barraInv.add(BAbastecer);
				
				panelInventario.add(barraInv, BorderLayout.PAGE_START);
				
				inventario.add(panelInventario);
				//carrito.setResizable(false);
				inventario.setSize(new Dimension(600, 400));
				inventario.setVisible(true);
		
			}
			});
		
		
		this.add(Bcarrito);	
		this.add(Busuario);
		this.add(Binventario);
		
		JPanel infoUsu = new JPanel(new GridLayout(3,2));
		
		JLabel usuario1 = new JLabel("Usuario activo:    ");
		infoUsu.add(usuario1);
		JLabel usuario2 = new JLabel("Pepito Flores");
		infoUsu.add(usuario2);
		
		JLabel rol1 = new JLabel("Rol:    ");
		infoUsu.add(rol1);
		JLabel rol2 = new JLabel("Adminstrador");
		infoUsu.add(rol2);
		
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

}
