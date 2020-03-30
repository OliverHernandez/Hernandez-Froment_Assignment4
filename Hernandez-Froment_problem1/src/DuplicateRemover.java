import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.HashSet;
import java.util.Set;


public class DuplicateRemover
{
	Set<String> uniqueWords;
	
	public void remove(String dataFile)
	{
		Scanner scan1 = null;
		try
		{
			scan1 = new Scanner(new File(dataFile));
			uniqueWords = new HashSet<String>();
			while (scan1.hasNextLine()) 
			{
				Scanner scan2 = new Scanner(scan1.nextLine());
				while (scan2.hasNext())
				{
					String s = scan2.next();
					uniqueWords.add(s.toLowerCase());
				}
				scan2.close();
			}
			scan1.close();
		}
		catch(FileNotFoundException e) 
		{
			System.exit(0);
		}
	}
	
	public void write(String outputFile)
	{
		FileWriter writer = null;
		try
		{
			writer = new FileWriter(outputFile);
			for(String s: uniqueWords)
			{
				writer.write(s);
				writer.write(" ");
			}
			writer.close();
		}
		catch(IOException e)
		{
			System.exit(0);
		}
	}
}
