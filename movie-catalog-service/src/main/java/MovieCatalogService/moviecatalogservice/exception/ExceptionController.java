package MovieCatalogService.moviecatalogservice.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;



@ControllerAdvice
public class ExceptionController extends ResponseEntityExceptionHandler{
    @ExceptionHandler(DataNotPresentException.class)
    public ResponseEntity<String> dataNotPresentException(DataNotPresentException dataNotPresentException){
        return new ResponseEntity<String>(dataNotPresentException.errorMsg ,dataNotPresentException.errorcode);
    }

    @Override
    protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        System.out.println("headers -> "+headers.getOrigin());
        System.out.println("status -> "+status.value());
        System.out.println("ex.getMessage -> "+ex.getMessage());
        System.out.println("request -> "+request.getContextPath());
        return new ResponseEntity<Object>( "Wrong Media type selected ",HttpStatus.UNSUPPORTED_MEDIA_TYPE );
    }

	

}
