package api.dto;

import api.domain.BankingServerExceptionLog;
import api.request.TransferRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Getter
@Builder
public class BankingServerExceptionLogDTO {
    private TransferRequest request;
    private String bankTxId;


    public BankingServerExceptionLog toEntity(){
        return BankingServerExceptionLog.builder()
                .txId(request.getTxId())
                .fromBankAccountId(request.getFromBankAccountId())
                .toBankCode(request.getToBankCode())
                .toBankAccountNumber(request.getToBankAccountNumber())
                .bankTxId(bankTxId)
                .build();
    }
}
