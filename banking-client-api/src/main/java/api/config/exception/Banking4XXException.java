package api.config.exception;

import api.response.BankingExceptionResponse;
import lombok.Getter;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.reactive.function.client.WebClientException;

@Getter
public class Banking4XXException extends WebClientException {

    private BankingExceptionResponse response;
    private HttpStatusCode statusCode;

    public Banking4XXException(String msg, BankingExceptionResponse response, HttpStatusCode statusCode) {
        super(msg);
        this.response = response;
        this.statusCode = statusCode;
    }

}
