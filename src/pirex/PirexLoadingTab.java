package pirex;

import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;


/**
 * 
 * @author Dean Gramcko
 * This class is the file loading tab for Pirex and sets up the layout of the tab, handles file selection, and gives the Administrator an interface for loading opuses.
 * The extraction of information from files is handled by a separate class.
 *
 */
public class PirexLoadingTab extends JPanel
{
	
	private static final long serialVersionUID = 123456L; 
	private JTextField jtfFilePath = new JTextField(1), jtfTitle = new JTextField(45), jtfAuthor = new JTextField(40);
	private JButton jbBrowse = new JButton("Browse"), jbProcess = new JButton("Process");
	private String[] comboBoxOptions = new String[] {"Project Gutenberg File", "Plain Text File"};
	private JComboBox<String> jcbFileType = new JComboBox<String>(comboBoxOptions);
	private JPanel jpLoad = new JPanel(); // this panel is the load summary window
	private String filePath;
	private Opus loaded;
	
	private JLabel lPath = new JLabel(), lTitle = new JLabel(), lAuthor = new JLabel(), lSize = new JLabel(); // for displaying load summary info
	
	/**
	 * Default Constructor - Creates fields and sets up the layout of the tab
	 */
	PirexLoadingTab()
	{
		super();
		Container loadTab = this;
		Insets inset = new Insets(2,7,2,7);
		
		
		loadTab.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		
		JPanel row1 = new JPanel(), row2 = new JPanel(), row3 = new JPanel(),row4 = new JPanel();
		gbc.insets = new Insets(5,5,5,5);
		
		//set up sub-containers
		row1.setLayout(new GridBagLayout());
		row2.setLayout(new GridBagLayout());
		row3.setLayout(new GridBagLayout());
		row4.setLayout(new FlowLayout(-0));
		jpLoad.setLayout(new GridBagLayout());
		
		

		//build row 1
		gbc.anchor = GridBagConstraints.WEST;
		gbc.insets = inset;
		row1.add(new JLabel("Text File"), gbc);
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.weightx = 1;
		row1.add(jtfFilePath, gbc);
		gbc = new GridBagConstraints();
		gbc.anchor = GridBagConstraints.WEST;
		gbc.insets = inset;
		row1.add(jbBrowse, gbc);
		jbBrowse.addActionListener(new loadListener()) ;
		
		//build row 2
		gbc = new GridBagConstraints();
		gbc.anchor = GridBagConstraints.WEST;
		gbc.insets = inset;
		row2.add(new JLabel("Text File Type"), gbc);
		gbc.weightx = 1;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		row2.add(jcbFileType, gbc);
		
		//build row 3
		gbc = new GridBagConstraints();
		gbc.anchor = GridBagConstraints.WEST;
		gbc.insets = inset;
		row3.add(new JLabel("Title"), gbc);
		gbc.weightx = 1;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		row3.add(jtfTitle, gbc);
		gbc = new GridBagConstraints();
		gbc.anchor = GridBagConstraints.WEST;
		gbc.insets = inset;
		row3.add(new JLabel("Author"), gbc);
		gbc.weightx = 1;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		row3.add(jtfAuthor, gbc);
		
		//build row4
		row4.add(jbProcess);
		jbProcess.addActionListener(new loadListener());
		jbProcess.setEnabled(false); //disabled by default - enabled when a file is selected
		
		
		//set up Load Summary Display Window
		
		jpLoad.setBorder(BorderFactory.createEtchedBorder());
		jpLoad.setBackground(Color.WHITE);
		
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
		
		gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.BOTH;
		gbc.weightx = 1;
		
		gbc.gridx = 0;
		gbc.gridy=0;
		jpLoad.add(lPath,gbc);
		gbc.gridy=1;
		jpLoad.add(lTitle,gbc);
		gbc.gridy=2;
		jpLoad.add(lAuthor,gbc);
		gbc.gridy=3;
		jpLoad.add(lSize,gbc);
		
		gbc.gridy=4;
		gbc.weighty = 1;
		jpLoad.add(new JLabel(" "),gbc); // this empty JLabel is being used for formatting - this forces the ones above it to reposition to the top of their container
		
	}
	
	/**
	 * 
	 * @author Dean Gramcko
	 * This class handles button presses, allowing the Administrator to select a file and then process it (displays a partial opus summary). 
	 * 
	 */
	private class loadListener implements ActionListener
	{

		public void actionPerformed(ActionEvent buttonpress)
		{
			Boolean errorState = false; //used to check if IOException was thrown when attempting to parse selected file
			
			String cmd = buttonpress.getActionCommand();
			
			if(cmd.equals("Browse")) //when a file is selected, attempt to create opus from it
			{
				JFileChooser fc = new JFileChooser();
				FileNameExtensionFilter filter = new FileNameExtensionFilter("Text File", "txt");
				fc.setFileFilter(filter);
				if(fc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
				{
					filePath = fc.getSelectedFile().getAbsolutePath();
					jtfFilePath.setText(filePath);
					
					try
					{
						loaded = PirexOpusCreator.extractOpus(filePath);
					}
					catch(IOException e)
					{
						errorState = true;
					}
					
					jbProcess.setEnabled(true);
					if(!errorState && jcbFileType.getSelectedItem().equals("Project Gutenberg File")) // if file is loaded and is Gutenberg, then load title and author
					{
						jtfTitle.setText(loaded.getTitle());
						jtfAuthor.setText(loaded.getAuthor());
					}
				}				
			}
			else if(cmd.equals("Process")) // populate the Load Summary section with information and reset the other fields
			{
				if(!errorState && loaded != null)
				{
					lTitle.setText("Title: "+loaded.getTitle());
					lPath.setText("File: " + filePath);
					lAuthor.setText("Author: " +loaded.getAuthor());
					lSize.setText("Opus size: " +String.valueOf(loaded.getOpusSize()));
					
					//reset fields, disable Process button
					jtfFilePath.setText("");
					jtfTitle.setText("");
					jtfAuthor.setText("");
					jbProcess.setEnabled(false);
				}
			}
		}
	}
}

