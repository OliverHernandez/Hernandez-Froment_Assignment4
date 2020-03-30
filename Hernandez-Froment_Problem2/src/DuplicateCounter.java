import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;


public class DuplicateCounter 
{
	Map<String, Integer> wordCounter;
	
	public void count(String dataFile)
	{
		Scanner scan1 = null;
		try
		{
			scan1 = new Scanner(new File(dataFile));
			wordCounter = new HashMap<String, Integer>();
			while (scan1.hasNextLine()) 
			{
				Scanner scan2 = new Scanner(scan1.nextLine());
				while(scan2.hasNext())
				{
					String s = scan2.next();
					Integer i = wordCounter.get(s);
					if (i == null)
					{
						wordCounter.put(s,  1);
					}
					else
					{
						wordCounter.replace(s,  i + 1);
					}
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
			for (Map.Entry<String, Integer> entry : wordCounter.entrySet())
			{
				String key = (String)entry.getKey();
				int value = ((int)entry.getValue());
				writer.write(key + " : " + value + "\n");
			}
			writer.close();
		}
		catch(IOException e)
		{
			System.out.println("An error has occurred!");
			System.exit(0);
		}
	}

}
