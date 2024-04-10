package api.controller;

import api.response.BankingExceptionResponse;
import lombok.Getter;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.reactive.function.client.WebClientException;

@Getter
public class BankingException extends WebClientException {

    private ResponseEntity response;

    public BankingException(String msg, ResponseEntity response) {
        super(msg);
        this.response = response;
    }

}
