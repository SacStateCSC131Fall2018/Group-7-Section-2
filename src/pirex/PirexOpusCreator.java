package pirex;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class PirexOpusCreator 
{
	/* Extracts information from .txt file and turns it into an Opus object.
	 * @param 	filename the file being past in
	 * @return	opus A fully built Opus object
	 * @throws	IOException
	 */
	public static Opus extractOpus(String filename) throws IOException
	{
		BufferedReader reader = new BufferedReader(new FileReader(new File(filename)));
		ArrayList<String> lines = new ArrayList<String>(); //will store lines
		String line; //will be used for reading individual lines
		StringBuilder sb = new StringBuilder();
		
		
		while((line = reader.readLine()) != null) 
		{
			if(line != "/n")
			{
				if(line.length() > (sb.capacity() - sb.length()))
				{
					sb.setLength(line.length() + sb.length());
				}
				sb.append(line);
			}
			
			// Add StringBuilder's string to the ArrayList
			lines.add(sb.toString());
			
			// Empty the StringBuilder
			sb.setLength(16);
			sb.delete(0, sb.capacity());
		}
		reader.close();
		
		Opus opus = new Opus(extractAuthor(lines), extractTitle(lines));
		opus.setDocuments(lines);
		
		return opus;
	}
	
	/* Extracts the author from the text file ArrayList of paragraphs
	 * @params paragraphs an ArrayList<String> of long strings from the document past in.
	 * @returns a string with the author's name
	 */
	private static String extractAuthor(ArrayList<String> paragraphs) 
	{
		for(String temp : paragraphs)
		{
			if(temp.contains("Author: "))
			{
				return temp.substring(8, temp.length());
			}
		}
		return null;
	}
	
	/* Extracts the title from the text file ArrayList of paragraphs
	 * @params paragraphs an ArrayList<String> of long strings from the document past in.
	 * @returns a string with the title's name
	 */
	private static String extractTitle(ArrayList<String> paragraphs) 
	{
		for(String temp : paragraphs)
		{
			if(temp.contains("Title: "))
			{
				return temp.substring(7, temp.length());
			}
		}
		return null;
	}
}
