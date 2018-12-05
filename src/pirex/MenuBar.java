package pirex;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static javax.swing.SwingConstants.CENTER;

/*
 * This class creates JMenu Bar that contains menu buttons.
 */
public class MenuBar extends JMenuBar {

	//Field variables
	JMenu fileMenu, optionsMenu, helpMenu;
	JMenuItem exit, export, loadQuery, saveQuery, open;
	JMenuItem sources, documents;
	JMenuItem about, index;
	
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

		//Add Actions to File Menu buttons
		open.addActionListener(new menuAL());
		saveQuery.addActionListener(new menuAL());
		loadQuery.addActionListener(new menuAL());
		export.addActionListener(new menuAL());
		exit.addActionListener(new menuAL());

		fileMenu.add(open);
		fileMenu.addSeparator();
		fileMenu.add(export);
		fileMenu.addSeparator();
		fileMenu.add(loadQuery);
		fileMenu.addSeparator();
		fileMenu.add(saveQuery);
		fileMenu.addSeparator();
		fileMenu.add(exit);
		
		//Add Buttons to Options Menu
		sources = new JMenuItem("Sources");
		documents = new JMenuItem("Documents");

		//Add Actions to Options Menu buttons
		sources.addActionListener(new menuAL());
		documents.addActionListener(new menuAL());

		optionsMenu.add(documents);
		optionsMenu.addSeparator();
		optionsMenu.add(sources);

		//Add Buttons to Help Menu
		about = new JMenuItem("About");
		index = new JMenuItem("Index");

		//Add Actions to Help Menu buttons
		about.addActionListener(new menuAL());
		index.addActionListener(new menuAL());

		helpMenu.add(index);
		helpMenu.addSeparator();
		helpMenu.add(about);
		
		
		//Add menus to the bar
		add(fileMenu);
		add(optionsMenu);
		add(helpMenu);
	}

	//Menu Action Listener
	public class menuAL implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getActionCommand() == "About") {
				//Open another window that is just a basic "About" window
				//Main JFrame Setup
				AboutFrame aboutFrame = new AboutFrame();
				
			}

			if (e.getActionCommand() == "Exit") {
				System.exit(0);
			}
		}
	}
}
