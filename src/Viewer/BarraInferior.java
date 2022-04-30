package Viewer;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;

import controller.Controller;
import model.InventarioObserver;
import model.Producto;

public class BarraInferior extends JPanel implements InventarioObserver {
	private static final long serialVersionUID = 1L;
	private JButton izq = new JButton(); 
	private JButton dcha  = new JButton(); 
	private Controller _ctrl;
	
	BarraInferior(Controller ctrl) {
		
		initGUI();
		ctrl.addObserver(this);
		_ctrl = ctrl;
	}
	private void initGUI() {
		this.setLayout( new BorderLayout());
		izq.setText("<-");
		dcha.setText("->");
		izq.addActionListener(new ActionListener(){  
			public void actionPerformed(ActionEvent e){		
				_ctrl.getT().desplazaIzq();
				
			}
			});
		
		dcha.addActionListener(new ActionListener(){  
			public void actionPerformed(ActionEvent e){		
				_ctrl.getT().desplazaDer();
			}
			});
		
		this.add(izq, BorderLayout.WEST);
		this.add(dcha, BorderLayout.EAST);
		// TODO complete the code to build the tool bar
	}
	// other private/protected methods
	// ...
	// SimulatorObserver methods
	// ...
	
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

