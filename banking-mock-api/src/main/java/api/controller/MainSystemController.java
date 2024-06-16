package api.controller;

import api.request.AccountRegistrationRequest;
import api.request.TransferRequest;
import api.response.AccountRegistrationResponse;
import api.response.TransferResponse;
import api.response.TransferResultResponse;
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
        return mainSystemService.generateRandomResponseRegister();
    }

    // 계좌 이체 API
    @PostMapping("/transfer")
    public ResponseEntity<TransferResponse> transferFunds(@RequestBody TransferRequest request) {
        return mainSystemService.generateRandomResponseTransfer(request);
    }

    // 이체 결과 조회 API
    @GetMapping("/transfer/{txId}")
    public ResponseEntity<TransferResultResponse> getTransferResult(@PathVariable("txId") String txId) {
        return mainSystemService.generateRandomResponseTransferResult();
    }




}