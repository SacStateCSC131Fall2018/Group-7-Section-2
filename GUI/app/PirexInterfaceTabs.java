
import javax.swing.*;

public class PirexInterfaceTabs extends JTabbedPane
{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4276663338227407841L;
	private final String[] tabNames = {"Search for Documents", "Load Documents", "Summarize Documents"};
	
	/*
	 * Constructs the tab pane.
	 */
	public PirexInterfaceTabs()
	{
		super();
		//createTabs();
		
	}
	
	/*
	 * Initializes the tab pane with tabs and their respective panels
	 * 
	 * REQUIRES PANELS TO BE BUILT FIRST BEFORE CREATING THE TABS
	 */
	/* public void createTabs()
	{
		int length = tabNames.length;
		for (int i = 0; i < length; i++)
			addTab(tabNames[i]);
	} */ 
}
