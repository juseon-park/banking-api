package api.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class TransferResponse {
    String tx_id;
    String bankTxId;
    String result;
    String code;
    String message;
}
