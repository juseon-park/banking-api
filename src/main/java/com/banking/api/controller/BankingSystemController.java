package com.banking.api.controller;

import com.banking.api.dto.RegistResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("banking-api")
public class BankingSystemController {

    @PostMapping(value = "/register")
    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public RegistResponseDto registerTest(){
        System.out.println(">>>>>>>>>>>>register<<<<<<<<<<<<<<<<");
        RegistResponseDto dto = new RegistResponseDto();
        dto.setCode("BANKING_ERROR_999");
        dto.setMessage("일시적으로 사용 불가");
        return dto;
    }
}
