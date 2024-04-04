package api.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class AccountRegistrationRequest {
    String bankCode;
    String bankAccountNumber;
}
