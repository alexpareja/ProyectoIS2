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
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import controller.Controller;
import model.InventarioObserver;
import model.PantalonChandal;
import model.PantalonCorto;
import model.Producto;

public class PantallaInventario extends JPanel implements InventarioObserver {
	// ...
		private Controller _ctrl;
		
	
		
		PantallaInventario(Controller ctrl) {
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
		    
//		    tablaCompras.setShowHorizontalLines( false );
//		    tablaCompras.setRowSelectionAllowed( false );
//		    tablaCompras.setColumnSelectionAllowed( false );
			
		    tablaInv.setSelectionForeground( Color.white );
		    tablaInv.setSelectionBackground( Color.red );
//		    
//		    tablaCompras.setSelectionForeground( Color.white );
//		    tablaCompras.setSelectionBackground( Color.red );
		    
		    for(int j = 0; j < modeloInv.getRowCount(); j++) {
				modeloInv.removeRow(j);
				
			}
		    
//		    for(int j = 0; j < modeloInv.getRowCount(); j++) {
//				modeloCompras.removeRow(j);
//				
//			}
		    
		  
		    
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
			
			JButton BCambiarPrecio = new JButton("Cambiar Precio");
			
			BCambiarPrecio.addActionListener(new ActionListener(){  
				public void actionPerformed(ActionEvent e){
					for(int i=0;i<_ctrl.getI().getProductos().size(); i++) {
					_ctrl.getI().getProductos().get(i).setPrecio(Double.parseDouble(modeloInv.getValueAt(i, 3).toString()));
					System.out.print(Double.parseDouble(modeloInv.getValueAt(i, 3).toString()));}
				}
				});
			
			barraInv.add(BCambiarPrecio);
			
			
			panelInventario.add(barraInv, BorderLayout.PAGE_START);
			
			inventario.add(panelInventario);
			//carrito.setResizable(false);
			inventario.setSize(new Dimension(600, 400));
			inventario.setVisible(true);}
		
		


		@Override
		public void onRegistroTienda(ArrayList<Producto> inventario) {
			
			
		}

		@Override
		public void onActualizaTienda(ArrayList<Producto> inventario) {
			
		}

		@Override
		public void onCambiarPrecio(ArrayList<Producto> inventario) {
			// TODO Auto-generated method stub
			this.removeAll();
			this.updateUI();
			initGUI();	
		}

}