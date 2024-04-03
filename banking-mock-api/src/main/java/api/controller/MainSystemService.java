package api.controller;

import api.request.TransferRequest;
import api.response.AccountRegistrationResponse;
import api.response.TransferResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class MainSystemService {

    // 랜덤 응답 생성
    public ResponseEntity<AccountRegistrationResponse> generateRandomResponseRegister() {
        Random random = new Random();
        int statusCode = random.nextInt(4);
        switch (statusCode) {
            case 0:
                return ResponseEntity
                        .status(200)
                        .body(new AccountRegistrationResponse(String.valueOf(random.nextInt(99999999)),
                                "",
                                ""));
            case 1:
                return ResponseEntity
                        .status(400)
                        .body(new AccountRegistrationResponse("",
                                "BANKING_ERROR_100",
                                "잘못된 계좌 정보"));
            case 2:
                return ResponseEntity
                        .status(422)
                        .body(new AccountRegistrationResponse("",
                                "BANKING_ERROR_101",
                                "등록할 수 없는 계좌"));
            case 3:
                return ResponseEntity
                        .status(500)
                        .body(new AccountRegistrationResponse("",
                                "BANKING_ERROR_999",
                                "일시적으로 사용 불가"));
            default:
                    throw new InternalError("value should be 0~3");
        }
    }

    public ResponseEntity<TransferResponse> generateRandomResponseTransfer(TransferRequest request) {
        Random random = new Random();
        int statusCode = random.nextInt(7);
        System.out.println(statusCode);
        switch (statusCode) {
            case 0:
                return ResponseEntity
                        .status(200)
                        .body(new TransferResponse(request.getTxId(),
                                String.valueOf(random.nextInt(99999999)),
                                "SUCCESS",
                                "",
                                ""));
            case 1:
                return ResponseEntity
                        .status(200)
                        .body(new TransferResponse(request.getTxId(),
                                String.valueOf(random.nextInt(99999999)),
                                "FAIL",
                                "",
                                ""));

            case 2:
                // 등록되지 않은 계좌 ID
                return ResponseEntity
                        .status(400)
                        .body(new TransferResponse(
                                "",
                                "",
                                "",
                                "BANKING_ERROR_200",
                                "등록되지 않은 계좌 ID"));
            case 3:
                // 잘못된 계좌 정보
                return ResponseEntity
                        .status(400)
                        .body(new TransferResponse(
                                "",
                                "",
                                "",
                                "BANKING_ERROR_201",
                                "잘못된 계좌 정보"));
            case 4:
                // 계좌 잔액 부족
                return ResponseEntity
                        .status(422)
                        .body(new TransferResponse(
                                request.getTxId(),
                                "",
                                "",
                                "BANKING_ERROR_202",
                                "계좌 잔액 부족"));
            case 5:
                // 이체할 수 없는 계좌
                return ResponseEntity
                        .status(422)
                        .body(new TransferResponse(
                                "",
                                "",
                                "",
                                "BANKING_ERROR_203",
                                "이체할 수 없는 계좌"));
            case 6:
                // 일시적으로 사용 불가
                return ResponseEntity
                        .status(500)
                        .body(new TransferResponse(
                                "",
                                "",
                                "",
                                "BANKING_ERROR_999",
                                "일시적으로 사용 불가"));
            default:
                throw new InternalError("value should be 0~3");
        }
    }

    public ResponseEntity<AccountRegistrationResponse> generateRandomResponseTransferResult() {
        return null;
    }
}
