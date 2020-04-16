package Service.Impl;

import Entity.IncomeRecord;
import Entity.UserAccount;
import Service.DeleteService;

import java.util.ArrayList;

public class DeleteServiceImpl implements DeleteService {
    UserAccount userAccount;
    ArrayList<IncomeRecord> list;
    public DeleteServiceImpl(UserAccount userAccount) {
        this.userAccount = userAccount;
        if(userAccount!=null){
            list = userAccount.getRecordList();
        }
    }
    @Override
    public void DeleteData(IncomeRecord incomeRecord) {
        if(list==null)return;
        double balance = userAccount.getBalance();
        balance -= incomeRecord.getIncome();
        list.remove(incomeRecord);
        userAccount.setBalance(balance);
    }
}
