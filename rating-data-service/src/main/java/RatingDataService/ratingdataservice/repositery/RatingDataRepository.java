package RatingDataService.ratingdataservice.repositery;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import RatingDataService.ratingdataservice.model.RatingData;



@Repository
@Transactional
public class RatingDataRepository {
	@Autowired
    EntityManagerFactory entityManagerFactory;

    @SuppressWarnings("unchecked")
	public List<RatingData> getAllRatigData(){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Query getAll = entityManager.createQuery("from RatingData");
        List<RatingData>  moviesList = getAll.getResultList();
        return moviesList;
    }

    @SuppressWarnings("unchecked")
    @Transactional
	public List<RatingData> getRatingDataByUserId(Integer userid){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Query getAll = entityManager.createQuery("from RatingData where userId="+userid);
        List<RatingData>  moviesList = getAll.getResultList();
        entityManager.close();
        return moviesList;
    }
}
