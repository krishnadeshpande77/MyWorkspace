package com.pattern;

import java.util.Scanner;

public class Pattern1 
{
	//Triangular Patter
	public static void main(String[] args) 
	{
		Scanner sc  = new Scanner(System.in);
		System.out.println("Enter the Number : ");
		int r = sc.nextInt();
		System.out.println();
		for (int i = 1 ; i  <= r; i++)
		{
			for(int j = 1 ; j<= i; j++)
			{
				System.out.print("*");
			}
			System.out.println();
		}
	}
}
