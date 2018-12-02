package pirex;

import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JTextField;


@SuppressWarnings("serial") // this class does not employ serialization.
public class PirexLoadingTab extends JPanel 
{
	
	private JTextField jtfFilePath = new JTextField(80), jtfTitle = new JTextField(45), jtfAuthor = new JTextField(40);
	private JButton jbBrowse = new JButton("Browse"), jbProcess = new JButton("Process");
	private String[] comboBoxOptions = new String[] {"Project Gutenberg File", "Plain Text File"};
	private JComboBox<String> jcbFileType = new JComboBox<String>(comboBoxOptions);
	private JPanel jpLoad = new JPanel(); // this panel is the load summary window
	
	PirexLoadingTab()
	{
		super();
		Container loadTab = this;
		loadTab.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		
		JPanel row1 = new JPanel(), row2 = new JPanel(), row3 = new JPanel(),row4 = new JPanel();
		gbc.insets = new Insets(5,5,5,5);
		
		FlowLayout rowLayout = new FlowLayout(-0,7, 0); // controls layout for rows 1 through 3
		row1.setLayout(rowLayout);
		row2.setLayout(rowLayout);
		row3.setLayout(rowLayout);
		row4.setLayout(rowLayout);

		//build row 1
		row1.add(new JLabel("Text File"));
		row1.add(jtfFilePath);
		row1.add(jbBrowse);
		
		//build row 2
		row2.add(new JLabel("Text File Type"));
		jcbFileType.setPrototypeDisplayValue((String)"QQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQ"); //set default width
		row2.add(jcbFileType);
		
		//build row 3
		row3.add(new JLabel("Title"));
		row3.add(jtfTitle);
		row3.add(new JLabel("Author"));
		row3.add(jtfAuthor);
		
		//build row4
		row4.add(jbProcess);
		
		
		//set up Load Summary Display Window
		
		jpLoad.setBorder(BorderFactory.createEtchedBorder());
		jpLoad.setBackground(Color.WHITE);
		//jpLoad.setMinimumSize(new Dimension(jpLoad.getPreferredSize().width, 500));
		
		//Add subcomponents to top-level container
		gbc.weightx = 1;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		loadTab.add(row1, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 1;
		loadTab.add(row2, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 2;
		loadTab.add(row3, gbc);
		
		
		JSeparator hrule = new JSeparator();
		hrule.setBackground(Color.GRAY);
		gbc.gridx = 0;
		gbc.gridy = 3;
		loadTab.add(hrule, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 4;
		loadTab.add(row4, gbc);
		
		gbc.weighty=1;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.gridx = 0;
		gbc.gridy = 5;
		loadTab.add(jpLoad,gbc);
		
		
		
	}
	
}

