package com.psl.db.entries;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class TicketBooking {

	
	public static void main(String[] args)
	{
		MovieSystem ms=new MovieSystem();
		List<Movies> list=new ArrayList<Movies>();
		list=ms.showMovieTable();
		System.out.println(list);
		System.out.println("Enter the ID of movie for which you want to book the tickets");
		Scanner sc=new Scanner(System.in);
		int id=sc.nextInt();
		Booking b=new Booking();
		List<String> nm=new ArrayList<String>();
		nm=b.makeBooking(id);
		System.out.println(nm);
		
	}
}
