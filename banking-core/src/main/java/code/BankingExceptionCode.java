package code;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum BankingExceptionCode {
    REGISTER_BANKING_ERROR_100("BANKING_ERROR_100","잘못된 계좌 정보"),
    REGISTER_BANKING_ERROR_101("BANKING_ERROR_101","등록할 수 없는 계좌"),
    REGISTER_BANKING_ERROR_999("BANKING_ERROR_999","일시적으로 사용 불가"),

    TRANSFER_BANKING_ERROR_200("BANKING_ERROR_200","등록되지 않은 계좌 ID"),
    TRANSFER_BANKING_ERROR_201("BANKING_ERROR_201","잘못된 계좌 정보"),
    TRANSFER_BANKING_ERROR_202("BANKING_ERROR_202","계좌 잔액 부족"),
    TRANSFER_BANKING_ERROR_203("BANKING_ERROR_203","이체할 수 없는 계좌"),
    TRANSFER_BANKING_ERROR_999("BANKING_ERROR_999","일시적으로 사용 불가"),

    CHECK_TRANSFER_BANKING_ERROR_200("BANKING_ERROR_200","잘못된 거래 ID"),
    CHECK_TRANSFER_BANKING_ERROR_999("BANKING_ERROR_999","일시적으로 사용 불가");

    String code;
    String msg;

}
