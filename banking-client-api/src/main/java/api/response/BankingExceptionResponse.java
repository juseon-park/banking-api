package api.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class BankingExceptionResponse {
    String code;
    String message;
    String bankTxId;

    public BankingExceptionResponse(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
