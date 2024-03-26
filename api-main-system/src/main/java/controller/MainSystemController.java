package controller;

import api.request.AccountRegistrationRequest;
import api.response.TransferRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@RestController
@RequestMapping("/banking-api")
public class MainSystemController {

    // 계좌 등록 API
    @PostMapping("/register")
    public ResponseEntity<?> registerAccount(@RequestBody AccountRegistrationRequest request) {
        return generateRandomResponse();
    }

    // 계좌 이체 API
    @PostMapping("/transfer")
    public ResponseEntity<?> transferFunds(@RequestBody TransferRequest request) {
        return generateRandomResponse();
    }

    // 이체 결과 조회 API
    @GetMapping("/transfer/{tx_id}")
    public ResponseEntity<?> getTransferResult(@PathVariable("tx_id") String txId) {
        return generateRandomResponse();
    }

    // 랜덤 응답 생성
    private ResponseEntity<?> generateRandomResponse() {
        Random random = new Random();
        int statusCode = random.nextInt(3);
        Map<String, Object> responseBody = new HashMap<>();
        switch (statusCode) {
            case 0:
                responseBody.put("result", "SUCCESS");
                break;
            case 1:
                responseBody.put("code", "BANKING_ERROR_XXX");
                responseBody.put("message", "Error message");
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseBody);
            case 2:
                responseBody.put("code", "BANKING_ERROR_XXX");
                responseBody.put("message", "Error message");
                return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(responseBody);
            default:
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        return ResponseEntity.ok().body(responseBody);
    }
}