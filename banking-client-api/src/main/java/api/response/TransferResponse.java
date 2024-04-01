package api.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class TransferResponse {
    String bankTxId;
    String code;
    String message;
}
