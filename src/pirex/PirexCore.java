package pirex;
import java.awt.BorderLayout;
import javax.swing.JTabbedPane;

/*
 * This class is the core class of the entire Pirex Project
 * The execution, flow and all other client classes are controlled from this class.
 */
public class PirexCore {

	public static void main(String[] args) {
		
		//Create the main window
		PirexFrame pirex = new PirexFrame();
		//Adding File Menu
		MenuBar bar = new MenuBar();
		pirex.add(bar, BorderLayout.NORTH );
		
		//Adding Tabs
		JTabbedPane jtb = new JTabbedPane();
		jtb.add("Search for Documents", new PirexSearchPanel()); //Search Document Tab
		jtb.add("Load Documents", new PirexLoadingTab()); //Load Document Tab
		jtb.add("Summarize Documents", new SummaryTab()); //Document Summary Tab
		pirex.add(jtb, BorderLayout.CENTER);
		
		//Add functionality to the components
		
	

	}

}
