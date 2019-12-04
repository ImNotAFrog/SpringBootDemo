package edu.swjtuhc.demo.service;

import java.io.InputStream;
import java.util.List;

import edu.swjtuhc.demo.model.Movie;

public interface MovieService {
	public List<Movie> getMovieList();
	
	public int createMovie(Movie movie, InputStream fileStream);
}
