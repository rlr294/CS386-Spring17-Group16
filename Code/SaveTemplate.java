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
		
		//Driver drive = new Driver();
		
		String occupant = textList.get(0);
		String address = textList.get(1);
		String city = textList.get(2);
		String county = textList.get(3);
		String bedrooms = textList.get(4);
		
		
		File f = null;
		boolean bool = false;
		try
		{
			
			f = new File("tested.txt");
			bool = f.createNewFile();
			
			BufferedWriter writer = new BufferedWriter(new FileWriter(f));
			writer.write(occupant);
			writer.newLine();
			writer.write(address);
			writer.newLine();
			writer.write(city);
			writer.newLine();
			writer.write(county);
			writer.newLine();
			writer.write(bedrooms);
			writer.newLine();
			writer.close();
			
			System.out.println("Printed");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		System.out.println("Printed");
	}
}
