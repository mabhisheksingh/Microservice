package MovieInfoService.movieInfoservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name ="movieinfo")
public class MovieInfo {
    @Id
    @Column(name = "movieid")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int movieId;
    @Column(name = "moviename")
    private String movieName;
}
