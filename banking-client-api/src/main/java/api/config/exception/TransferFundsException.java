package api.config.exception;

import api.response.BankingExceptionResponse;
import api.response.TransferResponse;
import lombok.Getter;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.reactive.function.client.WebClientException;

@Getter
public class TransferFundsException extends WebClientException {

    private TransferResponse response;
    private HttpStatusCode statusCode;

    public TransferFundsException(String msg, TransferResponse response, HttpStatusCode statusCode) {
        super(msg);
        this.response = response;
        this.statusCode = statusCode;
    }

}
