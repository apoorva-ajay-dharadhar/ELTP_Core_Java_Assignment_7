package com.psl.db.entries;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
public class Operate {

	public static void main(String[] args) {
		OperateMovies om=new OperateMovies();
		// TODO Auto-generated method stub
		System.out.println("Select option from following:");
		System.out.println("Option 1: Display available Shows");
		System.out.println("Option 2: Add a new show");
		System.out.println("Option 3: Delete a show");
		System.out.println("Option 4: Update a show");
		System.out.println("Option 5: List by language");
		System.out.println("Option 6: List by date");
		Scanner sc=new Scanner(System.in);
		int option=sc.nextInt();
		sc.nextLine();
		switch(option)
		{
		case 1:
		{
			List<Movies> list=new ArrayList<Movies>();
			list=om.showMoviesTable();
			System.out.println(list);
			break;
		}
		case 2:
		{
			om.addNewShow();
			break;
		}
		case 3:
		{
			om.deleteAShow();
			break;
		}
		case 4:
		{
			om.updateShow();
			break;
		}
		case 5:
		{
			List<String> l=new ArrayList<String>();
			l=om.DisplayByLang();
			System.out.println(l);
			break;
			
		}
		case 6:
		{
		//	List<String> l1=new ArrayList<String>();
			List<Movies> l2=new ArrayList<Movies>();
			l2=om.DisplayByDate();
			for(Movies m:l2)
			{
				System.out.println("***");
				System.out.println(m);
			}
			break;
		}
		
		}
		
		
		// Add new movie, new show,delete show,update show
		//. Add new movie, new show,delete show,update show
	}

}
