package com.qa.test;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Hardandsoftassertion
{
	SoftAssert sa = new SoftAssert();
	
	@Test(enabled=true)
	public void testHSassert()
	{
		System.out.println("Open browser");
		Assert.assertEquals(true,true);
		System.out.println("login");
		System.out.println("Dashboard");
		sa.assertEquals(true, false);
		System.out.println("pricing header");
		System.out.println("Tariff Header");
		Assert.assertEquals(true,false);
		System.out.println("Lane");
	}
}
