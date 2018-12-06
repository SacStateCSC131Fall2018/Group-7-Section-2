package pirex;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PirexOpusCreator 
{

	public static Opus extractOpus(String filename) throws IOException
	{
		BufferedReader reader = new BufferedReader(new FileReader(new File(filename)));
		List<String> lines = new ArrayList<String>(); //will store lines
		String line; //will be used for reading individual lines
		String title, author;
		
		
		while((line = reader.readLine()) != null) 
		{
			lines.add(line);
			// Rest of while loop extracts title and author... inefficiently.
			if(line.contains("Title: ")) 
			{
				title = line.substring(7, line.length());
			}
			if(line.contains("Author: ")) {
				author = line.substring(8, line.length());
			}
		}
		reader.close();
		
		Opus opus = new Opus(author, title);
		
		return opus;
	}
}
