package com.magasin.gui;

import java.util.List;
import java.util.Scanner;

import com.magasin.entities.Commande;
import com.magasin.service.implementation.ServiceCommandeImpl;

public class SalesGUI {

	private Scanner scn;

	public SalesGUI() {
		
		// TODO Auto-generated constructor stub
		boolean test=true;
	 do {
		top();
		System.out.println("____________________________________________________________________________");
		frame(1);
		System.out.println("|====================== Welcome To Sales Management =======================|");
		horizental();
		frame(4);
		System.out.println("|                   +++++ What Operation to do ? ++++                      |");
		frame(3);
		System.out.println("|  1 > Add New Command.                                                    |");
		frame(1);
		System.out.println("|  2 > Validate A Command.                                                 |");
     	frame(1);
		System.out.println("|  3 > Back.                                                               |");
		horizental();
		
		scn = new Scanner(System.in);
		String x = scn.next();
		switch(x)
		{
		case "1":
			for (int i = 0; i < 50; ++i) System.out.println();
			new AddCommandeGUI();
			break;
		case "2":
			for (int i = 0; i < 50; ++i) System.out.println();
			ServiceCommandeImpl sCom = new ServiceCommandeImpl();
			List<Commande> listCommande = sCom.findAll();
			for(Commande c :listCommande)
			{
				System.out.println(c);
			}
			System.out.println("Write the ID of the Commande you want to validate.");
			int id = scn.nextInt();
			new ValidationCommadeGUI(sCom.findById(id));
			break;
		case"3":  
			for (int i = 0; i < 50; ++i) System.out.println(); 
			MainMenu.main(null);
		 
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
