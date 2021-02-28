package com.psl.db.entries;

import java.sql.Time;
import java.time.LocalDateTime;
import java.util.Date;

public class Movies {

	private String movieName;
	private Date movieDt;
	private Time movieTime;
	private String language;
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	private int id;
	
	@Override
	public String toString() {
		return "Movies [movieName=" + movieName + ", movieDt=" + movieDt + ", movieTime=" + movieTime + ", language="
				+ language + ", id=" + id + "]";
	}
	public Time getMovieTime() {
		return movieTime;
	}
	public void setMovieTime(Time movieTime) {
		this.movieTime = movieTime;
	}
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public Date getMovieDt() {
		return movieDt;
	}
	public void setMovieDt(Date movieDt) {
		this.movieDt = movieDt;
	}
	
	
	
	
}
