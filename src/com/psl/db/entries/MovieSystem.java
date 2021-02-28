package com.psl.db.entries;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;
import java.util.Scanner;


import com.psl.db.DBConnectionUtil;

public class MovieSystem {
Connection cn=DBConnectionUtil.getConnection();

public List showMovieTable()
{
	
	List<Movies> movieList=new ArrayList<Movies>();
	try(Statement stmt1=cn.createStatement(); Statement stmt2=cn.createStatement()) {
		ResultSet rs1,rs2;
		rs2=stmt2.executeQuery("select count(*) from MainMovie");
		//rs2.last();
		int count=0;
		while(rs2.next())
		{
			int num=rs2.getRow();
			Movies m1=new Movies();
			rs1=stmt1.executeQuery("select * from MainMovie");
			while(rs1.next())
			{
				m1=new Movies();
				m1.setMovieName(rs1.getString(1));
				m1.setMovieDt(rs1.getDate(2));
				m1.setMovieTime(rs1.getTime(3));
				m1.setId(rs1.getInt(4));
				m1.setLanguage(rs1.getString(5));
				movieList.add(m1);
			//	j++;
			}
		}
		
		Movies[] m=new Movies[count];
		int j=0;
		/*while(rs1.next())
		{
			m[j]=new Movies();
			m[j].setMovieName(rs1.getString(1));
			m[j].setMovieDt(rs1.getDate(2));
			m[j].setMovieTime(rs1.getTime(3));
			
			movieList.add(m[j]);
			j++;
		}*/
		
			
			
			
		}
	catch (SQLException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	return movieList;
}


public void addNewShow()
{
	Movies m=new Movies();
	
	try(Statement stmt1=cn.createStatement()) {
		ResultSet rs1;
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the name of the movie");
		String movieName=sc.nextLine();
		System.out.println("Enter the date");
		String date = sc.nextLine();
		Date dt=Date.valueOf(date);
	    System.out.println("Enter the time of the movie");
	    String time=sc.next();  //default format: hh:mm:ss 
	    Time lt=Time.valueOf(time); 
	    System.out.println("Enter the language of the movie");
	    String lang=sc.next();  //default format: hh:mm:ss 
	    //Time lt=Time.valueOf(time);
	    String qry="insert into MainMovie(movieName, MovDt,Time,language) values('"+movieName+"','"+dt+"','"+lt+"','"+lang+"');";
	   stmt1.executeUpdate(qry);
		}
	catch (SQLException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}

}

public void deleteAShow()
{
	Movies m=new Movies();
	
	try(Statement stmt1=cn.createStatement()) {
		ResultSet rs1;
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the name of the movie you want to delete?");
		String movieName=sc.nextLine();
	    String qry="delete from MainMovie where movieName='"+movieName+"';";
	   stmt1.executeUpdate(qry);
		}
	catch (SQLException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}

}

public void UpdateAShow()
{
	Movies m=new Movies();
	
	try(Statement stmt1=cn.createStatement();Statement stmt2=cn.createStatement();Statement stmt3=cn.createStatement() ) {
		ResultSet rs1;
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the name of the movie you want to update?");
		String movie1Name=sc.nextLine();
		System.out.println("Enter the new movie name");
		String name=sc.nextLine();
		m.setMovieName(name);
		
		System.out.println("Enter the new movie date");
		String date1=sc.nextLine();
		Date dt=Date.valueOf(date1);
		m.setMovieDt(dt);
		 
		System.out.println("Enter the new movie time");
		String movieTime=sc.nextLine();
		
		System.out.println("Enter the new movie language");
		String language=sc.nextLine();
		m.setLanguage(language);
		
		Time lt1=Time.valueOf(movieTime);
		m.setMovieTime(lt1);
		   String qry="update MainMovie set movieName='"+name+"', MovDt='"+dt+"', Time='"+lt1+"', language='"+language+"'where movieName='"+movie1Name+"';";
		    stmt1.executeUpdate(qry);
	    
			
		}
	catch (SQLException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	
	

}

public List DisplayByLang()
{
	Scanner sc=new Scanner(System.in);
	System.out.println("Enter the language");
	String lang=sc.nextLine();
	List<String> names=new ArrayList<String>();
	try(Statement stmt1=cn.createStatement() ) {
	ResultSet rs1;
		String qry="select movieName from MainMovie where language like '"+lang+"';";
		//select movieName from MainMovie where language="English"; 
		System.out.println(qry);
		rs1=stmt1.executeQuery(qry);
		
		while(rs1.next())
		{
		String name = rs1.getString("movieName");
		names.add(name);
		}
		
	}catch(Exception e)
	{
		
	}
	return names;
}


public List DisplayByDate()
{
	Scanner sc=new Scanner(System.in);
	
	List<String> names=new ArrayList<String>();
	try(Statement stmt1=cn.createStatement() ) {
	ResultSet rs1;
	java.util.Date date=new java.util.Date();
	java.sql.Date sqlDate=new java.sql.Date(date.getTime());
		String qry="select MovieName from MainMovie where MovDt like'"+sqlDate+"';";
		//select movieName from MainMovie where language="English"; 
		System.out.println(qry);
		rs1=stmt1.executeQuery(qry);
		while(rs1.next())
		{
		String name = rs1.getString("movieName");
		names.add(name);
		}
		
		
	}catch(Exception e)
	{
		
	}
	return names;
}

public List<Movies> DisplayDateWise()
{
	List<String> dateDisplay=new ArrayList<String>();
	//Display movies by shows for today.
	long millis=System.currentTimeMillis();  
    java.sql.Date date=new java.sql.Date(millis);  
  //  System.out.println(date);  
	String query="select * from MainMovie where  MovDt like '%"+date+"%'";
	List<Movies> mov=new ArrayList<Movies>();
	System.out.println("---1----");
	try {
		Statement st=cn.createStatement();
		ResultSet rs=st.executeQuery(query);
		System.out.println("---2----");
		while(rs.next())
		{
			System.out.println("---3----");
			String movieName=rs.getString(1);
			Date dt=rs.getDate(2);
			Time tm=rs.getTime(3);
			int id=rs.getInt(4);
			String lang=rs.getString(5);
			Movies m=new Movies();
			m.setId(id);
			m.setLanguage(lang);
			m.setMovieDt(dt);
			m.setMovieName(movieName);
			m.setMovieTime(tm);
			mov.add(m);
			//System.out.println(mov);
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return mov;
}


}
