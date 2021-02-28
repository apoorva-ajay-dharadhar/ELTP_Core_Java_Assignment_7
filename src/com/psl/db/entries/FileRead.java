package com.psl.db.entries;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;

import com.psl.db.DBConnectionUtil;

import java.sql.Connection;

public class FileRead {

	Connection cn=DBConnectionUtil.getConnection();;
	public void createTable()
	{
		
		try(Statement stmt=cn.createStatement()) {
			ResultSet rs;
			stmt.executeUpdate("create table movies(id int, name varchar(50), movieLan varchar(30), movieDt date)");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	public void separate(String[] strArray)
	{
		
		int num=Integer.parseInt(strArray[0]);
		String movieName=strArray[1];
		String movieLang=strArray[2];
		String strDate=strArray[3];
		try {
			
			 String testDateString = strDate;
			 DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
			java.util.Date d1 = df.parse(testDateString);
			
	        SimpleDateFormat format1 = new SimpleDateFormat("dd/MM/yyyy");
	        String testDateString1 = df.format(d1);

	        DateFormat df1 = new SimpleDateFormat("yyyy-MM-dd");
			java.util.Date d11 = df.parse(testDateString1);
			String finalDate1=df1.format(d11);
	
			Date dt=Date.valueOf(finalDate1);
//			System.out.println(">>"+dt);			
			//System.out.println(num+" "+movieName+" "+movieLang+" "+dt);
			String qry="insert into movies values("+num+",'"+movieName+"','"+movieLang+"','"+dt+"');";
			//System.out.println(">>>>>>>>>>>>>>>>>>>>>>>"+qry);
			try(Statement stmt=cn.createStatement()) {
				ResultSet rs;
				stmt.executeUpdate(qry);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		/*	try(Statement stmt=cn.createStatement()) {
				//System.out.println("Backtracking-2");
			//	System.out.println("ID="+id);
				ResultSet rs;
				stmt.executeUpdate("create table movies(id int, name varchar(50), movieLan varchar(30), movieDt date");
			}*/
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			FileRead obj=new FileRead();
			BufferedReader br;
			br = new BufferedReader(new FileReader("C:\\\\Users\\\\hp\\\\eclipse-workspace\\\\Ass7_Apoorva_Dharadhar\\\\src\\\\Movies.txt"));	
		    System.out.println("Reading the file using readLine() method:");
		    String contentLine = br.readLine();
		   // obj.createTable();
		    while (contentLine != null) {
		     // System.out.println(contentLine);
		    	String[] str=contentLine.split(",");
		    	obj.separate(str);
		      contentLine = br.readLine();
		     
		   }
			
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
