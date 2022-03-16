package TestNg;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class diffjunitandtestng {
	@Before
	public void BT()
	{
		String Name = "Geetha";
		String SName ="Abhi";
		
		Assert.assertEquals(SName,Name);
		System.out.println("Both the names are same");
	}
	
	@Test
	public void testcase1()
	{
		System.out.println("This is the first method");
	}
	
	@After
	public void AT()
	{
		System.out.println("This is after method");
	}

}
