package pirex;

import java.util.ArrayList;
//Edward Hall
public class Opus
{
	private String author;
	private String title;
	private ArrayList<String> documents;
	
	public Opus () 
	{
		this("No Name");
	}
	public Opus (String name)
	{
		this(name, "No Title");
	}
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
	
}
