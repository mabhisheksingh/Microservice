package MovieCatalogService.moviecatalogservice.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode( callSuper = false)
//No need to create table in db
public class MovieCatalog {
	private String  movieName;
	private Float rating;
}
