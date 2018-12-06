package pirex;
import java.awt.BorderLayout;

import javax.swing.BorderFactory;
import javax.swing.JTabbedPane;

/*
 * This class is the core class of the entire Pirex Project
 * The execution, flow and all other client classes are controlled from this class.
 * @Author: Entire Group 
 */
public class PirexCore {


	/*
	 * The execution of the code starts here.
	 * All other classes are implemented in this
	 */
	public static void main(String[] args) {
		
		//Create the main window
		PirexFrame pirex = new PirexFrame();
		//Adding File Menu
		MenuBar bar = new MenuBar();
		pirex.add(bar, BorderLayout.NORTH );
		
		//Adding Tabs
		JTabbedPane jtb = new JTabbedPane();
		int padding = 7;
		jtb.setBorder(BorderFactory.createEmptyBorder(padding, padding, padding, padding));
		jtb.add("Search for Documents", new PirexSearchTab()); //Search Document Tab
		jtb.add("Load Documents", new PirexLoadingTab()); //Load Document Tab
		jtb.add("Summarize Documents", new PirexSummaryTab()); //Document Summary Tab
		pirex.add(jtb, BorderLayout.CENTER);
		
		//Add functionality to the components
		
		
		//Configure window settings
		pirex.setVisible(true);

	}

}
