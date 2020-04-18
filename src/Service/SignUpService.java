package Service;

import Entity.UserAccount;

public interface SignUpService {
    public UserAccount SignUp(String username, double target);
    public UserAccount SignUp(String username, String password);
}
