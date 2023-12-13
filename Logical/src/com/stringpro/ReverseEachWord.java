package com.stringpro;
import java.util.*;
public class ReverseEachWord 
{
	String inputstring ;
	String reversestring = " ";
	Scanner sc;
	public void reverseEachWord()
	{
		sc = new Scanner(System.in);
		System.out.println("Enter a String");
		inputstring = sc.nextLine();
		String [] words = inputstring.split(" ");
		for(int i = 0; i<words.length;i++)
		{
			String word = words[i];
			String revword = " ";
			for(int j = word.length()-1; j>=0 ; j--)
			{
				revword = revword + word.charAt(j);
			}
			reversestring = reversestring + revword + " ";
		}
		System.out.println(inputstring);
		System.out.println(reversestring);
	}
	
	public static void main(String[] args) 
	{
		ReverseEachWord r = new ReverseEachWord();
		r.reverseEachWord();
	}
	
}
