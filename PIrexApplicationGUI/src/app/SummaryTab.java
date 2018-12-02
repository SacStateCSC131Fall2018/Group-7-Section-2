

import java.util.HashMap;
import java.util.Map;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/*
 * This class creates a summary tab.
 * This summary tab has a JTextArea which can be scrolled
 */
public class SummaryTab extends JPanel
{
	
	private static final long serialVersionUID = -6708932581784591812L;
	
	public SummaryTab()
	{
		
		super(); //Initializing
		
		//Add a new Text area to summary tab
		JTextArea text = new JTextArea(40, 88);
		text.setText("");
		text.setEditable(false);
		//Creating a scroll pane.
		JScrollPane scrollableTextArea = new JScrollPane(text);
		
		//Add to the Summary Tab
		add(scrollableTextArea);
	}

}
