package api.config.exception;

import api.response.BankingExceptionResponse;
import lombok.Getter;
import org.springframework.web.reactive.function.client.WebClientException;

@Getter
public class TestException extends WebClientException {

    private BankingExceptionResponse response;

    public TestException(String msg,BankingExceptionResponse response) {
        super(msg);
        this.response = response;
    }

}
