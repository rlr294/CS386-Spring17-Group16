import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.UnsupportedEncodingException;
import java.util.*;
import java.io.BufferedWriter;
import java.io.File;
import javax.swing.JCheckBox;

public class SaveTemplate
{
	public void save(ArrayList<String> textList, ArrayList<JCheckBox> boxList)
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
			for(JCheckBox box: boxList)
			{
				if(box.isSelected())
				{
					writer.write("y");
				}
				else
				{
					writer.write("n");
				}
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
