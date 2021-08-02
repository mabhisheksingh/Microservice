package MovieCatalogService.moviecatalogservice.controller;

import MovieCatalogService.moviecatalogservice.model.MovieCatalog;
import MovieCatalogService.moviecatalogservice.model.MovieInfo;
import MovieCatalogService.moviecatalogservice.model.RatingData;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;



@RestController
@RequestMapping(value = "/" )
public class MovieCatalogController {

    @Autowired
    private USERMovieInfo userMovieInfo;
    @Autowired
    private UserratingInfo userratingInfo;


    @RequestMapping(value="/getCatalog/{userid}", method=RequestMethod.GET)
    //for betterment we can divide in 2 methods
    public ResponseEntity<Object> getCatalog(@PathVariable("userid") Integer userId) {
        ResponseEntity<Object> ratinglist = userratingInfo.getRatingDataByUserId(userId);
        System.out.println(
                ratinglist.getBody()
        );
        @SuppressWarnings("unchecked")
		List<RatingData> rdlist = (List<RatingData>) ratinglist.getBody();
        ObjectMapper mapper = new ObjectMapper();
        List<RatingData> ratingDataList = mapper.convertValue(
                rdlist,new TypeReference<List<RatingData>>() { });
        List<Integer> movieIds = ratingDataList.stream()
               .map(c -> c.getMovieId()).
                collect(Collectors.toList());
        System.out.println("List of movie id's "+movieIds);
        List<MovieInfo> movieInfolist = userMovieInfo.getMovieInfolists(movieIds);

        System.out.println("All movieInfolist : "+movieInfolist);
        List<MovieCatalog> movieCatalogs = new ArrayList<>();
        for(MovieInfo movieInfo : movieInfolist){
            for(RatingData rd : ratingDataList ){
                if(movieInfo.getMovieId() == rd.getMovieId()){
                    movieCatalogs.add(new MovieCatalog( movieInfo.getMovieName() , rd.getRating()));
                }
            }
        }
        return new ResponseEntity<Object>(movieCatalogs,HttpStatus.OK);
    }


}
