
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JTextField;


@SuppressWarnings("serial") // this class does not employ serialization.
public class PirexLoadingTab extends JPanel 
{
	
	private JTextField jtfFilePath = new JTextField(), jtfTitle = new JTextField(), jtfAuthor = new JTextField();
	private JButton jbBrowse = new JButton("Browse");
	private JComboBox jcbFileType = new JComboBox();
	
	PirexLoadingTab()
	{
		super();
		Container loadTab = this;
		loadTab.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		
		JPanel row1 = new JPanel(), row2 = new JPanel(), row3 = new JPanel(), jpLoadSummary = new JPanel();
		gbc.insets = new Insets(5,5,5,5);
		
		FlowLayout rowLayout = new FlowLayout(); // controls layout for rows 1 through 3
		row1.setLayout(rowLayout);
		row2.setLayout(rowLayout);
		row3.setLayout(rowLayout);

		//build row 1
		
		
		
		
		
		
		
		
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
		gbc.gridx = 0;
		gbc.gridy = 3;
		loadTab.add(hrule, gbc);
		

		gbc.gridx = 0;
		gbc.gridy = 3;
		loadTab.add(jpLoadSummary,gbc);
		
		
		
	}
	
}

