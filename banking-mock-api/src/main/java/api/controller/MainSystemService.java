package api.controller;

import api.request.TransferRequest;
import api.response.AccountRegistrationResponse;
import api.response.BankingExceptionResponse;
import api.response.TransferResponse;
import api.response.TransferResultResponse;
import code.BankingExceptionCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class MainSystemService {
    Random random = new Random();
    // 랜덤 응답 생성
    public ResponseEntity<AccountRegistrationResponse> generateRandomResponseRegister() {
        int statusCode = random.nextInt(4);
        switch (statusCode) {
            case 0:
                return ResponseEntity
                        .status(200)
                        .body(new AccountRegistrationResponse(String.valueOf(random.nextInt(99999999))));
            case 1:
                throw new BankingException("BANKING_ERROR_100 : 잘못된 계좌 정보", ResponseEntity.status(400)
                        .body(new BankingExceptionResponse(
                                BankingExceptionCode.REGISTER_BANKING_ERROR_100.getCode()
                                ,BankingExceptionCode.REGISTER_BANKING_ERROR_100.getMsg()))
                );
            case 2:
                throw new BankingException("BANKING_ERROR_101 : 등록할 수 없는 계좌", ResponseEntity.status(422)
                        .body(new BankingExceptionResponse(
                                BankingExceptionCode.REGISTER_BANKING_ERROR_101.getCode()
                                ,BankingExceptionCode.REGISTER_BANKING_ERROR_101.getMsg()))
                );
            case 3:
                throw new BankingException("BANKING_ERROR_999 : 일시적으로 사용 불가", ResponseEntity.status(500)
                        .body(new BankingExceptionResponse(
                                BankingExceptionCode.REGISTER_BANKING_ERROR_999.getCode()
                                ,BankingExceptionCode.REGISTER_BANKING_ERROR_999.getMsg()))
                );
            default:
                    throw new InternalError("value should be 0~3");
        }
    }

    public ResponseEntity<TransferResponse> generateRandomResponseTransfer(TransferRequest request) {
        int statusCode = random.nextInt(7);
        String bankTxId = String.valueOf(random.nextInt(99999999));
        switch (statusCode) {
            case 0:
                return ResponseEntity
                        .status(200)
                        .body(new TransferResponse(request.getTxId(),
                                bankTxId,
                                "SUCCESS"));
            case 1:
                return ResponseEntity
                            .status(200)
                            .body(new TransferResponse(request.getTxId(),
                                      bankTxId,
                                     "FAIL"));

            case 2:
                // 등록되지 않은 계좌
                throw new BankingException("BANKING_ERROR_200 : 등록되지 않은 계좌 ID", ResponseEntity.status(400)
                                                                                      .body(new BankingExceptionResponse(
                                                                                              BankingExceptionCode.TRANSFER_BANKING_ERROR_200.getCode(),
                                                                                              BankingExceptionCode.TRANSFER_BANKING_ERROR_200.getMsg()))
                                                                         );
            case 3:
                // 잘못된 계좌 정보
                throw new BankingException("BANKING_ERROR_201 : 잘못된 계좌 정보", ResponseEntity.status(400)
                                                                                .body(new BankingExceptionResponse(
                                                                                        BankingExceptionCode.TRANSFER_BANKING_ERROR_201.getCode(),
                                                                                        BankingExceptionCode.TRANSFER_BANKING_ERROR_201.getMsg()))
                                                                        );
            case 4:
                // 계좌 잔액 부족
                throw new BankingException("BANKING_ERROR_202 : 계좌 잔액 부족", ResponseEntity.status(422)
                                                                                .body(new BankingExceptionResponse(
                                                                                        BankingExceptionCode.TRANSFER_BANKING_ERROR_202.getCode(),
                                                                                        BankingExceptionCode.TRANSFER_BANKING_ERROR_202.getMsg()))
                                                                        );
            case 5:
                // 이체할 수 없는 계좌
                throw new BankingException("BANKING_ERROR_203 : 이체할 수 없는 계좌", ResponseEntity.status(422)
                                                                                    .body(new BankingExceptionResponse(
                                                                                            BankingExceptionCode.TRANSFER_BANKING_ERROR_203.getCode(),
                                                                                            BankingExceptionCode.TRANSFER_BANKING_ERROR_203.getMsg()))
                                                                        );
            case 6:
                // 일시적으로 사용 불가
                throw new BankingException("BANKING_ERROR_999 : 일시적으로 사용 불가", ResponseEntity.status(500)
                                                                                    .body(new BankingExceptionResponse(
                                                                                            BankingExceptionCode.TRANSFER_BANKING_ERROR_999.getCode(),
                                                                                            BankingExceptionCode.TRANSFER_BANKING_ERROR_999.getMsg()))
                                                                        );
            default:
                throw new InternalError("value should be 0~6");
        }
    }

    public ResponseEntity<TransferResultResponse> generateRandomResponseTransferResult() {
        int statusCode = random.nextInt(4);
        switch (statusCode) {
            case 0:
                return ResponseEntity
                        .status(200)
                        .body(new TransferResultResponse("SUCCESS"));
            case 1:
                return ResponseEntity
                        .status(200)
                        .body(new TransferResultResponse("FAIL"));
            case 2:
                throw new BankingException("BANKING_ERROR_200 : 잘못된 계좌 정보", ResponseEntity.status(400)
                                                                                .body(new BankingExceptionResponse(
                                                                                        BankingExceptionCode.CHECK_TRANSFER_BANKING_ERROR_200.getCode(),
                                                                                        BankingExceptionCode.CHECK_TRANSFER_BANKING_ERROR_200.getMsg()))
                );
            case 3:
                throw new BankingException("BANKING_ERROR_999 : 일시적으로 사용 불가", ResponseEntity.status(500)
                                                                                .body(new BankingExceptionResponse(
                                                                                        BankingExceptionCode.CHECK_TRANSFER_BANKING_ERROR_999.getCode(),
                                                                                        BankingExceptionCode.CHECK_TRANSFER_BANKING_ERROR_999.getMsg()))
                );
            default:
                System.out.println(statusCode);
                throw new InternalError("value should be 0~3");
        }
    }
}
