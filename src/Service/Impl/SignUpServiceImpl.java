package Service.Impl;

import Entity.UserAccount;
import Service.SignUpService;
public class SignUpServiceImpl implements SignUpService {
    UserAccount userAccount;
    @Override
    public UserAccount SignUp(String username, double target) {
        userAccount = new UserAccount(username, target);
        return userAccount;
    }

    @Override
    public UserAccount SignUp(String username, String password) {
        userAccount = new UserAccount(username, password);
        return userAccount;
    }
}
