package api.service;

import api.config.exception.TestException;
import api.request.AccountRegistrationRequest;
import api.response.BankingExceptionResponse;
import api.response.AccountRegistrationResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
@PropertySource("classpath:application.yaml")
public class BankingService {

    @Value("${mainSystemUrl}") String url;

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
                                    clientResponse.bodyToMono(BankingExceptionResponse.class)
                                            .map(body -> new TestException("test error",body)))
//                    .onStatus(HttpStatusCode::isError, e -> {
//                                System.out.println(e.statusCode());
//                                return Mono.just(new customException());
//                            }
//                    )
                    .bodyToMono(AccountRegistrationResponse.class);
                    //coustom exception으로 에러코드별 처리
//                    .exchangeToMono(clientResponse -> {
//                        if (clientResponse.statusCode().equals(HttpStatus.OK))
//                            return clientResponse.bodyToMono(AccountRegistrationResponse.class);
//                        else
//                            return clientResponse.createError();
//                        });


            return response;

    }

}
