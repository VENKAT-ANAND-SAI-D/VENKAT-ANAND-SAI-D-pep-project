package Service;

import Model.Account;
import DAO.AccountDAO;

public class AccountService {
    AccountDAO accountDAO;

    public AccountService(){
        accountDAO = new AccountDAO();
    }

    public AccountService(AccountDAO accountDAO){
        this.accountDAO = accountDAO;
    }

    public Account createAccount(Account account){
        if (((account.getUsername() != null) && (!account.getUsername().isEmpty())) && (account.getPassword().length() >= 4) && (accountDAO.usernameAlreadyExists(account) == null)){
            return this.accountDAO.insertAccount(account);
        }
        return null;
    }

    public Account loginAccount(Account account){
        return this.accountDAO.searchAccount(account);
    }

}
