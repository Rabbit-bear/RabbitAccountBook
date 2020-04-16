package Service.Impl;

import Entity.IncomeRecord;
import Entity.UserAccount;
import Service.Function.DateMaker;
import Service.InsertService;

import java.util.ArrayList;

public class InsertServiceImpl implements InsertService {
    private UserAccount userAccount;
    private IncomeRecord incomeRecord;
    ArrayList<IncomeRecord> list;
    public InsertServiceImpl(UserAccount userAccount) {
        this.userAccount = userAccount;
        if(userAccount!=null){
            list = userAccount.getRecordList();
        }
    }

    @Override
    public void insertData(double Income, String note) {
        String date = DateMaker.getDate();
        double balance = userAccount.getBalance();
        //日期相同时
        if(list.size()!=0&&date.equals(list.get(list.size()-1).getDate())){
            incomeRecord = list.get(list.size()-1);
            incomeRecord.setIncome(incomeRecord.getIncome()+Income);
        }else {
            incomeRecord = new IncomeRecord(Income,date, note);
            list.add(incomeRecord);
        }
        balance += Income;
        userAccount.setBalance(balance);
    }
}
