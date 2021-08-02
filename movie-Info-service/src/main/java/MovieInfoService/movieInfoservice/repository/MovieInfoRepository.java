package MovieInfoService.movieInfoservice.repository;

import MovieInfoService.movieInfoservice.model.MovieInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import java.util.List;

@Repository
@Transactional
public class MovieInfoRepository {

    @Autowired
    EntityManagerFactory entityManagerFactory;

    @SuppressWarnings("unchecked")
	public List<MovieInfo> getAllMovie(){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Query getAll = entityManager.createQuery("from MovieInfo");
        List<MovieInfo>  moviesList = getAll.getResultList();
        return moviesList;
    }

    public MovieInfo getMovieName(Integer movieId){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Query getAll = entityManager.createQuery("from MovieInfo where movieId="+movieId);
        MovieInfo  moviesList =(MovieInfo) getAll.getResultList().get(0);
        entityManager.close();
        return moviesList;
    }
    public List<MovieInfo> getMovieNameByMovieIds(List<Integer> movieId){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Query getAll = entityManager.createQuery("from MovieInfo where movieId in :moviesId ");
        getAll.setParameter("moviesId",movieId);
        List<MovieInfo>  moviesList = getAll.getResultList();
        entityManager.close();
        return moviesList;
    }


}
