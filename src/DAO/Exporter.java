package DAO;

import Entity.IncomeRecord;
import Entity.UserAccount;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Exporter implements DataDAO{

    public void start(UserAccount userAccount) {
        try (
                ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path));
        ){
            oos.writeObject(userAccount);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
