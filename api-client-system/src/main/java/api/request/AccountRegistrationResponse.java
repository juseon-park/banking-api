package api.request;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class AccountRegistrationResponse {
    int statusCode;
    String bankAccountId;
    String code;
    String message;

}
