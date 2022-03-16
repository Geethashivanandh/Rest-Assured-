package TestNg;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Testng1 {
	@BeforeTest
	public void BT()
	{
		String Name = "Geetha";
		String SName = "Abhi";
		Assert.assertEquals(SName, Name);
	}
	
	@Test
	public void testcase1()
	{
		System.out.println("This is my first teestcase1");
	}
	
	@AfterTest
	public void AT()
	{
		System.out.println("This is After test");
	}

}
