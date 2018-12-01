
import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;

//NOTE: this is just a quick and dirty testing class that I'm using to check the layout. Don't use it for anything else.

public class PirexLoadingTabDriver 
{

	public static void main(String[] args)
	{
			JFrame a = new JFrame();
			a.setLayout(new BorderLayout());
			a.setVisible(true);
			a.setSize(600, 400);
			a.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			JTabbedPane jtb = new JTabbedPane();
			a.add(jtb);
			jtb.add("Load Document", new PirexLoadingTab());
	}
}
