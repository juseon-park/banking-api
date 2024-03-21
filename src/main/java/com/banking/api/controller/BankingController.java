package com.banking.api.controller;

import com.banking.api.dto.RegistRequestDto;
import com.banking.api.dto.RegistResponseDto;
import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.*;

@RestController
@RequestMapping("fromApi")
public class BankingController {

    @PostMapping(value = "/register")
    @ResponseBody
    public RegistResponseDto register(@RequestBody RegistRequestDto requestDto){
        String url = "http://localhost:80/banking-api/register";

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);

        MultiValueMap<String, String> body = new LinkedMultiValueMap<>();
        body.add("bank_code", requestDto.getBankCode());
        body.add("bank_account_number", requestDto.getBankAccountNumber());

        HttpEntity requestMessage = new HttpEntity(body, httpHeaders);
        RestTemplate restTemplate = new RestTemplate();
        try {
            ResponseEntity<RegistResponseDto> response = restTemplate.postForEntity(
                                            url,
                                            requestMessage,
                                            RegistResponseDto.class
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
