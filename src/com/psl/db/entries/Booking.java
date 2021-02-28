package com.psl.db.entries;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.psl.db.DBConnectionUtil;

public class Booking {
	Connection cn=DBConnectionUtil.getConnection();
	public List makeBooking(int id)
	{
		List<String> names=new ArrayList<String>();
		try(Statement stmt1=cn.createStatement(); Statement stmt4=cn.createStatement();Statement stmt2=cn.createStatement(); Statement stmt3=cn.createStatement()) {
			ResultSet rs1,rs2;
			Scanner sc=new Scanner(System.in);
			System.out.println("How many tickets do you wish to book?");
			int numberOfTickets=sc.nextInt();
			
			
			String query="select movieName from MainMovie where Id='"+id+"'";
			ResultSet rs=stmt2.executeQuery(query);
			String name="";
			PreparedStatement pstmt = null;
			while(rs.next()) {
			name=rs.getString("movieName");
				System.out.println(name);
			}
				
				try {
					pstmt = cn.prepareStatement("insert into employees values(?,?,?,?)");
					pstmt.setInt(1,1);
					pstmt.setInt(2,id);
					pstmt.setString(3,name);
					pstmt.setInt(4, numberOfTickets);
					
					pstmt.executeUpdate();
				
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
			//stmt4.executeQuery("insert into bookingTable(movieName) values('"+movieName+"') where Id='"+id+"'");
			System.out.println(rs.getString(1));
			
		}catch(Exception e)
		{
			
		}
		return names;
	}
}
