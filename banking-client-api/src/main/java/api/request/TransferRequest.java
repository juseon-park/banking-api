package api.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class TransferRequest {
    String txId;
    String fromBankAccountId;
    String toBankCode;
    String toBankAccountNumber;
}
