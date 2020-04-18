package DAO;

import Entity.UserAccount;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.URLDecoder;

public class Exporter implements DataDAO{

    public void start(UserAccount userAccount) {
        try (
                ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(URLDecoder.decode(path,"UTF-8")));
        ){
            oos.writeObject(userAccount);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
