

import java.awt.BorderLayout;

import javax.swing.JFrame;

/*
 * This class draws the main PirexWindow on the Screen
 * A new object of this class must be created to use
 * at. All smaller containers can be inserted into this 
 * main frame.
 */
public class PirexFrame extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8008539775178469403L;

	/*
	 * Default Constructor: constructs a new PirexFrame with Name "Pirex"
	 * The default layout used in BorderLayout
	 * 
	 */
	public PirexFrame() {
		
		super("Pirex");
		setLayout(new BorderLayout());
		//setSize(780, 520);
		//setResizable(false);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
}
