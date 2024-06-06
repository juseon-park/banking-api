package api.domain;


import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@EntityListeners(AuditingEntityListener.class)
@Builder
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Entity
@Table
public class BankingServerExceptionLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(nullable = false, length = 8)
    private String txId;

    @Column(nullable = false, length = 8)
    private String fromBankAccountId;

    @Column(nullable = false, length = 4)
    private String toBankCode;

    @Column(nullable = false, length = 10)
    private String toBankAccountNumber;

    @Column(nullable = false, length = 8)
    private String bankTxId;

    @CreatedDate
    private Timestamp creatDt;

}
