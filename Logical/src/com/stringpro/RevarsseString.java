package com.stringpro;

import java.util.Scanner;

public class RevarsseString 
{
	public static void main(String[] args)
	{
		String str,rev="";
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter String");
		str = sc.nextLine();
		for(int i = str.length()-1; i >= 0; i--)
		{
			rev=rev+str.charAt(i);
		}
		System.out.println(rev);
		
	}
}
