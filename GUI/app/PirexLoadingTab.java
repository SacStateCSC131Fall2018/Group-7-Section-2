
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JTextField;

/*	11-30-18
 *  This is obviously incomplete. I still need to work out some issues with spacing components on each row. I'll probably end up moving each row into it's own JPanel and just
 *  deal with it that way, will try tomorrow.
 * 
 */


@SuppressWarnings("serial") // this class does not employ serialization.
public class PirexLoadingTab extends JPanel 
{
	private GridBagConstraints gbc = new GridBagConstraints();
	private JTextField jtfFilePath = new JTextField(), jtfTitle = new JTextField(), jtfAuthor = new JTextField();
	private JButton jbBrowse = new JButton("Browse");
	private JComboBox jcbFileType = new JComboBox();
	
	PirexLoadingTab()
	{
		super();
		this.setLayout(new GridBagLayout());
		gbc.insets = new Insets(5,5,5,5);
		
		//row 1 components
		gbc.anchor = GridBagConstraints.WEST;
		gbc.gridx = 0;
		gbc.gridy = 0;
		add(new JLabel("Text File"), gbc);
		
		gbc.fill = GridBagConstraints.HORIZONTAL;
		
		gbc.weightx=1;
		
		gbc.gridx = 1;
		gbc.gridy = 0;
		add(jtfFilePath, gbc);
		
		gbc.weightx=0;
		
		gbc.gridx=2;
		gbc.gridy=0;
		add(jbBrowse, gbc);
		
		
		// row 2 components
		gbc.gridx = 0;
		gbc.gridy = 1;
		add(new JLabel("Text File Type"), gbc);

		gbc.gridwidth = 2;

		gbc.gridx = 1;
		gbc.gridy = 1;
		add(jcbFileType, gbc);

		//row 3 components
		gbc.gridwidth = 1;
		gbc.weightx=0;
		
		gbc.gridx = 0;
		gbc.gridy = 2;
		add(new JLabel("Title"), gbc);

		gbc.weightx=1;
		
		gbc.gridx = 1;
		gbc.gridy = 2;
		add(jtfTitle, gbc);
		
		gbc.weightx=0;

		gbc.gridx = 2;
		gbc.gridy = 2;
		add(new JLabel("Author"), gbc);

		gbc.weightx=1;
		
		
		gbc.gridx = 3;
		gbc.gridy = 2;
		add(jtfAuthor, gbc);
	}
	
}

