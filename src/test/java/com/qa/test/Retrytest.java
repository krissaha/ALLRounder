package com.qa.test;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Retrytest 
{
	int i = 0;
	
	@Test
	public void test1()
	{
		System.out.println("retrying");
		i++;
		System.out.println("Counter I = " + i);
		if (i < 2)
		{
		System.out.println("Failure happened");
		Assert.assertTrue(false);
		}
		else {
			System.out.println("Failure happened");
			Assert.assertTrue(true);
		}
	}
}
