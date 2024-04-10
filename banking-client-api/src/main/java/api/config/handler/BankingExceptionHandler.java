package api.config.handler;


import api.config.exception.BankingException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class BankingExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(BankingException.class)
    public final ResponseEntity<BankingException> handleRegisterAccountExceptions(BankingException e) {
        return new ResponseEntity(e.getResponse(), e.getStatusCode());
    }

}
