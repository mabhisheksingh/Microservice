package MovieInfoService.movieInfoservice.controller;

import MovieInfoService.movieInfoservice.model.MovieInfo;
import MovieInfoService.movieInfoservice.service.MovieInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/")
public class MovieInfoController {

    @Autowired
    MovieInfoService movieInfoService;

    @RequestMapping(value = "/getAllMovie" ,method = RequestMethod.GET)
    public ResponseEntity<Object> getAllMovie(){
        List<MovieInfo> list = movieInfoService.getAllMovie();
        List<Integer> list1 = Arrays.asList(100,101);
        return new ResponseEntity<Object>(list1, HttpStatus.OK);
    }
    @RequestMapping(value = "/getMovie/{movieid}" ,method = RequestMethod.GET)
    public MovieInfo getMovieName(@PathVariable Integer movieid){
        MovieInfo mi = movieInfoService.getMovieName(movieid);
        System.out.println("Mi "+mi);
        return mi;
    }

    @RequestMapping(value = "/getMovieList" ,method = RequestMethod.POST)
    public ResponseEntity<Object> getMovieNameByMovieIds(@RequestBody List<Integer> movieids) throws InterruptedException {
        System.out.println(" MM "+movieids);
        List<MovieInfo> movieInfosList = movieInfoService.getMovieNameByMovieIds(movieids);
        System.out.println("All Movies By Id "+movieInfosList);
        Thread.sleep(5000);
        System.out.println("Sleeping for 5sec..");
        return new ResponseEntity<Object>(movieInfosList,HttpStatus.OK);
    }
}
