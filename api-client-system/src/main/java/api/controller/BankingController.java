package api.controller;

import api.request.AccountRegistrationRequest;
import api.response.AccountRegistrationResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
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

@ComponentScan
@RestController
@RequestMapping("client")
@PropertySource("classpath:application.yaml")
public class BankingController {

    @Value("${mainSystemUrl}") String url;

    @PostMapping(value = "/account")
    @ResponseBody
    public AccountRegistrationResponse registerAccount( @RequestBody AccountRegistrationRequest requestDto){
        System.out.println(url);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);

        MultiValueMap<String, String> body = new LinkedMultiValueMap<>();
        body.add("bank_code", requestDto.getBankCode());
        body.add("bank_account_number", requestDto.getBankAccountNumber());

        HttpEntity requestMessage = new HttpEntity(body, httpHeaders);
        RestTemplate restTemplate = new RestTemplate();
        try {
            ResponseEntity<AccountRegistrationResponse> response = restTemplate.postForEntity(
                                            url,
                                            requestMessage,
                                            AccountRegistrationResponse.class
            );
            return response.getBody();
        } catch (HttpStatusCodeException e){
            if( "400".equals(e.getStatusCode()) ){
                System.out.println(e.getMessage());
            }else if("422".equals(e.getStatusCode())){
                System.out.println(e.getMessage());
            }else if("500".equals(e.getStatusCode())){
                System.out.println(e.getMessage());
            }
        } catch (UnknownHttpStatusCodeException e){
                System.out.println(e.getMessage());
        }


        return null;
    }

}
