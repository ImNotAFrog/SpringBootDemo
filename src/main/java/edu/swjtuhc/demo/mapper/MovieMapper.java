package edu.swjtuhc.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import edu.swjtuhc.demo.model.Movie;

@Mapper
public interface MovieMapper {
	public List<Movie> selectAllMovies();
	public int insertMovie(Movie movie);
}
