package com.logical1;

//printing last particular digit like 8,7,5 etc
public class Demo
{
	public static void main(String[] args) 
	{
		for(int i = 101; i< 500 ; i++)
		{
			if(i%10 == 2)
			{
				System.out.println(i + " ");
			}
		}
	}
}
