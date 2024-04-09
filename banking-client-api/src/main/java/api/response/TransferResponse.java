package api.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class TransferResponse {
    String txId;
    String bankTxId;
    String result;
}
