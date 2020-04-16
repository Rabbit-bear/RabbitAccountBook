package Entity;

import java.io.Serializable;
import java.util.ArrayList;

public class UserAccount implements Serializable {
    private static final long serialVersionUID = -8448455212830405726L;
    //个人信息
    private ArrayList<IncomeRecord> RecordList = new ArrayList<>();
    private double balance;//当前金额
    private double target;//每日目标
    //登录信息
    private String username;
    private String password;

    public UserAccount(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setTarget(double target) {
        this.target = target;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public double getTarget() {
        return target;
    }

    public ArrayList<IncomeRecord> getRecordList() {
        return RecordList;
    }

    public double getBalance() {
        return balance;
    }

    @Override
    public String toString() {
        return "UserAccount{" +
                "username='" + username + '\'' +
                ", password='" + password + '\''+
                ",balance=" + balance +
                ", target=" + target +
                '}';
    }
}
