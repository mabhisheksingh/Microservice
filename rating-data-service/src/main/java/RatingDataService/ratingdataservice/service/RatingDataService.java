package RatingDataService.ratingdataservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import RatingDataService.ratingdataservice.exception.DataNotPresentException;
import RatingDataService.ratingdataservice.model.RatingData;
import RatingDataService.ratingdataservice.repositery.RatingDataRepository;


@Service
public class RatingDataService {

    @Autowired
   private RatingDataRepository ratingDataRepository;

    public List<RatingData> getAllMovie(){
        List<RatingData> list = ratingDataRepository.getAllRatigData();
        if(list.isEmpty()){
            throw new DataNotPresentException("No movie present in DB", HttpStatus.NO_CONTENT);
        }
        return list;
    }

    public List<RatingData> getRatingDataByUserId(Integer userid){
        List<RatingData> rd = ratingDataRepository.getRatingDataByUserId(userid);
        if(rd.isEmpty()){
            throw new DataNotPresentException("No movie present in DB", HttpStatus.NO_CONTENT);
        }
        return rd;
    }
}
