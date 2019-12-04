package edu.swjtuhc.demo.controller;

import java.io.IOException;
import java.util.List;

import org.apache.ibatis.type.JdbcType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import edu.swjtuhc.demo.model.Movie;
import edu.swjtuhc.demo.service.MovieService;
import net.sf.json.JSONObject;

@RestController
@RequestMapping("/movies")
public class MovieController {
	
	@Autowired
	MovieService movieService;
	
	@RequestMapping("/getList")
	public List<Movie> getList(){
		return movieService.getMovieList();
	}
	
	@RequestMapping("/createMovie")
	public JSONObject createMovie(Movie movie, MultipartFile file) {
		JSONObject result = new JSONObject();
		movie.setPoster(file.getOriginalFilename());
		int i = 0;
		try {
			i = movieService.createMovie(movie, file.getInputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		result.put("state", i);
		
		return result;
	}
	
}
