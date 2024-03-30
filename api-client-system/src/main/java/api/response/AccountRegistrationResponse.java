package api.response;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class AccountRegistrationResponse {
    String bankAccountId;
    String code;
    String message;

}
