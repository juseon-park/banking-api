package api.controller;

import api.response.AccountRegistrationResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class MainSystemService {

    // 랜덤 응답 생성
    public ResponseEntity<AccountRegistrationResponse> generateRandomResponseRegister() {
        Random random = new Random();
        int statusCode = random.nextInt(3);
        switch (1) {
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
            default:
                return ResponseEntity
                        .status(500)
                        .body(new AccountRegistrationResponse("",
                                "BANKING_ERROR_999",
                                "일시적으로 사용 불가"));
        }
    }

    public ResponseEntity<AccountRegistrationResponse> generateRandomResponseTransfer() {
        return null;
    }

    public ResponseEntity<AccountRegistrationResponse> generateRandomResponseTransferResult() {
        return null;
    }
}
