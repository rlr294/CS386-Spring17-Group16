import static org.junit.Assert.*;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import org.junit.Test;

public class SaveTemplateTest 
{
	private ArrayList <String> test = new ArrayList<>();
	public SaveTemplateTest()
	{
		
    for (int i = 0; i < 3; i++)
        test.add("" + i);
	}
	@Test
	public void testInsert() 
	{
	    System.out.println("Running testInsert()");
	    assertEquals(test.size(), 3);
	    test.add(1, "Insert");
	    assertEquals(test.size(), 4);
	    assertEquals(test.get(1), "Insert");
	}
	
	

}
