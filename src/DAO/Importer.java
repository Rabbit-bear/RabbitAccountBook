package DAO;

import Entity.UserAccount;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.URLDecoder;

public class Importer implements DataDAO{
    UserAccount userAccount;
    public UserAccount start()  {
        try (
                ObjectInputStream ois = new ObjectInputStream(new FileInputStream(URLDecoder.decode(path,"UTF-8")));
                ){

            userAccount = (UserAccount) ois.readObject();
        }catch (FileNotFoundException e){
            return null;
        }
        catch (IOException e) {
            e.printStackTrace();
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        return userAccount;
    }
}
