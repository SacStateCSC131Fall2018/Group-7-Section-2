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
				JFrame aboutFrame = new JFrame("About Pirex");
				aboutFrame.setLayout(new GridLayout());
				GridBagConstraints gbc = new GridBagConstraints();
				aboutFrame.setSize(300,250);
				aboutFrame.setLocationRelativeTo(null);
				aboutFrame.setResizable(false);
				//Setup Icon
				String iconPath = "src" + File.separator + "assets"  + File.separator + "logo3.png";
				ImageIcon icon = new ImageIcon(iconPath);
				aboutFrame.setIconImage(icon.getImage());

				//Main Panel
				JPanel aboutPanel = new JPanel();

				//Add aboutPanel to aboutFrame
				aboutFrame.add(aboutPanel);

				//Panel that holds Pirex Image
				JPanel topPanel = new JPanel();

				//Add Image to topPanel
				BufferedImage imageFile = null;
				try {
					imageFile = ImageIO.read(new File("src/assets/logo3_256x126.png"));
				} catch (IOException ex) {
					System.err.println("Error opening image file.");
					System.exit(1);
				}
				//Actually put the image on the topPanel
				JLabel aboutImage = new JLabel(new ImageIcon(imageFile));
				aboutImage.setHorizontalAlignment(CENTER);
				topPanel.add(aboutImage);

				//Panel that holds close button
				JPanel bottomPanel = new JPanel();

				//Add Panels to aboutPanel
				aboutPanel.add(topPanel);
				aboutPanel.add(bottomPanel);
/*
				//TextArea that contains About Text
				JTextArea aboutText = new JTextArea(2,20);
				aboutText.setText("Pirex: a student company");
				aboutText.setEditable(false);

				//Add TextArea to bottomPanel
				bottomPanel.add(aboutText);
*/
				//Close button
				JButton closeAbout = new JButton("Close");
				closeAbout.addActionListener(this);

				//Add Close button to bottomPanel
				bottomPanel.add(closeAbout);

				aboutFrame.setVisible(true);
			}

			if (e.getActionCommand() == "Exit") {
				System.exit(0);
			}
		}
	}
}
