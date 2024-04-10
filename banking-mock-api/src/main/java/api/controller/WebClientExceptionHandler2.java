package api.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestController
@ControllerAdvice
public class WebClientExceptionHandler2 extends ResponseEntityExceptionHandler {

    @ExceptionHandler(BankingException.class)
    public final ResponseEntity<Object> handleRegisterAccountExceptions(BankingException e) {
        return e.getResponse();
    }


}
