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
	private JButton dcha = new JButton();
	private Controller _ctrl;

	BarraInferior(Controller ctrl) {
		initGUI();
		ctrl.addObserver(this);
		_ctrl = ctrl;
	}

	// Se incia la interfaz con un BorderLayout y se añaden los botones de las
	// flechas
	private void initGUI() {
		this.setLayout(new BorderLayout());
		izq.setText("<=");
		dcha.setText("=>");
		izq.setFocusable(false);
		dcha.setFocusable(false);
		// Si se pulsa el boton izq se pasa pagina a la izquierda
		izq.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				_ctrl.getT().desplazaIzq();

			}
		});
		// Si se pulsa el boton dcha se pasa pagina a la derecha
		dcha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				_ctrl.getT().desplazaDer();
			}
		});

		this.add(izq, BorderLayout.WEST);
		this.add(dcha, BorderLayout.EAST);
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
