package edu.swjtuhc.demo.serviceImpl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import edu.swjtuhc.demo.mapper.MovieMapper;
import edu.swjtuhc.demo.model.Movie;
import edu.swjtuhc.demo.service.MovieService;

@Service
public class MovieServiceImpl implements MovieService{

	@Autowired
	MovieMapper movieMapper;
	
	@Override
	public List<Movie> getMovieList() {
		// TODO Auto-generated method stub
		return movieMapper.selectAllMovies();
	}

	@Override
	public int createMovie(Movie movie, InputStream fileStream) {
		// TODO Auto-generated method stub
		String path = "D:\\localFiles\\";
		int i = -1;
		byte[] bs = new byte[1024];
        // 读取到的数据长度
        int len;
        // 输出的文件流保存到本地文件
        try {     	        
	        File tempFile = new File(path);
	        if (!tempFile.exists()) {
	            tempFile.mkdirs();
	        }
	        
	        Date today = new Date();
	        String fileName = today.getTime()+movie.getPoster();
	        movie.setPoster("/posters/"+fileName);
	        OutputStream os = new FileOutputStream(tempFile.getPath() + File.separator + fileName);
	        // 开始读取
	        while ((len = fileStream.read(bs)) != -1) {
	            os.write(bs, 0, len);
	        }
        }catch (Exception e) {
			// TODO: handle exception
        	e.printStackTrace();
        	i = -2;
		}
        if(movie.getPoster().equals("")) {
        	i = -3;
        }else {
        	
        	//调用mapper，将movie信息存入数据库
        	i = movieMapper.insertMovie(movie);
        }
			
		return i;
	}
	
}
