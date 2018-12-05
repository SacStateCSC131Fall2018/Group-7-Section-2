package pirex;

import static javax.swing.SwingConstants.CENTER;

import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class AboutFrame extends JFrame {
	public AboutFrame() {
		//Open another window that is just a basic "About" window
		//Main JFrame Setup
		setLayout(new GridLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		setSize(300,250);
		setLocationRelativeTo(null);
		setResizable(false);
		//Setup Icon
		String iconPath = "src" + File.separator + "assets"  + File.separator + "logo3.png";
		ImageIcon icon = new ImageIcon(iconPath);
		setIconImage(icon.getImage());

		//Main Panel
		JPanel aboutPanel = new JPanel();

		//Add aboutPanel to aboutFrame
		add(aboutPanel);

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
		closeAbout.addActionListener(new Listener());

		//Add Close button to bottomPanel
		bottomPanel.add(closeAbout);
		setVisible(true);
		
	}
	
	/*
	 * This class adds listener to the close button
	 * 
	 */
	private class Listener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			dispose();
		}
		
	}
}
