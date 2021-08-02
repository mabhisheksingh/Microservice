package MovieInfoService.movieInfoservice.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
@EqualsAndHashCode(callSuper = false)
public class DataNotPresentException extends  RuntimeException {

	private static final long serialVersionUID = -3090275395072952467L;
	String errorMsg;
    HttpStatus errorcode;

}
