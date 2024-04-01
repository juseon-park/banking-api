package api.controller;

import api.request.AccountRegistrationRequest;
import api.response.AccountRegistrationResponse;
import api.service.BankingService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.client.UnknownHttpStatusCodeException;
import reactor.core.publisher.Mono;


@RestController
@RequestMapping("client")
@RequiredArgsConstructor
public class BankingController {

    private final BankingService bankingService;

    @PostMapping(value = "/account")
    @ResponseBody
    public Mono<AccountRegistrationResponse> registerAccount( @RequestBody AccountRegistrationRequest request){
        return bankingService.registerAccount(request);
    }

}
