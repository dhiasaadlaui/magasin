package com.magasin.gui;

import java.io.IOException;
import java.util.Scanner;

public class MainMenu {

	public MainMenu() {
		// TODO Auto-generated constructor stub
	
	}

	public static void main(String[] args) {
		boolean test=true;
	 do {
		top();
		System.out.println("____________________________________________________________________________");
		frame(1);
		System.out.println("|================== Welcome To SuperMarket Management  ====================|");
		horizental();
		frame(4);
		System.out.println("|                   ***** What Operation to do ?   *****                   |");
		frame(3);
		System.out.println("|  1 > Get to the 'Sales' Management.                                      |");
		frame(1);
		System.out.println("|  2 > Get to the 'Stock' Management.                                      |");
     	frame(1);
		System.out.println("|  3 > Quit.                                                               |");
		horizental();
		
		Scanner scn =new Scanner(System.in);
		String x = scn.next();
		switch(x)
		{
		case "1":
			for (int i = 0; i < 50; ++i) System.out.println();
			new SalesGUI();
		case "2":
			for (int i = 0; i < 50; ++i) System.out.println();
			new StockGUI();
		case"3":  
			for (int i = 0; i < 50; ++i) System.out.println(); 
			System.exit(0);
		default:
			
		}
	 }while(test);
		
		
		
	}
	
	
	public static void top()
	{
		for(int i=0;i<36;i=i+3)
		{
			
			for(int j=i;j<36;j++)
			{
				System.out.print(" ");
			}
			System.out.print("/");
			for(int j=0;j<i*2;j++)
			{
				System.out.print(" ");
			}
			System.out.println(" \\ ");
		}	
	}
	public static void frame(int length)
	{
		for(int i=0;i<length;i++)
		{
			System.out.println("|                                                                          |");
		}
	}
	
	public static void horizental()
	{
		
			System.out.println("|__________________________________________________________________________|");
		 
	}
	
	

}
