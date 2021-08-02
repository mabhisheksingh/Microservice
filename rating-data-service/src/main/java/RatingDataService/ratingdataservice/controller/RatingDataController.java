package RatingDataService.ratingdataservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import RatingDataService.ratingdataservice.model.RatingData;
import RatingDataService.ratingdataservice.service.RatingDataService;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(name= "/")
public class RatingDataController {

    @Autowired
    private RatingDataService ratingDataService;

    @RequestMapping(value = "/getAllRatingData" ,method = RequestMethod.GET)
    public ResponseEntity<Object> getAllRatingData(){
        List<RatingData> list = ratingDataService.getAllMovie();
        return new ResponseEntity<Object>(list, HttpStatus.OK);
    }

    @RequestMapping(value = "/getRatingDataByUserId/{userid}" ,method = RequestMethod.GET )
    public ResponseEntity<Object> getRatingDataByUserId(@PathVariable("userid")Integer userId){
        List<RatingData> list =ratingDataService.getRatingDataByUserId(userId);
        System.out.println("List : "+list);
        return new ResponseEntity<Object>( list,HttpStatus.OK);
    }
}
