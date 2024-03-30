package api.service;

import api.request.AccountRegistrationRequest;
import api.response.AccountRegistrationResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import reactor.core.publisher.Mono;

@Service
@PropertySource("classpath:application.yaml")
public class BankingService {

    @Value("${mainSystemUrl}") String url;

    public Mono<AccountRegistrationResponse> registerAccount(AccountRegistrationRequest request){
        try {
            Mono<AccountRegistrationResponse> response = WebClient.builder()
                    .baseUrl(url)
                    .build()
                    .post()
                    .uri("/register")
                    .accept(MediaType.APPLICATION_JSON)
                    .bodyValue(request)
                    .retrieve()
                    .onStatus(HttpStatusCode::isError, e -> {
                        System.out.println(e.statusCode());
                        System.out.println(e.bodyToMono(AccountRegistrationResponse.class));
                        return Mono.just(new Exception());
                        }
                    )
                    .bodyToMono(AccountRegistrationResponse.class);
            return response;
        }catch(WebClientResponseException e){
            System.out.println(":::::::::::: response status code :::::::::::: "+e.getStatusCode());
            System.out.println(":::::::::::: response body :::::::::::: "+e.getResponseBodyAsString());
            return null;
        }

    }

}
