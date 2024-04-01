package api.controller;

import api.request.AccountRegistrationRequest;
import api.request.TransferRequest;
import api.response.AccountRegistrationResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/banking-api")
public class MainSystemController {

    private final MainSystemService mainSystemService;

    // 계좌 등록 API
    @PostMapping("/register")
    public ResponseEntity<AccountRegistrationResponse> registerAccount(@RequestBody AccountRegistrationRequest request) {
        ResponseEntity<AccountRegistrationResponse> test = mainSystemService.generateRandomResponseRegister();
        System.out.println(":::::::::::::::get body ::::::::"+test.getBody());
        System.out.println(":::::::::::::::get code ::::::::"+test.getStatusCode());
        return test;
//        return mainSystemService.generateRandomResponseRegister();
    }

    // 계좌 이체 API
    @PostMapping("/transfer")
    public ResponseEntity<AccountRegistrationResponse> transferFunds(@RequestBody TransferRequest request) {
        return mainSystemService.generateRandomResponseRegister();
    }

    // 이체 결과 조회 API
    @GetMapping("/transfer/{tx_id}")
    public ResponseEntity<AccountRegistrationResponse> getTransferResult(@PathVariable("tx_id") String txId) {
        return mainSystemService.generateRandomResponseRegister();
    }




}