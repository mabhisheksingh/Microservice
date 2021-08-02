package MovieInfoService.movieInfoservice.service;

import MovieInfoService.movieInfoservice.exception.DataNotPresentException;
import MovieInfoService.movieInfoservice.model.MovieInfo;
import MovieInfoService.movieInfoservice.repository.MovieInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieInfoService {

    @Autowired
    MovieInfoRepository movieInfoRepository;

    public List<MovieInfo> getAllMovie(){
        List<MovieInfo> list = movieInfoRepository.getAllMovie();
        if(list.isEmpty()){
            throw new DataNotPresentException("No movie present in DB", HttpStatus.NO_CONTENT);
        }
        return list;
    }

    public MovieInfo getMovieName(Integer movieId){
        MovieInfo list = movieInfoRepository.getMovieName(movieId);
        if(list == null){
            throw new DataNotPresentException("No movie present in DB", HttpStatus.NO_CONTENT);
        }
        return list;
    }

    public List<MovieInfo> getMovieNameByMovieIds(List<Integer> movieId){
        List<MovieInfo> list = movieInfoRepository.getMovieNameByMovieIds(movieId);
        if(list == null){
            throw new DataNotPresentException("No movie present in DB", HttpStatus.NO_CONTENT);
        }
        return list;
    }
}
