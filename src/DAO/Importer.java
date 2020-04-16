package DAO;

import Entity.UserAccount;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Importer implements DataDAO{
    UserAccount userAccount;
    public UserAccount start() {
        try (
                ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path));
                ){
            userAccount = (UserAccount) ois.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        return userAccount;
    }
}
