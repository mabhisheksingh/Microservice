package MovieCatalogService.moviecatalogservice.repositery;

import MovieCatalogService.moviecatalogservice.model.MovieCatalog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import java.util.List;


@Repository
@Transactional
public class MovieCatalogRepository {
	@Autowired
    EntityManagerFactory entityManagerFactory;

    @SuppressWarnings("unchecked")
	public List<MovieCatalog> getAllMovieCatalog(){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Query getAll = entityManager.createQuery("from MovieCatalog");
        List<MovieCatalog>  moviesList = getAll.getResultList();
        return moviesList;
    }
}
