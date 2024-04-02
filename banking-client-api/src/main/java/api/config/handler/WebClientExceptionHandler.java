package api.config.handler;

import api.config.exception.TestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestController
@ControllerAdvice
public class WebClientExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(TestException.class)
    public final ResponseEntity<Object> handleRegisterAccountExceptions(TestException e) {
        System.out.println(e.getMessage());
        return new ResponseEntity(e.getResponse(), HttpStatus.NOT_FOUND);
    }
}
