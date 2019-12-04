package edu.swjtuhc.demo.model;

import java.util.Date;

public class Movie {
	private Integer mId;
	private String movieName;
	private String director;
	private Date releaseDate;
	private String poster;
	public int getmId() {
		return mId;
	}
	public void setmId(int mId) {
		this.mId = mId;
	}
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public Date getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}
	public String getPoster() {
		return poster;
	}
	public void setPoster(String poster) {
		this.poster = poster;
	}
	@Override
	public String toString() {
		return "Movie [mId=" + mId + ", movieName=" + movieName + ", director=" + director + ", releaseDate="
				+ releaseDate + ", poster=" + poster + "]";
	}
	
	
}
