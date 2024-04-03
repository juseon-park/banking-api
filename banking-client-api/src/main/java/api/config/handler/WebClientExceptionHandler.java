package api.config.handler;


import api.config.exception.TransferFundsException;
import api.config.exception.registerAccountException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestController
@ControllerAdvice
public class WebClientExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(registerAccountException.class)
    public final ResponseEntity<Object> handleRegisterAccountExceptions(registerAccountException e) {
        System.out.println(e.getMessage());
        return new ResponseEntity(e.getResponse(), e.getStatusCode());
    }

    @ExceptionHandler(TransferFundsException.class)
    public final ResponseEntity<Object> handleRegisterAccountExceptions(TransferFundsException e) {
        System.out.println(e.getMessage());
        return new ResponseEntity(e.getResponse(), e.getStatusCode());
    }
}
