package arquitectura.software.msaccount.api;

import arquitectura.config.AccountConfig;
import arquitectura.software.msaccount.entity.Account;
import arquitectura.software.msaccount.repository.AccountRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.CustomAutowireConfigurer;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/api/account")

public class AccountController{

    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private AccountConfig accountConfig;
    
    @RequestMapping(path = "/test",
                    method = RequestMethod.GET)
    public String testAccount(){
        return "Ms-account";
    }

    @RequestMapping(path = "/save",
                     method = RequestMethod.POST)
    public Account saveAccount(@RequestBody Account account){
        System.out.println("Registrando al cliente -->: " + accountConfig.showConfiguration());
       return accountRepository.save(account);
    }

    @RequestMapping(path = "/all",
                    method = RequestMethod.GET)
    public List<Account> getAllAccount(){
        List<Account> accounts = accountRepository.findAll();
        return accounts;
    }

    @RequestMapping(
                    method = RequestMethod.GET)
    public Account getAccount(@RequestParam Integer accountId) throws Exception{
        Optional<Account> accountOptional = accountRepository.findById(accountId);
        if(accountOptional.isPresent()){
            Account account = accountOptional.get();
            return account;
        }else{
            throw new Exception("No se encuentra la cuenta");
        } 
    }

}
