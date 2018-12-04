package pirex;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

/*
 * This class creates a summary tab.
 * This summary tab has a JTextArea which can be scrolled
 */
public class SummaryTab extends JPanel
{
	JTextArea textArea = new JTextArea(40, 88);

	private static final long serialVersionUID = -6708932581784591812L;
	
	public SummaryTab()
	{
		super(new GridBagLayout()); //Initializing
		GridBagConstraints gbc = new GridBagConstraints();

		//Add a new Text area to summary tab
		textArea.setText("");
		textArea.setEditable(false);
		textArea.setLineWrap(true);

		//Creating a scroll pane.
		JScrollPane scrollableTextArea = new JScrollPane(textArea, 22, 31);

		//Arrange layout
		gbc.weightx = 1.0;
		gbc.weighty = 1.0;
		gbc.insets = new Insets(5,5,5,5);
		gbc.fill = GridBagConstraints.BOTH;

		//Add to the Summary Tab
		add(scrollableTextArea, gbc);
	}
}
