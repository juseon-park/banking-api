package api.config.exception;

import api.response.BankingExceptionResponse;
import lombok.Getter;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.reactive.function.client.WebClientException;

@Getter
public class registerAccountException extends WebClientException {

    private BankingExceptionResponse response;
    private HttpStatusCode statusCode;

    public registerAccountException(String msg, BankingExceptionResponse response,HttpStatusCode statusCode) {
        super(msg);
        this.response = response;
        this.statusCode = statusCode;
    }

}
