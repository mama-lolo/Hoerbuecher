package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import dataSelectionPanel.DataSelectionPanel;
/**
 * This is the actual MainWindow with included JPanels with differing content
 * @author Malte
 *
 */
public class MainFrame extends JFrame {
	//gets the programmpath
	private final String path = MainFrame.class.getProtectionDomain().getCodeSource().getLocation().getPath();
	//List to store the different views
	private ArrayList<JPanel> panels = new ArrayList<JPanel>();
	//Creating the different panels
	DataSelectionPanel dataSelect = new DataSelectionPanel(path);
	DataSelectionPanel testPanel = new DataSelectionPanel("Test");
	int currentState = 0;
	Scanner s = new Scanner(System.in);
	
	public MainFrame() {
		super("MP3-HoerbuchHandler");
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		panels.add(dataSelect);
		this.setResizable(false);
		//Move Window to center
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (d.width - getSize().width) / 2;
		int y = (d.height - getSize().height) / 2;
		setLocation(x, y);
		
		this.getContentPane().add(dataSelect,BorderLayout.CENTER);
		this.pack();
		setVisible(true);
	}
	
	

	public static void main(String[] args) {
		new MainFrame();
	}

}
