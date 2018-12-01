import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/*
 * This class creates JMenu Bar that contains menu buttons.
 */
public class MenuBar extends JMenuBar {

	//Field variables
	JMenu fileMenu, optionsMenu, helpMenu;
	JMenuItem exit, export, loadQuery, saveQuery, open;
	
	public MenuBar() {
		super();
	
		//Create File Menus
		fileMenu = new JMenu("File");
		optionsMenu = new JMenu("Options");
		helpMenu = new JMenu("Help");
		
		//Add Buttons to File Menu
		exit = new JMenuItem("Exit");
		export = new JMenuItem("Export");
		loadQuery = new JMenuItem("Load Query");
		saveQuery = new JMenuItem("Save Query");
		open = new JMenuItem("Open");
		
		fileMenu.add(open);
		fileMenu.add(export);
		fileMenu.add(loadQuery);
		fileMenu.add(saveQuery);
		fileMenu.add(exit);
		
		//Add Buttons to Options Menu
		
		
		
		//Add Buttons to Help Menu
		
		
		//Add menus to the bar
		add(fileMenu);
		add(optionsMenu);
		add(helpMenu);
	}
}
