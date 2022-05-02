package Viewer;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import controller.Controller;
import model.Botas;
import model.CamisetaLocal;
import model.CamisetaVisitante;
import model.ConjuntoLocal;
import model.ConjuntoVisitante;
import model.Guantes;
import model.InventarioObserver;
import model.PantalonChandal;
import model.PantalonCorto;
import model.Producto;

public class PantallaInventario extends JPanel implements InventarioObserver {
	private static final long serialVersionUID = 1L;
	private Controller _ctrl;
	

	
	PantallaInventario(Controller ctrl) {
			_ctrl = ctrl;
			initGUI();
			_ctrl.addObserver(this);
	}
	
	private void resumenCompras() {
		JDialog resumenCompras = new JDialog();
		JPanel panelCompras = new JPanel(new BorderLayout());
		resumenCompras.setTitle("Resumen de compras");
		
		JLabel infoc = new JLabel("Compras: ", SwingConstants.CENTER);
		panelCompras.add(infoc, BorderLayout.PAGE_START);
	
		JPanel panelDatosCompras = new JPanel();
		
		BoxLayout datosCompras= new BoxLayout(panelDatosCompras, BoxLayout.PAGE_AXIS);
		panelDatosCompras.setLayout(datosCompras);
		
		JScrollPane panelScrollCompras = new JScrollPane(panelDatosCompras, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
		String titColumnaCompras[]  = {"Id", "Metodo pago", "Cliente", "Unidades vendidas"};
		
		DefaultTableModel modeloCompras = new DefaultTableModel();
		modeloCompras.setColumnIdentifiers(titColumnaCompras);
		
		JTable tablaCompras = new JTable(modeloCompras);
		
		tablaCompras.setShowHorizontalLines( false );
	    tablaCompras.setRowSelectionAllowed( false );
	    tablaCompras.setColumnSelectionAllowed( false );
	    
	    tablaCompras.setSelectionForeground( Color.white );
	    tablaCompras.setSelectionBackground( Color.red );
	    
	    for(int j = 0; j < modeloCompras.getRowCount(); j++) {
			modeloCompras.removeRow(j);
		}
	    
	    for(int i = 0; i < _ctrl.getI().getCompras().size(); i++) {
	    	String IdCompras = _ctrl.getI().getCompras().get(i).getId();
	    	String MetodoPago = _ctrl.getI().getCompras().get(i).getPago();
	    	String Cliente = _ctrl.getI().getCompras().get(i).getCliente();
	    	String UnidadesVendidas = Integer.toString(_ctrl.getI().getCompras().get(i).getCarrito());
	    	
	    	String fila[] = {IdCompras, MetodoPago, Cliente, UnidadesVendidas};
	    	modeloCompras.addRow(fila);
	    }
	    
	    panelDatosCompras.add(new JScrollPane(tablaCompras, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED), BorderLayout.CENTER);
	    panelCompras.add(panelScrollCompras, BorderLayout.CENTER);
	    
	    resumenCompras.add(panelCompras);
	    resumenCompras.setPreferredSize(new Dimension(500, 300));
	    resumenCompras.pack();
	    resumenCompras.setResizable(false);
	    resumenCompras.setVisible(true);
	}
	
	private void initGUI() {
		
		
		JComboBox<String> tll = new JComboBox<String>();
		String[] tallas= {"XS" ,"S", "M", "L", "XL"}; //Hacer tallas disponibles en cada articulo
		for(int i = 0; i < tallas.length; i++) {
			tll.addItem(tallas[i]);
		}
		
		JComboBox<String> tllb = new JComboBox<String>();
		String[] tallasb= {"38" ,"39", "40", "41", "42"}; //Hacer tallas disponibles en cada articulo
		for(int i = 0; i < tallasb.length; i++) {
			tllb.addItem(tallasb[i]);
		}
		
		JComboBox<String> publ = new JComboBox<String>();
		String[] publi= {"SI" ,"NO"}; //Hacer tallas disponibles en cada articulo
		for(int i = 0; i < publi.length; i++) {
			publ.addItem(publi[i]);
		}
		
		JComboBox<String> pant = new JComboBox<String>();
		String[] pop= {"Pantalon Chandal" ,"Pantalon Corto"}; //Hacer tallas disponibles en cada articulo
		for(int i = 0; i < pop.length; i++) {
			pant.addItem(pop[i]);
		}
		

		JComboBox<String> cyc = new JComboBox<String>();
		String[] camcon= {"Camiseta Local" ,"Camiseta Visitante","Conjunto Local", "Conjunto Visitante"}; //Hacer tallas disponibles en cada articulo
		for(int i = 0; i < camcon.length; i++) {
			cyc.addItem(camcon[i]);
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
		
		
		DefaultTableModel modeloInv = new DefaultTableModel();
		modeloInv.setColumnIdentifiers(titColumnaInv);
		
		JTable tablaInv = new JTable(modeloInv);
		
		tablaInv.setShowHorizontalLines( false );
	    tablaInv.setRowSelectionAllowed( false );
	    tablaInv.setColumnSelectionAllowed( false );
		
	    tablaInv.setSelectionForeground( Color.white );
	    tablaInv.setSelectionBackground( Color.red );
	    
	    for(int j = 0; j < modeloInv.getRowCount(); j++) modeloInv.removeRow(j);
	    
	    for(int i = 0; i < _ctrl.getI().getInventario().size(); i++) {
	    	String IdInv = _ctrl.getI().getInventario().get(i).mostrarEnInv()[0];
	    	String DetallesInv = _ctrl.getI().getInventario().get(i).mostrarEnInv()[1];
	    	String Precioinv = _ctrl.getI().getInventario().get(i).mostrarEnInv()[2];
	    	String Stockinv = _ctrl.getI().getInventario().get(i).mostrarEnInv()[3];
	    	String fila[] = {IdInv, DetallesInv, Precioinv, Stockinv};
			modeloInv.addRow(fila);
	    }
		
	    panelDatosInventario.add(tablaInv);
		
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
		
		
		//HU Resumen de compras
		JButton Bcompras = new JButton("Resumen Compras");
		
		Bcompras.addActionListener(new ActionListener(){  
			public void actionPerformed(ActionEvent e){	
				inventario.setVisible(false);
				resumenCompras();
			}
		});
		
		barraInv.add(Bcompras);
		
       JButton BAbastecer = new JButton("Anadir producto");
		
		BAbastecer.addActionListener(new ActionListener(){  
			public void actionPerformed(ActionEvent e){		
				JDialog abastecer = new JDialog();
				abastecer.setVisible(true);
				abastecer.setSize(new Dimension(600, 400));
				JPanel panelabastecer= new JPanel();
				
				panelabastecer.setLayout(new GridLayout(6,1));
				
				JLabel info = new JLabel("Seleccione el producto que desee anadir", SwingConstants.CENTER);
				
				JButton bcami = new JButton ("Camiseta o Conjunto");
				JButton bpant = new JButton ("Patalon");
				JButton bbotas = new JButton ("Botas");
				JButton bguantes = new JButton ("Guantes");
				
				panelabastecer.add(info);
				
				bcami.addActionListener(new ActionListener(){  
					public void actionPerformed(ActionEvent e){
						info.setVisible(false);
						JDialog camiseta = new JDialog();
						JPanel pcami = new JPanel(new BorderLayout());
						
						JLabel c1 = new JLabel("Id: ");
						JLabel c2 = new JLabel("Nombre: ");
						JLabel c3 = new JLabel("Dorsal: ");
						JLabel c4 = new JLabel("Talla: ");
						JLabel c5 = new JLabel("Precio: ");
						JLabel c6 = new JLabel("Publicado: ");
						JLabel c7 = new JLabel("Stock: ");
						
					
						JTextField cp2 = new JTextField("");
						JTextField cp3 = new JTextField("");
						JTextField cp4 = new JTextField("");
						JTextField cp5 = new JTextField("");
						
						JPanel pdc = new JPanel(new GridLayout(7,1));
						
						pdc.add(c1);
						pdc.add(cyc);
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
						
						JPanel cab = new JPanel(new BorderLayout());
						
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
								boolean publicado;
								if(publ.getSelectedItem().equals("SI")) publicado=true;
								else publicado=false;
								
								Producto a;
								try {
									if(cyc.getSelectedItem().equals("CamLocal")) {
										 a = new CamisetaLocal( 
												Double.parseDouble(cp4.getText()),
												publicado, 
												Integer.parseInt(cp5.getText()),
														0, 0, 
												tll.getSelectedItem().toString(),cp2.getText(),
												Integer.parseInt(cp3.getText().toString()));
									} 
									else if(cyc.getSelectedItem().equals("CamVisitante")) {
										a = new CamisetaVisitante( 
												Double.parseDouble(cp4.getText()),
												publicado, 
												Integer. parseInt(cp5.getText()),
														0, 0, 
												tll.getSelectedItem().toString(),cp2.getText(),
												Integer.parseInt(cp3.getText().toString()));
									} 
									else if(cyc.getSelectedItem().equals("ConLocal")) {
										a = new ConjuntoLocal( 
												Double.parseDouble(cp4.getText()),
												publicado, 
												Integer.parseInt(cp5.getText()),
														0, 0, 
												tll.getSelectedItem().toString(),cp2.getText(),
												Integer.parseInt(cp3.getText().toString()));
									} 
									else {
										a = new ConjuntoVisitante( 
												Double.parseDouble(cp4.getText()),
												publicado, 
												Integer.parseInt(cp5.getText()),
														0, 0, 
												tll.getSelectedItem().toString(),cp2.getText(),
												Integer.parseInt(cp3.getText().toString()));
										
									}
									JOptionPane.showMessageDialog(null, "Producto anadido exitosamente",
										      "Confirmacion", JOptionPane.INFORMATION_MESSAGE);
									_ctrl.getI().add(a);} catch(Exception eror) {
										 JOptionPane.showMessageDialog(null, "Los datos introducidos no son correctos", 
												 "Error", JOptionPane.ERROR_MESSAGE);
									 }
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
						JPanel ppant = new JPanel(new BorderLayout());
						
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
								if(publ.getSelectedItem().equals("SI")) publicado=true;
								else publicado=false;
								Producto a;
								try {
								
								if(pant.getSelectedItem().equals("PantCorto")) {
									 a = new PantalonCorto( 
											Double.parseDouble(cp4.getText()),
											publicado, 
											Integer.parseInt(cp5.getText()),
													0, 0, 
											tll.getSelectedItem().toString(),
											Integer.parseInt(cp3.getText().toString()));
									 
									 System.out.print(publicado);
									 publ.getAccessibleContext().toString();
								} else {
									a = new PantalonChandal( 
											Double.parseDouble(cp4.getText()),
											publicado, 
											Integer. parseInt(cp5.getText()),
													0, 0, 
											tll.getSelectedItem().toString(),
											Integer.parseInt(cp3.getText().toString()));
								} 
								 _ctrl.getI().add(a);
								 JOptionPane.showMessageDialog(null, "Producto anadido exitosamente",
									      "Confirmacion", JOptionPane.INFORMATION_MESSAGE); 
								} catch(Exception eror) {
									JOptionPane.showMessageDialog(null, "Los datos introducidos no son correctos",
										      "Error", JOptionPane.ERROR_MESSAGE);
								 }
					
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
				
				bbotas.addActionListener(new ActionListener(){  
					public void actionPerformed(ActionEvent e){
						info.setVisible(false);
						JDialog botas = new JDialog();
						JPanel pbotas = new JPanel(new BorderLayout());
						
						JLabel c2 = new JLabel("Precio: ");
						JLabel c3 = new JLabel("Talla: ");
						JLabel c4 = new JLabel("Modelo: ");
						JLabel c5 = new JLabel("Marca: ");
						JLabel c6 = new JLabel("Color: ");
						JLabel c7 = new JLabel("Publicado: ");
						JLabel c8 = new JLabel("Stock: ");
						
						JTextField cp2 = new JTextField("");
						JTextField cp3 = new JTextField("");
						JTextField cp4 = new JTextField("");
						JTextField cp5 = new JTextField("");
						JTextField cp6 = new JTextField("");
						
						JPanel pdc = new JPanel(new GridLayout(7,1));
						
						pdc.add(c2);
						pdc.add(cp2);
						pdc.add(c3);
						pdc.add(tllb);
						pdc.add(c4);
						pdc.add(cp3);
						pdc.add(c5);
						pdc.add(cp4);
						pdc.add(c6);
						pdc.add(cp5);
						pdc.add(c7);
						pdc.add(publ);
						pdc.add(c8);
						pdc.add(cp6);
						
						
						pbotas.add(pdc, BorderLayout.CENTER);

						pbotas.add(info, BorderLayout.PAGE_START);
						
						JPanel cab = new JPanel();
						cab.setLayout(new BorderLayout());
						
						JButton cancel = new JButton("Salir");
						
						cancel.addActionListener(new ActionListener(){  
							public void actionPerformed(ActionEvent e){
								botas.setVisible(false);
							}
							});
						cab.add(cancel, BorderLayout.WEST);
						
						JButton caa = new JButton("Aceptar");
						
						caa.addActionListener(new ActionListener(){  
							public void actionPerformed(ActionEvent e){
								boolean publicado;
								if(publ.getSelectedItem().equals("SI")) publicado=true;
								else publicado=false;
								Producto a;
								
								try {
									a = new Botas( 
											Double.parseDouble(cp2.getText()),
											publicado, 
											Integer. parseInt(cp6.getText()),
													0, 0, 
													Integer.parseInt(tllb.getSelectedItem().toString()),
											cp3.getText(), cp4.getText(), cp5.getText());
									        _ctrl.getI().add(a);
									        JOptionPane.showMessageDialog(null, "Producto anadido exitosamente",
												      "Confirmaci�n", JOptionPane.INFORMATION_MESSAGE);
									       
									 
								} catch(Exception eror) {
												JOptionPane.showMessageDialog(null, "Los datos introducidos no son correctos",
													      "Error", JOptionPane.ERROR_MESSAGE);
											}
								
								
					
								//_ctrl.getI().add();
								//se llama a la funcion que inicie sesion
							}
						});
						cab.add(caa, BorderLayout.EAST);
						pbotas.add(cab, BorderLayout.PAGE_END);
						
						botas.add(pbotas);
						botas.setResizable(false);
						botas.setSize(new Dimension(600, 300));
						botas.setVisible(true);
						
						
					}
					});
		
				panelabastecer.add(bbotas);

				bguantes.addActionListener(new ActionListener(){  
					public void actionPerformed(ActionEvent e){
						info.setVisible(false);
						JDialog guantes = new JDialog();
						JPanel pguantes = new JPanel(new BorderLayout());
						
						JLabel c2 = new JLabel("Precio: ");
						JLabel c3 = new JLabel("Talla: ");
						JLabel c4 = new JLabel("Modelo: ");
						JLabel c5 = new JLabel("Marca: ");
						JLabel c6 = new JLabel("Color: ");
						JLabel c7 = new JLabel("Adherencia: ");
						JLabel c8 = new JLabel("Publicado: ");
						JLabel c9 = new JLabel("Stock: ");
						
						JTextField cp2 = new JTextField("");
						JTextField cp3 = new JTextField("");
						JTextField cp4 = new JTextField("");
						JTextField cp5 = new JTextField("");
						JTextField cp6 = new JTextField("");
						JTextField cp7 = new JTextField("");
						
						JPanel pdc = new JPanel(new GridLayout(8,1));
						
						pdc.add(c2);
						pdc.add(cp2);
						pdc.add(c3);
						pdc.add(tll);
						pdc.add(c4);
						pdc.add(cp3);
						pdc.add(c5);
						pdc.add(cp4);
						pdc.add(c6);
						pdc.add(cp5);
						pdc.add(c7);
						pdc.add(cp6);
						pdc.add(c8);
						pdc.add(publ);
						pdc.add(c9);
						pdc.add(cp7);
						
						
						pguantes.add(pdc, BorderLayout.CENTER);

						pguantes.add(info, BorderLayout.PAGE_START);
						
						JPanel cab = new JPanel(new BorderLayout());
						
						JButton cancel = new JButton("Salir");
						
						cancel.addActionListener(new ActionListener(){  
							public void actionPerformed(ActionEvent e){
								guantes.setVisible(false);
							}
						});
						cab.add(cancel, BorderLayout.WEST);
						
						JButton caa = new JButton("Aceptar");
						
						caa.addActionListener(new ActionListener(){  
							public void actionPerformed(ActionEvent e){
								boolean publicado;
								if(publ.getSelectedItem().equals("SI")) publicado=true;
								else publicado=false;
								Producto a;
								
								try {
									a = new Guantes( 
											Double.parseDouble(cp2.getText()),
											publicado, 
											Integer.parseInt(cp7.getText()),
													0, 0, 
													tll.getSelectedItem().toString(),
											cp3.getText(), cp4.getText(), cp5.getText(), Integer.parseInt(cp6.getText()));
									        _ctrl.getI().add(a);
									        JOptionPane.showMessageDialog(null, "Producto anadido exitosamente",
												      "Confirmacion", JOptionPane.INFORMATION_MESSAGE);
									       
									 
								} catch(Exception eror) {
												JOptionPane.showMessageDialog(null, "Los datos introducidos no son correctos",
													      "Error", JOptionPane.ERROR_MESSAGE);
											}
								
								
					
								//_ctrl.getI().add();
								//se llama a la funcion que inicie sesion
							}
						});
						cab.add(caa, BorderLayout.EAST);
						pguantes.add(cab, BorderLayout.PAGE_END);
						
						guantes.add(pguantes);
						guantes.setResizable(false);
						guantes.setSize(new Dimension(600, 300));
						guantes.setVisible(true);
					}
				});
				panelabastecer.add(bguantes);

				abastecer.add(panelabastecer);
			}
		});
		
		barraInv.add(BAbastecer);
		
		JButton BCambiarPrecio = new JButton("Cambiar Precio");
		
		BCambiarPrecio.addActionListener(new ActionListener(){  
			public void actionPerformed(ActionEvent e){
				for(int i=0;i<_ctrl.getI().getInventario().size(); i++) {
				_ctrl.getI().setPrecio(i, Double.parseDouble(modeloInv.getValueAt(i, 3).toString()));
				}
			}
		});
		
		barraInv.add(BCambiarPrecio);
		
		
		panelInventario.add(barraInv, BorderLayout.PAGE_START);
		
		inventario.add(panelInventario);
		inventario.setSize(new Dimension(600, 400));
		if(_ctrl.getS().esDueno()) inventario.setVisible(true);
	}
	
	


	@Override
	public void onRegistroTienda(ArrayList<Producto> inventario) {
		
		
	}

	@Override
	public void onActualizaTienda(ArrayList<Producto> inventario) {
		
	}

	@Override
	public void onCambiarPrecio(ArrayList<Producto> inventario) {
		this.removeAll();
		this.updateUI();
		initGUI();	
	}

}