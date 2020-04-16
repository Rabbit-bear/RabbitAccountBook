package Service;

import Entity.UserAccount;

public interface SignUpService {
    public UserAccount SignUp(String username, String password);
}
