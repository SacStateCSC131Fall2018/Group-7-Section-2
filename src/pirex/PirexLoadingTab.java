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
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;


public class PirexLoadingTab extends JPanel
{
	
	private static final long serialVersionUID = 123456L; 
	private JTextField jtfFilePath = new JTextField(1), jtfTitle = new JTextField(45), jtfAuthor = new JTextField(40);
	private JButton jbBrowse = new JButton("Browse"), jbProcess = new JButton("Process");
	private String[] comboBoxOptions = new String[] {"Project Gutenberg File", "Plain Text File"};
	private JComboBox<String> jcbFileType = new JComboBox<String>(comboBoxOptions);
	private JPanel jpLoad = new JPanel(); // this panel is the load summary window
	
	private String filePath;
	
	PirexLoadingTab()
	{
		super();
		Container loadTab = this;
		Insets inset = new Insets(2,7,2,7);
		
		
		loadTab.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		
		JPanel row1 = new JPanel(), row2 = new JPanel(), row3 = new JPanel(),row4 = new JPanel();
		gbc.insets = new Insets(5,5,5,5);
		
		row1.setLayout(new GridBagLayout());
		row2.setLayout(new GridBagLayout());
		row3.setLayout(new GridBagLayout());
		
		row4.setLayout(new FlowLayout(-0));

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
		
	}
	
	/**
	 * 
	 * @author Dean Gramcko
	 * ActionListener to allow user to select a file and updates the file path displayed.
	 *
	 */
	private class loadListener implements ActionListener
	{
		public void actionPerformed(ActionEvent buttonpress)
		{
			JFileChooser fc = new JFileChooser();
			FileNameExtensionFilter filter = new FileNameExtensionFilter("Text File", "txt");
			fc.setFileFilter(filter);
			if(fc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
			{
				filePath = fc.getSelectedFile().getAbsolutePath();
				jtfFilePath.setText(filePath);
				jbProcess.setEnabled(true);
			}
		}
	}
	
}

