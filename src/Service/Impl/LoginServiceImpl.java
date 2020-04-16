package Service.Impl;

import Entity.UserAccount;
import Service.LoginService;

public class LoginServiceImpl implements LoginService {
    private UserAccount userAccount;
    private boolean LoginSuccessfully;
    public LoginServiceImpl(UserAccount userAccount) {
        this.userAccount = userAccount;
    }

    @Override
    public boolean Login(String username, String password) {
        LoginSuccessfully=false;
        if(username==null|password==null){
            LoginSuccessfully=false;
        }
        else if(username.equals(userAccount.getUsername())&&
                password.equals(userAccount.getPassword())){
            LoginSuccessfully=true;
        }
        return LoginSuccessfully;
    }
}
