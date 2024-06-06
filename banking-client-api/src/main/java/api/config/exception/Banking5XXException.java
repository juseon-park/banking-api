package api.config.exception;

import api.dto.BankingServerExceptionLogDTO;
import api.request.TransferRequest;
import api.response.BankingExceptionResponse;
import lombok.Getter;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.reactive.function.client.WebClientException;

@Getter
public class Banking5XXException extends WebClientException {

    private BankingExceptionResponse response;
    private HttpStatusCode statusCode;
    private BankingServerExceptionLogDTO dto;

    public Banking5XXException(String msg, BankingExceptionResponse response, HttpStatusCode statusCode, TransferRequest request) {
        super(msg);
        this.response = response;
        this.statusCode = statusCode;
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> ::" + response.getBankTxId());
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> ::" + request.getFromBankAccountId());
        dto = BankingServerExceptionLogDTO
                .builder()
                .request(request)
                .bankTxId(response.getBankTxId())
                .build();
    }

}
