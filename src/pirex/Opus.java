package pirex;


/*
 * Class Opus: This class deals with the data 
 * related to the documents. The methods to perform basic actions with the opus are included.
 */
import java.util.ArrayList;
import java.util.List;
//Edward Hall
public class Opus
{
	/*
	 * Field Variables: Each document is a pargraph in an Opus.
	 */
	private String author;
	private String title;
	private ArrayList<String> documents;
	
	//Constructor 1: No Parameter, Names the document to No Name
	public Opus () 
	{
		this("No Name");
	}
	
	//Constructor 2: @param name of type string.
	public Opus (String name)
	{
		this(name, "No Title");
	}
	
	//Constructor 3: @param name @param documentName Requests the name of the author and
	//name of the document.
	public Opus (String name, String documentName)
	{
		author=name;
		title=documentName;
		documents = new ArrayList<String>();
	}
	public String getAuthor()
	{
		return author;
	}
	public String getTitle()
	{
		return title;
	}
	public int findTextIndex (String text)
	{
		//if result is not found return -1
		int result = -1;
		for(String document:documents)
		{
			if (document.contains(text))
				result = document.indexOf(text);
		}
		return result;
	}
	public String getDoc(int index)
	{
		return documents.get(index);
	}
	public int getOpusSize()
	{
		return documents.size();
	}
	public void setAuthor (String newName)
	{
		this.author = newName;
	}
	public void setTitle (String newTitle)
	{
		this.author = newTitle;
	}
	public void addDocument (String document)
	{
		documents.add(document);
	}
	public void setDocuments (ArrayList<String> documents)
	{
		this.documents = documents;
	}
}
