package com.qa.test;
import org.testng.annotations.Test;

public class GroupingTest 
{
	
	@Test(groups={"sanity"})
	public void test1()
	{
		System.out.println("Sanity");
		
	}
	@Test(groups={"sanity","regression"})
	public void test2()
	{
		System.out.println("Sanity & Regression");
	}
	@Test(groups={"regression"})
	public void test3()
	{
		System.out.println("regression");
	}
	@Test(groups={"regression"})
	public void test4()
	{
		System.out.println("regression");
	}
}
