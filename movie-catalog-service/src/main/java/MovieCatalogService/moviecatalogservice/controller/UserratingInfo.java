package MovieCatalogService.moviecatalogservice.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserratingInfo {

    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "getRatingDataByUserIdFallback")
    public ResponseEntity<Object> getRatingDataByUserId(Integer userId){
        return restTemplate.getForEntity("http://RATINGDATASERVICE/getRatingDataByUserId/"+userId, Object.class);
    }

    public ResponseEntity<Object> getRatingDataByUserIdFallback(Integer userId){
        return new ResponseEntity<>("rating not found", HttpStatus.OK);
    }

}
