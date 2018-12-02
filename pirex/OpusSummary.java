package pirex;
import javax.swing.JLabel;

public class OpusSummary extends JLabel 
{
	
	public OpusSummary(long index, String author, String title, long docs, String path)
	{
		String oSummary;
	    long indexLength;
	    
	    indexLength = index%10 + 5;
		oSummary = String.format("Opus %d: %s %s %d\t" + "%" + indexLength + "s", index, author, title, docs, path);
	}
}
