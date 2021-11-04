package arquitectura.software.msaccount.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer accountId;
    private String name;

    public Account(){

    }
    public Account(Integer accountId, String name){
        this.accountId = accountId;
        this.name = name;
    }

    public Integer getAccountId() {
        return accountId;
    }
    public String getName() {
        return name;
    }
        public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }
    public void setName(String name) {
        this.name = name;
    }
    @Override
    public String toString(){
        return "Account{"+
        "accountId=" + accountId + 
        "name='" + name + '\'' +    
        '}';
    }

}

