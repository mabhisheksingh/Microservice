package MovieCatalogService.moviecatalogservice.controller;

import MovieCatalogService.moviecatalogservice.model.MovieInfo;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.netflix.hystrix.contrib.javanica.conf.HystrixPropertiesManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class USERMovieInfo {
    @Autowired
    HttpHeaders headers;
    @Autowired
    private RestTemplate restTemplate;
    //some more command
    @HystrixCommand(fallbackMethod = "FallbackgetMovieInfolists",commandProperties = {
            @HystrixProperty(name = HystrixPropertiesManager.EXECUTION_ISOLATION_THREAD_TIMEOUT_IN_MILLISECONDS ,value = "2000"),
            @HystrixProperty(name = HystrixPropertiesManager.CIRCUIT_BREAKER_REQUEST_VOLUME_THRESHOLD ,value = "5"),
            @HystrixProperty(name = HystrixPropertiesManager.CIRCUIT_BREAKER_ERROR_THRESHOLD_PERCENTAGE ,value = "50"),
            @HystrixProperty(name = HystrixPropertiesManager.CIRCUIT_BREAKER_SLEEP_WINDOW_IN_MILLISECONDS ,value = "5000")
    })
    public List<MovieInfo> getMovieInfolists(List<Integer> movieIds){
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<List<Integer>> httpEntity = new HttpEntity<>(movieIds,headers);
        ResponseEntity<Object> movieInfolists = restTemplate.exchange("http://MOVIEINFOSERVICE/getMovieList", HttpMethod.POST, httpEntity,Object.class);
        ObjectMapper mapper = new ObjectMapper();
        List<MovieInfo> list = mapper.convertValue(movieInfolists.getBody(), new TypeReference<List<MovieInfo>>() {});
        return  list;
    }

    public List<MovieInfo> FallbackgetMovieInfolists(List<Integer> movieIds){
        return  Arrays.asList(new MovieInfo(1,"sas"),new MovieInfo(2,"AA"));
    }

}
