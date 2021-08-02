package MovieCatalogService.moviecatalogservice.service;

import MovieCatalogService.moviecatalogservice.exception.DataNotPresentException;
import MovieCatalogService.moviecatalogservice.model.MovieCatalog;
import MovieCatalogService.moviecatalogservice.repositery.MovieCatalogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class MovieCatalogService {

    @Autowired
    private MovieCatalogRepository movieCatalogRepository;

    public List<MovieCatalog> getAllMovieCatalog(){
        List<MovieCatalog> list = movieCatalogRepository.getAllMovieCatalog();
        if(list.isEmpty()){
            throw new DataNotPresentException("No movie present in DB", HttpStatus.NO_CONTENT);
        }
        return list;
    }
}
