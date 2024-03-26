package api.controller;

import api.request.AccountRegistrationRequest;
import api.request.AccountRegistrationResponse;
import api.response.TransferRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Random;

@RestController
@RequestMapping("/banking-api")
public class MainSystemController {

    // 계좌 등록 API
    @PostMapping("/register")
    public ResponseEntity<AccountRegistrationResponse> registerAccount(@RequestBody AccountRegistrationRequest request) {
        AccountRegistrationResponse response = generateRandomResponseRegister();
        return ResponseEntity.status(response.getStatusCode()).body(response);
    }

    // 계좌 이체 API
    @PostMapping("/transfer")
    public ResponseEntity<AccountRegistrationResponse> transferFunds(@RequestBody TransferRequest request) {
        AccountRegistrationResponse response = generateRandomResponseRegister();
        return ResponseEntity.status(response.getStatusCode()).body(response);
    }

    // 이체 결과 조회 API
    @GetMapping("/transfer/{tx_id}")
    public ResponseEntity<AccountRegistrationResponse> getTransferResult(@PathVariable("tx_id") String txId) {
        AccountRegistrationResponse response = generateRandomResponseRegister();
        return ResponseEntity.status(response.getStatusCode()).body(response);
    }

    // 랜덤 응답 생성
    private AccountRegistrationResponse generateRandomResponseRegister() {
        Random random = new Random();
        int statusCode = random.nextInt(3);
        switch (statusCode) {
            case 0:
                return new AccountRegistrationResponse(200,String.valueOf(random.nextInt(99999999)), "", "");
            case 1:
                return new AccountRegistrationResponse(400,"", "BANKING_ERROR_100", "잘못된 계좌 정보");
            case 2:
                return new AccountRegistrationResponse(422,"", "BANKING_ERROR_101", "등록할 수 없는 계좌");
            default:
                return new AccountRegistrationResponse(500,"", "BANKING_ERROR_999", "일시적으로 사용 불가");
        }
    }

    private AccountRegistrationResponse generateRandomResponseTransfer() {
        return null;
    }

    private AccountRegistrationResponse generateRandomResponseTransferResult() {
        return null;
    }
}