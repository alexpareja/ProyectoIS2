package Viewer;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

import controller.Controller;

public class MainWindow extends JFrame{
	private static final long serialVersionUID = 1L;
	Controller _ctrl;
	public MainWindow(Controller ctrl) {
		super("");
		_ctrl = ctrl;
		initGUI();
	}
	
	private void initGUI() {
		JPanel mainPanel = new JPanel(new BorderLayout());
		this.setContentPane(mainPanel);
		
		ControlPanel controlP = new ControlPanel(_ctrl);
		mainPanel.add(controlP, BorderLayout.PAGE_START);
		
		BarraInferior barraInf = new BarraInferior(_ctrl);
		mainPanel.add(barraInf, BorderLayout.PAGE_END);
		
		PantallaTienda tienda = new PantallaTienda(_ctrl);
		
		//tienda.setLayout(new BoxLayout(tienda, BoxLayout.LINE_AXIS));	
		
		mainPanel.add(tienda, BorderLayout.CENTER);
		/*
		BodiesTable tablaCuerpos = new BodiesTable(_ctrl);
		masCercanoTable mCT = new masCercanoTable(_ctrl);
		
		centerPanel.add(tablaCuerpos);
		centerPanel.add(mCT);
		centerPanel.setBackground(Color.WHITE);
		
		Viewer viewer = new Viewer(_ctrl);
		centerPanel.add(viewer);
		*/

		this.setTitle("Tienda de articulos de futbol");
		this.setPreferredSize(new Dimension(950, 750));
		this.pack();
		this.setVisible(true);
	}
}
