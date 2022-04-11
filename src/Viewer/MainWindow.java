package Viewer;

import javax.swing.JFrame;
import javax.swing.JPanel;

import Controller;

public class MainWindow extends JFrame{
	Controller _ctrl;
	public MainWindow(Controller ctrl) {
		super("Physics Simulator");
		_ctrl = ctrl;
		initGUI();
	}
	
	private void initGUI() {
		JPanel mainPanel = new JPanel(new BorderLayout());
		this.setContentPane(mainPanel);
		
		ControlPanel controlP = new ControlPanel(_ctrl);
		mainPanel.add(controlP, BorderLayout.PAGE_START);
		
		StatusBar barraEstado = new StatusBar(_ctrl);
		mainPanel.add(barraEstado, BorderLayout.PAGE_END);
		
		JPanel centerPanel = new JPanel();
		
		centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));	
		
		mainPanel.add(centerPanel, BorderLayout.CENTER);
		
		BodiesTable tablaCuerpos = new BodiesTable(_ctrl);
		masCercanoTable mCT = new masCercanoTable(_ctrl);
		
		centerPanel.add(tablaCuerpos);
		centerPanel.add(mCT);
		centerPanel.setBackground(Color.WHITE);
		
		Viewer viewer = new Viewer(_ctrl);
		centerPanel.add(viewer);
		
		viewer.setPreferredSize(new Dimension(500, 500));
			
		this.setPreferredSize(new Dimension(900, 700));
		this.pack();
		this.setVisible(true);
	}
}