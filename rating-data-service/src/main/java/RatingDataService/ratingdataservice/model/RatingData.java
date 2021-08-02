package RatingDataService.ratingdataservice.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name ="ratingdata")
public class RatingData implements Serializable {
	
	
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name ="userid")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer userId;
	@Id
	@Column(name ="movieid")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer movieId;
	@Column(name ="rating")
	private Float rating;
	

}
