package api.repository;

import api.domain.BankingServerExceptionLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankingServerExceptionLogRepository extends JpaRepository<BankingServerExceptionLog,Long> {

}
