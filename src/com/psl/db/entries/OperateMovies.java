package com.psl.db.entries;

import java.util.List;

public class OperateMovies {
	MovieSystem ms=new MovieSystem();
	public List showMoviesTable()
	{
		
		return(ms.showMovieTable());
	}
	
	public void addNewShow()
	{
		ms.addNewShow();
	}
	
	public void deleteAShow()
	{
		ms.deleteAShow();
	}
	
	public void updateShow()
	{
		ms.UpdateAShow();
	}
	public List DisplayByLang()
	{
		return(ms.DisplayByLang());
	}
	
	public List<Movies> DisplayByDate()
	{
		//return(ms.DisplayByDate());
		return(ms.DisplayDateWise());
	}
}
