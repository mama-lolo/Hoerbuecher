package dataSelectionPanel;

import java.awt.BorderLayout;
import java.io.File;

import javax.swing.DefaultListModel;
import javax.swing.DefaultListSelectionModel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;

/**
 * This is the Panel in which the user chooses the data to go through
 * @author Malte
 *
 */
public class DataSelectionPanel extends JPanel {
	public DefaultListModel<File> model = new DefaultListModel<File>();
	public JList<File> list = new JList<File>(model); // Liste mit Strings
	public JScrollPane scroller = new JScrollPane(list);
	SharedListSelectionHandler selectionHandler = new SharedListSelectionHandler();
	
	public DataSelectionPanel(String rootPath){
		super();
		//For the time input code
		for (int i = 0; i < rootPath.length(); i++) {
			model.addElement(new File(rootPath));
		}
		
		//implementiere SelectionModel
		ListSelectionModel selModel = list.getSelectionModel();
		selModel.addListSelectionListener(selectionHandler);
		
		//Setzt CellRenderer fest um angepasste Darstellung zu ermöglichen
		list.setCellRenderer(new CellRenderer(rootPath));
		
		this.add(scroller, BorderLayout.CENTER);
		this.revalidate();
		this.setVisible(true);
	}

}
