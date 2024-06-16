package api.config.handler;


import api.config.exception.Banking4XXException;
import api.config.exception.Banking5XXException;
import api.repository.BankingServerExceptionLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class BankingExceptionHandler extends ResponseEntityExceptionHandler {

    @Autowired
    BankingServerExceptionLogRepository repository;

    @ExceptionHandler(Banking4XXException.class)
    public final ResponseEntity<Banking4XXException> handleBanking4XXExceptions(Banking4XXException e) {
        return new ResponseEntity(e.getResponse(), e.getStatusCode());
    }

    @ExceptionHandler(Banking5XXException.class)
    public final ResponseEntity<Banking5XXException> handleBanking5XXExceptions(Banking5XXException e) {
        repository.save(e.getDto().toEntity());
        return new ResponseEntity(e.getResponse(), e.getStatusCode());
    }

}
