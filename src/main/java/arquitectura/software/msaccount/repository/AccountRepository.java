package arquitectura.software.msaccount.repository;

import arquitectura.software.msaccount.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface AccountRepository extends JpaRepository<Account, Integer>{
    
}
