import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.*;
import java.io.BufferedWriter;
import java.io.File;

public class SaveTemplate
{
	public void save(ArrayList<String> textList)
	{
		String fileName = textList.get(0);

		File f = null;
		boolean bool = false;
		try
		{

			f = new File("./Templates/" + fileName + ".txt");
			bool = f.createNewFile();

			BufferedWriter writer = new BufferedWriter(new FileWriter(f));
			for(String item : textList)
			{
				writer.write(item);
				writer.newLine();
			}

			writer.close();

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
