package api.service;

import api.config.exception.Banking4XXException;
import api.config.exception.Banking5XXException;
import api.request.AccountRegistrationRequest;
import api.request.TransferRequest;
import api.response.BankingExceptionResponse;
import api.response.AccountRegistrationResponse;
import api.response.TransferResponse;
import api.response.TransferResultResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
@PropertySource("classpath:application.yaml")
public class BankingService {

    @Value("${host.mock.banking.url}") String url;

    public Mono<AccountRegistrationResponse> registerAccount(AccountRegistrationRequest request){
            Mono<AccountRegistrationResponse> response = WebClient.builder()
                    .baseUrl(url)
                    .build()
                    .post()
                    .uri("/register")
                    .accept(MediaType.APPLICATION_JSON)
                    .bodyValue(request)
                    .retrieve()
                    .onStatus(status -> status.is4xxClientError() || status.is5xxServerError()
                            , clientResponse ->
                                    clientResponse.toEntity(BankingExceptionResponse.class)
                                            .flatMap(body -> Mono.error(new Banking4XXException("Register Account Error",body.getBody(), body.getStatusCode()))))
                    .bodyToMono(AccountRegistrationResponse.class);
            return response;

    }

    public Mono<TransferResponse> transferFunds(TransferRequest request){
        Mono<TransferResponse> response = WebClient.builder()
                .baseUrl(url)
                .build()
                .post()
                .uri("/transfer")
                .accept(MediaType.APPLICATION_JSON)
                .bodyValue(request)
                .retrieve()
                .onStatus(status -> status.is4xxClientError()
                        , clientResponse ->
                                clientResponse.toEntity(BankingExceptionResponse.class)
                                        .flatMap(body -> Mono.error(new Banking4XXException("Transfer Funds Client Error", body.getBody(), body.getStatusCode()))))
                .onStatus(status -> status.is5xxServerError()
                        , clientResponse ->
                                clientResponse.toEntity(BankingExceptionResponse.class)
                                        .flatMap(body -> Mono.error(new Banking5XXException("Transfer Funds Server Error", body.getBody(), body.getStatusCode(), request))))
                .bodyToMono(TransferResponse.class);
        return response;

    }

    public Mono<TransferResultResponse> getTransferResult(String txId){
        Mono<TransferResultResponse> response = WebClient.builder()
                .baseUrl(url)
                .build()
                .get()
                .uri(uriBuilder -> uriBuilder
                        .path("/transfer/{txId}")
                        .build(txId))
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .onStatus(status -> status.is4xxClientError() || status.is5xxServerError()
                        , clientResponse ->
                                clientResponse.toEntity(BankingExceptionResponse.class)
                                        .flatMap(body -> Mono.error(new Banking4XXException("Get Transfer Result Error", body.getBody(), body.getStatusCode()))))
                .bodyToMono(TransferResultResponse.class);
        return response;

    }

}
